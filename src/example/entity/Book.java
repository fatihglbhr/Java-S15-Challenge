package example.entity;

import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;
import java.util.Objects;

public  class Book {

    private long id;
    private Author author;
    private String name;
    private double price;
    private BookStatusEnum status;
    private String edition;
    private BookTypesEnum type;

    public Book(long id,
                Author author,
                String name,
                double price,
                BookTypesEnum type
                ){
        setId(id);
        setAuthor(author);
        setName(name);
        setPrice(price);
        setType(type);
        setStatus(BookStatusEnum.AVAILABLE);
        SingletonLibrary.getInstance().getBooks().put(id,this);
    }

    public Book(long id,
                Author author,
                String name,
                double price,
                BookStatusEnum status,
                String edition,
                BookTypesEnum type
                ){

        this(id,author,name,price,type);
        setEdition(edition);
        SingletonLibrary.getInstance().getBooks().put(id,this);
    }

    public String getTitle(){

        return name;
    }

    public double getPrice() {

        return price;
    }

    public Author getAuthor(){

        return author;
    }

    public long getId(){

        return id;
    }

    public String getStatus(){

        return status.getStatus();
    }

    public BookTypesEnum getType() {
        return type;
    }

    public void updateStatus(BookStatusEnum status){
        this.status = status;

    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setStatus(BookStatusEnum status) {

        this.status = status;
    }

    public void setAuthor(Author author) {

        this.author = author;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setType(BookTypesEnum type) {

        this.type = type;
    }

    public void setEdition(String edition) {

        this.edition = edition;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass()!=getClass())
            return false;

        Book book = (Book) obj;
        return book.id == this.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " by " + author;
    }
}
