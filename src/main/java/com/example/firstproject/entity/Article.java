package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor  //디폴스 생성자를 추가
@ToString
@Entity // DB가 해당 객체를 인식 가능!
@Getter
public class Article {

    @Id//대표값을 지정! like a 주민등록번호
    @GeneratedValue //1,2,3,....자동생성 어노테이션
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


    }



