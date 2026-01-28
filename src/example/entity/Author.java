package example.entity;

import java.util.*;

public class Author extends Person {

    private final Map<Integer, Book> books;

    public Author(String name) {
        super(name);
        books = new HashMap<>();
    }

    public void newBook(int key, Book book){

        books.put(key, book);
    }

    public Book showBook(int key){

        return books.get(key);
    }
}
