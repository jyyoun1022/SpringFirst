package com.example.firstproject.api;

import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleApiControllerTest {

    @Autowired
    private ArticleService articleService;

    @Test
    void index() {
    //예상 시나리오
        Article a =new Article(1L,"가가가가","1111");
        Article b =new Article(2L,"나나나나","2222");
        Article c =new Article(3L,"다다다다","3333");
        List<Article> expected = new ArrayList<>(Arrays.asList(a, b, c));

        //실제
        List<Article> articles = articleService.index();

        //비교
        assertEquals(expected.toString(),articles.toString());
   }

    @Test
    void show_성공() {
        //예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        //실제
        Article article = articleService.show(id);
        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    void create() {
        //예상

        //실제

        //비교
    }

    @Test
    void update() {
    }
}