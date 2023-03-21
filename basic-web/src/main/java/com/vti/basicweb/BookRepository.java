package com.vti.basicweb;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookRepository {
    public List<Book> createList(){
        return List.of(
                new Book(1L,"Tat den","Tat To"),
                new Book(2L,"Bi vo","Nguyen Hong"),
                new Book(3L,"Hary Poter","J.K.Rowling")
        );
    }


}
