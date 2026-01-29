package example.entity;

import java.util.*;

public class Author extends Person {

    private long id;
    private final Map<Long, Book> bookList;

    public Author(long id, String name,  String address, String phone) {
        super(name,address,phone);
        setId(id);
        SingletonLibrary.getInstance().getAuthorsList().put(id,this);
        bookList = SingletonLibrary.getInstance().getBooks();
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void newBook(Book book){
        bookList.put(book.getId(), book);
    }

    public Book showBook(Long key){

        Book book = bookList.get(key);
        if(book.getAuthor() == this)
            return book;
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass()!=getClass())
            return false;

        Author author = (Author) obj;
        return author.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString(){

        return getName();
    }
}
