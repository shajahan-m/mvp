package com.mvp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.common.entity.PostComment;

/**
 * repository interface for blog post comment.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
