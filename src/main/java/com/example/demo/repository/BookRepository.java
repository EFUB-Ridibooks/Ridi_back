package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.OrderBy;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @EntityGraph(attributePaths = {"author", "category", "publisher"})
    List<Book> findBySectorOrderBySectorDesc(String sector);

    @EntityGraph(attributePaths =  {"author", "category", "publisher"})
    List<Book> findBySectorContainingOrderBySectorAsc(String sector);

    @EntityGraph(attributePaths =  {"author", "category", "publisher"})
    List<Book> findBySectorContainingOrderBySectorDesc(String sector);

    @EntityGraph(attributePaths =  {"author", "category", "publisher"})
    Book findById(int book_id);


//    //db에 조건을 걸어서 가져옴
//    //jpql, query method
//    @EntityGraph(attributePaths = "author") //어디까지 탐색? author까지 얻어오겠다.
//    List<Book> findByOrderBySalesDesc(Pageable pageable);
//
//    @EntityGraph(attributePaths = "author")
//    List<Book> findByOrderByRegisteredDateDescName(Pageable pageable);  //page : limit 조건



}
