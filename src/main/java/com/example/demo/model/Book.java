package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //mysql에서 가장 흔하게 씀
    private Integer no;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_isbn")
    private Long isbn;

    @Column(name = "book_cost")
    private Integer cost;

    @Column(name = "book_score")
    private Integer score;

    @Column(name = "book_intro")
    private String intro;

    @Column(name = "book_desc")
    private String desc;

    @Column(name = "book_promotional")
    private String promotional;

    @Column(name = "book_photo")
    private String photo;

    @Column(name = "book_sales")
    private Integer sales;  //null이 있을 수 있기 때문에.

    @Column(name = "book_registered_date")
    private LocalDateTime registeredDate; //자바 클래스. 날짜는 무조건 이걸 사용.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;    //연관관계가 맺어짐



}
