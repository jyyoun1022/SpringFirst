package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired  //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동연결시켜준다!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        //1.DTO를 변환! Entity로 바꿔라!
        Article article = form.toEntity();
        System.out.println(article);

        //2. Repository에게 Entity를 DB안에 저장하게 한다!
        Article saved=articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }

}
