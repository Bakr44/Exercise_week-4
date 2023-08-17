package com.example.ex_week4.Repostiry;

import com.example.ex_week4.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositry extends JpaRepository<Book,Integer> {


    Book findBookById(Integer id);
List<Book> findByCategory(String Category);

    List<Book> findByNumberOfPagesGreaterThan(int pages);


    List<Book> findByAuthor(String author);


    List<Book> findByTitle(String title);

}
