package com.vti.basicweb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book/")
public class BookController {

    private final BookRepository repo;
    public BookController(BookRepository repo) {
        this.repo = repo;
    }


    @GetMapping("/json")
    public Book bookjson() {
        return new Book(1L, "De men phieu luu ky", "To Hoai");
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Book bookxml() {
        return new Book(1L, "De men phieu luu ky", "To Hoai");
    }
    @GetMapping("/listAll")
    public List<Book> getAll(){
        return repo.createList();
    }


}
