package com.mvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.dto.AddPostInput;
import com.mvp.dto.EditPostInput;
import com.mvp.dto.PostListOutput;
import com.mvp.dto.ResponseOutput;
import com.mvp.service.PostService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * blog controller for managing blog requests.
 * @author techversant
 * @version v1
 * @since 2023
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

	@Autowired
	private PostService postService;
	
	/**
	 * @apiNote api for creating blog post.
	 * @return response output object.
	 */
	@PostMapping("/post")
	@Operation(summary = "Create blog post", description = "Api for creating blog post")
	public ResponseEntity<ResponseOutput> createPost(@RequestBody AddPostInput addPostInput ){
		return new ResponseEntity<ResponseOutput>(postService.addPost(addPostInput), HttpStatus.OK);
	}
	
	/**
	 * @apiNote api for editing blog post.
	 * @return response output object.
	 */
	@PutMapping("/post")
	@Operation(summary = "Edit blog post" ,description = "Api for editing blog post")
	public ResponseEntity<ResponseOutput> editPost(@RequestBody EditPostInput editPostInput){
		return new ResponseEntity<ResponseOutput>(postService.editPost(editPostInput), HttpStatus.OK);
	}
	
	/**
	 * @apiNote api for deleting blog post.
	 * @return response output object.
	 */
	@DeleteMapping("/post/{id}")
	@Operation(summary = "Delete blog post" , description = "Api for deleting blog post")
	public ResponseEntity<ResponseOutput> deletePost(@PathVariable(name="id") long postId){
		return new ResponseEntity<ResponseOutput>(postService.deletePost(postId), HttpStatus.OK);
	}
	
	/**
	 * @apiNote api for getting blog post list.
	 * @return post list output object.
	 */
	@GetMapping("/posts")
	@Operation(summary = "Get blog post list", description = "Api for getting blog post list")
	public ResponseEntity<PostListOutput> getPostList(){
		return new ResponseEntity<PostListOutput>(postService.getPostList(), HttpStatus.OK);
	}
}
