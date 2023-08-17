package com.example.ex_week4.Controller;

import com.example.ex_week4.Api.ApiResponse;
import com.example.ex_week4.Model.Book;
import com.example.ex_week4.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {


    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Coffee Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody @Valid Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }


    @GetMapping("/category/{category}")
    public ResponseEntity getBooksByCategory(@PathVariable String category) {
        return ResponseEntity.status(200).body(bookService.getAllBooksByCategory(category));
    }

    @GetMapping("/pages/{pages}")
    public ResponseEntity getBooksByPages(@PathVariable int minPages) {
        return ResponseEntity.status(200).body(bookService.getAllBooksPageThan(minPages));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.status(200).body(bookService.findByAuthor(author));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity searchBooksByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(bookService.findByTitle(title));
    }

}

