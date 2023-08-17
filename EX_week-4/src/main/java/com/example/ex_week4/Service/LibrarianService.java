package com.example.ex_week4.Service;

import com.example.ex_week4.Api.ApiExeption;
import com.example.ex_week4.Model.Book;
import com.example.ex_week4.Model.Librarian;
import com.example.ex_week4.Repostiry.LibrarianRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepositry librarianRepositry;
    public List<Librarian> getAlllibrarian(){
        return librarianRepositry.findAll();
    }

    public void addlibrarian(Librarian librarian){
        librarianRepositry.save(librarian);
    }

    public void updateBook(Integer id, Librarian librarian){
        Librarian librarian1= librarianRepositry.findByIdIs(id);

        if (librarian1==null){
            throw new ApiExeption("id not found");
        }
        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        librarianRepositry.save(librarian1);
    }

    public void deleteLibrarian(Integer id){
        Librarian librarian1=librarianRepositry.findByIdIs(id);
        if (librarian1==null){
            throw new ApiExeption("id not found");
        }
        librarianRepositry.delete(librarian1);
    }

    public Librarian getLibrarianById(Integer id) {
        return librarianRepositry.findByIdIs(id);
    }

    public Librarian getLibrarianByEmail(String email) {
        return librarianRepositry.findByEmail(email);
    }

    public boolean checkLogin(String username, String password) {
        Librarian librarian = librarianRepositry.findByUsernameAndPassword(username, password);
        return librarian != null;
    }
}
