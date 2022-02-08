package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ArticleForm {


    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null,title,content);

    }
}
