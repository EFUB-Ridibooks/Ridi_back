package com.example.demo.controller;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@AllArgsConstructor //전체 필드의 생성자를 자동으로 만들어 줌
@RequiredArgsConstructor
@RestController
public class RidibooksController {


    private final AuthorRepository authorRepository;


    private final BookRepository bookRepository;



    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/bestsellers")
    public List<Book> getBestsellers(@RequestParam int size){
        return bookRepository.findByOrderBySalesDesc(PageRequest.of(0, size));
    }

    @GetMapping("/newbooks")
    public List<Book> getNewbooks(@RequestParam int size){
        return bookRepository.findByOrderByRegisteredDateDescName(PageRequest.of(0, size));
    }
}
