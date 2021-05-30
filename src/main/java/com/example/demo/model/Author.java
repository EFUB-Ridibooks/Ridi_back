package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author") //없어도 상관은 없음
public class Author {
    @Column(name = "author_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name = "author_name")
    private String name;
}
