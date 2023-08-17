package com.example.ex_week4.Repostiry;

import com.example.ex_week4.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepositry extends JpaRepository<Librarian,Integer> {


    Librarian findByIdIs(Integer id);

    Librarian findByUsernameAndPassword(String username, String password);

    Librarian findByEmail(String email);


}
