package example.entity;

import java.util.HashMap;
import java.util.Map;

public class Reader extends Person{

    private final Map<Long, Book> bookList;

    public Reader(String name, String address, String phone) {
        super(name, address,phone);
        bookList = SingletonLibrary.getInstance().getBooks();
    }

    public void purchaseBook(long key, Book book){

        bookList.put(key, book);
    }


    //[TODO] add library interaction
    public void borrowBook(long key, Book book){


    }

    public void returnBook(long key){


    }

    public Book showBook(long key){

        return bookList.get(key);
    }
}
