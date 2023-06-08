package com.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mvp.common.dao.PostDao;
import com.mvp.common.entity.Category;
import com.mvp.common.entity.Post;
import com.mvp.common.entity.User;
import com.mvp.common.enums.Enums;
import com.mvp.common.repository.PostRepository;
import com.mvp.dto.AddPostInput;
import com.mvp.dto.EditPostInput;
import com.mvp.dto.PostInfo;
import com.mvp.dto.PostListOutput;
import com.mvp.dto.ResponseOutput;
import com.mvp.error.ErrorCodes;
import com.mvp.utils.DateUtils;

/**
 * service class for blog post.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostDao postDao;

	/**
	 * this method for adding post.
	 * @param addpostinput object.
	 * @return response output object.
	 */
	public ResponseOutput addPost(AddPostInput addPostInput) {
		ResponseOutput responseOutput = new ResponseOutput();
		Post post = new Post();
		Category category = categoryService.getCategory(addPostInput.getCategoryId());
		if (category == null) {
			responseOutput.setErrorCode(ErrorCodes.NOT_FOUND);
			responseOutput.setErrorMessage("Enter category id");
			return responseOutput;
		}
		User author = userService.getUser(addPostInput.getAuthorId());
		if (author == null) {
			responseOutput.setErrorCode(ErrorCodes.NOT_FOUND);
			responseOutput.setErrorMessage("Enter author id");
			return responseOutput;

		}

		post.setTitle(addPostInput.getTitle());
		post.setContent(addPostInput.getContent());
		post.setCategory(category);
		post.setAuthor(author);
		post.setTags(addPostInput.getTags());
		post.setSlug(addPostInput.getSlug());
		post.setCreatedDateTime(DateUtils.getCurrentDateWithTime());
		post.setLastUpdatedDateTime(DateUtils.getCurrentDateWithTime());
		post.setStatus(Enums.PostStatus.DRAFT.ordinal());
		if (postRepository.save(post) != null) {
			responseOutput.setErrorCode(ErrorCodes.SUCCESS);
			responseOutput.setErrorMessage("Successfully post created");
		} else {
			responseOutput.setErrorCode(ErrorCodes.INSERT_FAILED);
			responseOutput.setErrorMessage("Sorry, could not create post");
		}
		return responseOutput;
	}

	/**
	 * this method for editing post.
	 * @param editpostinput object.
	 * @return response output object.
	 */
	public ResponseOutput editPost(EditPostInput editPostInput) {
		ResponseOutput responseOutput = new ResponseOutput();
		if (editPostInput.getPostId() > 0) {
			Post post = postRepository.findById(editPostInput.getPostId()).orElse(null);
			if (post == null) {
				responseOutput.setErrorCode(ErrorCodes.NOT_FOUND);
				responseOutput.setErrorMessage("Enter valid post id");
				return responseOutput;
			}
			Category category = categoryService.getCategory(editPostInput.getCategoryId());
			if (category == null) {
				responseOutput.setErrorCode(ErrorCodes.NOT_FOUND);
				responseOutput.setErrorMessage("Enter category id");
				return responseOutput;
			}
			User author = userService.getUser(editPostInput.getAuthorId());
			if (author == null) {
				responseOutput.setErrorCode(ErrorCodes.NOT_FOUND);
				responseOutput.setErrorMessage("Enter author id");
				return responseOutput;

			}

			post.setTitle(editPostInput.getTitle());
			post.setContent(editPostInput.getContent());
			post.setCategory(category);
			post.setAuthor(author);
			post.setTags(editPostInput.getTags());
			post.setSlug(editPostInput.getSlug());
			post.setLastUpdatedDateTime(DateUtils.getCurrentDateWithTime());
			if (postRepository.save(post) != null) {
				responseOutput.setErrorCode(ErrorCodes.SUCCESS);
				responseOutput.setErrorMessage("Successfully post updated");
			} else {
				responseOutput.setErrorCode(ErrorCodes.UPDATE_FAILED);
				responseOutput.setErrorMessage("Sorry, could update post");
			}
		} else {
			responseOutput.setErrorCode(ErrorCodes.INVALID);
			responseOutput.setErrorMessage("Post id missing");
		}

		return responseOutput;
	}

	/**
	 * this method for deleting post.
	 * @param post id.
	 * @return response output object.
	 */
	public ResponseOutput deletePost(long postId) {
		ResponseOutput responseOutput = new ResponseOutput();
		if (postRepository.existsById(postId)) {
			postRepository.deleteById(postId);
			responseOutput.setErrorCode(ErrorCodes.SUCCESS);
			responseOutput.setErrorMessage("Success");
		} else {
			responseOutput.setErrorCode(ErrorCodes.INVALID);
			responseOutput.setErrorMessage("Enter valid post id");
		}
		return responseOutput;
	}

	/**
	 * this method for getting post list.
	 * @return post list output object.
	 */
	public PostListOutput getPostList() {
		PostListOutput postListOutput = new PostListOutput();
		List<PostInfo> postInfoList = postDao.findAllPostWithComments();
		//List<Post> postList = postRepository.findAll(Sort.by("publishedDate").descending());
		if (!postInfoList.isEmpty()) {
			postListOutput.setErrorCode(ErrorCodes.SUCCESS);
			postListOutput.setErrorMessage("Success");
			postListOutput.setPostList(postInfoList);
		} else {
			postListOutput.setErrorCode(ErrorCodes.NOT_FOUND);
			postListOutput.setErrorMessage("No posts found");
		}
		return postListOutput;
	}

}
