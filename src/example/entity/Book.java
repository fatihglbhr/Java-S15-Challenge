package example.entity;

import java.util.Date;
import java.util.Objects;

public  class Book {

    private final long bookId;
    private final Author author;
    private final String name;
    private double price;

    //Status might be ENUM - Will decide - Borrowed - Purchased - In Library
    private String status;
    private final String edition;
    private Date dateOfPurchase;

    public Book(long bookId,
                Author author,
                String name,
                double price,
                String status,
                String edition,
                Date dateOfPurchase
                ){

        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;

    }

    public String getTitle(){

        return name;
    }

    public Author getAuthor(){

        return author;
    }

    public void changeOwner(){

    }

    public String getOwner(){

        return "";
    }

    public void updateStatus(){


    }



    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book book)) return false;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return name + " by " + author;
    }
}
