package com.example.firstproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne//해당 댓글 엔티티 여러개가 하나의 Article에 연관된다.
    @JoinColumn(name = "article_id")// "articleid" 컬럼 Article의 대표값을 저장
    private Article article;

    private String nickName;

    private String body;
}
