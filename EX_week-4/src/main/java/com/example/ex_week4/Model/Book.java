package com.example.ex_week4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title can't be Empty")
    private String title;

    @NotEmpty(message = "Author can't be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "Category can't be Empty")
    @Column(columnDefinition = "varchar(20) not null check(category='Mystery' or category='Novel' or category='Academic ')")
    private String category;


    private Integer isbn;

    @Min(value = 50, message = "Number of pages must be at least 50")
    private Integer numberOfPages;


}
