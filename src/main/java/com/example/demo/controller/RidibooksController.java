package com.example.demo.controller;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@AllArgsConstructor //전체 필드의 생성자를 자동으로 만들어 줌
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="*")
public class RidibooksController {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    //책 한 권 클릭했을 때
    @GetMapping("/book/{book_id}")
    public Book getBookInfo(@PathVariable("book_id") int book_id) {
        return bookRepository.findById(book_id);
    }

    @GetMapping("/books/new")
    public List<Book> getNewBooks() {
        return bookRepository.findBySectorContainingOrderBySectorAsc("1");
    }

    @GetMapping("/books/hot")
    public List<Book> getHotBooks(){
        return bookRepository.findBySectorOrderBySectorDesc("2");
    }

    @GetMapping("/books/today")
    public List<Book> getTodayBooks(){
        return bookRepository.findBySectorContainingOrderBySectorAsc("3");
    }

    @GetMapping("/books/bestseller")
    public List<Book> getBestsellers(){
        return bookRepository.findBySectorContainingOrderBySectorDesc("4");
    }

    @GetMapping("/books/thisWeek")
    public List<Book> getThisWeekBooks(){
        return bookRepository.findBySectorContainingOrderBySectorDesc("5");
    }

    @GetMapping("/books/modern")
    public List<Book> getModernBooks(){
        return bookRepository.findBySectorContainingOrderBySectorAsc("6");
    }

    @GetMapping("/books/hobby")
    public List<Book> getHobbyBooks(){
        return bookRepository.findBySectorContainingOrderBySectorDesc("7");
    }



    //한 페이지의 정보를 한번에 내릴 때
    @GetMapping("books/all")
    public Map<String,List<Book>> getAll(){
        Map<String, List<Book>> result = new HashMap<>();
        result.put("newest", bookRepository.findBySectorOrderBySectorDesc("1"));
        result.put("now", bookRepository.findBySectorOrderBySectorDesc("2"));
        return result;
    }




//    @GetMapping("/authors")
//    public List<Author> getAuthors(){
//        return authorRepository.findAll();
//    }
//
//    @GetMapping("/bestsellers")
//    public List<Book> getBestsellers(@RequestParam int size){
//        return bookRepository.findByOrderBySalesDesc(PageRequest.of(0, size));
//    }
//
//    @GetMapping("/newbooks")
//    public List<Book> getNewbooks(@RequestParam int size){
//        return bookRepository.findByOrderByRegisteredDateDescName(PageRequest.of(0, size));
//    }


//    @GetMapping("/books/newest")
//    public List<Book> getNewestBooks(){
//        return  bookRepository.findBySector("1");
//    }


}
