package com.mvp.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvp.dto.PostInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class PostDao {
	@Autowired
	private EntityManager entityManager;

	public List<PostInfo> findAllPostWithComments() {
		final String sQuery = "SELECT jsonb_agg( "
				+ "    jsonb_build_object( "
				+ "        'postId', p.id, "
				+ "        'title', p.title , "
				+ "        'content', p.content , "
				+ "        'categoryId', c.id , "
				+ "        'categoryName', c.categoryName , "
				+ "        'authorId', a.id , "
				+ "        'authorFirstName', a.firstName , "
				+ "        'authorLastName', a.lastName , "
				+ "        'publishedDate', p.publishedDate , "
				+ "        'tags', p.tags , "
				+ "        'slug', p.slug , "
				+ "        'likesCount', p.likesCount , "
				+ "        'createdDateTime', p.createdDateTime , "
				+ "        'lastUpdatedDateTime', p.lastUpdatedDateTime , "
				+ "        'status', p.status , "
				+ "        'postCommentList', ( "
				+ "            SELECT jsonb_agg( "
				+ "                jsonb_build_object( "
				+ "                    'commentId', pc.id, "
				+ "                    'comment', pc.comment,"
				+ "						'createdDateTime', pc.createdDateTime, "
				+ "						'status', pc.status, "
				+ "						'lastUpdatedDateTime', pc.lastUpdatedDateTime, "
				+ "						'userId', u.id, "
				+ "						'userFirstName', u.firstName, "
				+ "						'userLastName', u.lastName "
				+ "                ) "
				+ "            ) "
				+ "            FROM PostComment pc"
				+ "			   JOIN pc.post as pt "
				+ "			   JOIn pc.user as u"
				+ "            WHERE pt.id = p.id "
				+ "			   group by pc.createdDateTime order by pc.createdDateTime desc"
				+ "        ) "
				+ "    ) "
				+ ") AS postList "
				+ "FROM Post p "
				+ " join p.category as c "
				+ " join p.author as a "
				+ "group by p.id order by p.publishedDate desc";
		Query qry = entityManager.createQuery(sQuery);
		
		List<PostInfo> postInfoList =  qry.getResultList();
		return postInfoList;
		
	}
}
