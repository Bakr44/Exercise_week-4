package com.example.ex_week4.Controller;

import com.example.ex_week4.Api.ApiResponse;
import com.example.ex_week4.Model.Librarian;
import com.example.ex_week4.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/librarian")
public class LibrarianController {


    private final LibrarianService librarianService;



    @GetMapping("/get")
    public ResponseEntity getAllLibrarians() {

        return ResponseEntity.status(200).body(librarianService.getAlllibrarian());
    }


    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Librarian librarian){
        librarianService.addlibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatelibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian){
        librarianService.updateBook(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id) {
        return ResponseEntity.status(400).body(librarianService.getLibrarianById(id));
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity loginLibrarian(@PathVariable @Valid String username,@PathVariable @Valid String password ) {
        return ResponseEntity.status(200).body(librarianService.checkLogin(username,password));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email) {
            return ResponseEntity.status(200).body(librarianService.getLibrarianByEmail(email));

    }
}
