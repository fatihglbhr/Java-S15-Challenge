package example.entity;

import java.util.HashMap;
import java.util.Map;

public class Reader extends Person{

    private final Map<Integer, Book> books;

    public Reader(String name) {
        super(name);
        books = new HashMap<>();
    }

    public void purchaseBook(int key, Book book){

        books.put(key, book);
    }


    //[TODO] add library interaction
    public void borrowBook(int key, Book book){

        books.put(key,book);
    }

    public void returnBook(int key){

        books.remove(key);
    }

    public Book showBook(int key){

        return books.get(key);
    }
}
