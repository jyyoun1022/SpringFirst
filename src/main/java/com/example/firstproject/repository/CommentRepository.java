package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    //1. 특정 게시글의 댓글 목록 조회
    @Query(value = "SELECT * FROM COMMENT WHERE article_id = :articleId",nativeQuery = true)
    List<Comment>findByArticleId(Long articleId);
    //2. 특정 닉네임의 모든 댓글 조회
    @Query()
    List<Comment>findByNickname(String nickname);
}
