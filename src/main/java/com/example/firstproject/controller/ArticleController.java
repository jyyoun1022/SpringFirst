package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j  //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired  //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동연결시켜준다!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){

        log.info(form.toString());
        //1.DTO를 변환! Entity로 바꿔라!
        Article article = form.toEntity();

        log.info(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 한다!
        Article saved=articleRepository.save(article);

        log.info(saved.toString());


        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id =" +id);
        //1. id로 데이터를 가져옴(데이터를 가져오는 주체는 리파지토리)
//        Optional<Article> articleEntity= articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록!
        model.addAttribute("article" , articleEntity);
        //3. 보여줄 페이지를 설정!
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 article을 가져온다.
        List<Article> articleEntityList =  articleRepository.findAll();
        // 2. 가져온 article을 view로 전달한다.
        model.addAttribute("articleList",articleEntityList);
        // 3. view페이지를 설정한다.
        return "articles/index";

    }

}
