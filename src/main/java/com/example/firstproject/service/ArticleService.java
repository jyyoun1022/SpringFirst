package com.example.firstproject.service;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service    //서비스 객체를 스프링 부트에 생성
public class ArticleService {
    //리파지토리와 협업할수 있도록 필드를 추가
    @Autowired
    private ArticleRepository articleRepository;


    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }


    public Article create(ArticleForm form) {
        Article article = form.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm form) {
        //1. 수정용 엔티티 생성
        Article article = form.toEntity();
        //2. 대상 엔티티 찾기
        Article target = articleRepository.findById(id).orElse(null);
        //3. 잘못된 요청 처리(대상이 없거나 ,id가 다를때)
        if (target == null || id != article.getId()) {
            return null;
        }
        //4. 업데이트
        Article updated = articleRepository.save(target);
        return updated;


    }

    public Article delete(Long id) {
        //1.대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        //1-1 잘못된 요청처리
        if (target == null) {
            return null;
        }
        //2.대상 삭제
        articleRepository.delete(target);
        return target;
    }
    @Transactional// 해당 메서드를 트랜잭션으로 묶는다.
    public List<Article> createAticles(List<ArticleForm> dtos) {
        // 1. dto 묶음을 entity묶음으로 변환
        List<Article> articleList = dtos.stream().map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        // 2. entity묶음을 DB로 저장
        articleList.stream().forEach(i -> articleRepository.save(i));
        // 3. 강제 예외 발생
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("결제 실패")
        );
        //4. 결과값 반환
        return articleList;
    }
}
