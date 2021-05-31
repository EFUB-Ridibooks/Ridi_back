package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "ctg")
public class Category {

    @Column(name = "ctg_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙. AI됨.
    private Long no;

    @Column(name = "ctg_name")
    private String name;
}
