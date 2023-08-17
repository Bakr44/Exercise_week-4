package com.example.ex_week4.Service;

import com.example.ex_week4.Api.ApiExeption;
import com.example.ex_week4.Model.Book;
import com.example.ex_week4.Repostiry.BookRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepositry bookRepositry;

    public List<Book> getAllBooks(){
        return bookRepositry.findAll();
    }

    public void addBook(Book book){
        bookRepositry.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book book1= bookRepositry.findBookById(id);

        if (book1==null){
            throw new ApiExeption("id not found");
        }
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setIsbn(book.getIsbn());
        book1.setNumberOfPages(book.getNumberOfPages());
        bookRepositry.save(book1);
    }

    public void deleteBook(Integer id){
        Book book1=bookRepositry.findBookById(id);
        if (book1==null){
            throw new ApiExeption("id not found");
        }
        bookRepositry.delete(book1);
    }

    public List<Book> getAllBooksByCategory(String category){
        return bookRepositry.findByCategory(category);
    }


    public List<Book> getAllBooksPageThan(Integer pages){
        return bookRepositry.findByNumberOfPagesGreaterThan(pages);
    }

    public List<Book> findByAuthor(String author){
        return bookRepositry.findByAuthor(author);
    }

    public List<Book> findByTitle(String title){
        return bookRepositry.findByTitle(title);
    }



}
