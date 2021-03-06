package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {//대표값ID의 자료형을 적는다.


    @Override
    ArrayList<Article> findAll();
}
