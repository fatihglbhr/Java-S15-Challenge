package example.entity;

import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Librarian  {

    private long id;
    private String name;
    private String password;
    SingletonLibrary library;

    public Librarian(long id, String name, String password) {

        setId(id);
        setName(name);
        setPassword(password);

        library = SingletonLibrary.getInstance();
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public String searchBook(long id) {

        Book book = library.getBooks().get(id);
        if (book != null)
            return book.getTitle() + " şu an " + book.getStatus();

        return id+" numaralı kitap bulunamadı.";
    }


    public String searchBook(String name) {

        for (Book book : library.getBooks().values())
            if (book.getTitle().equals(name))
                return book.getTitle() + " şu an " + book.getStatus();

        return name + " isimli kitap bulunamadı.";
    }

    public List<Book> getBooksByType(BookTypesEnum bookType){

        List<Book> books = new ArrayList<>();
        for(Book book: library.getBooks().values()){

            if(book.getType().equals(bookType)){
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> getBooksByAuthor(Author author){

        List<Book> books = new ArrayList<>();
        for(Book book: library.getBooks().values()){

            if(book.getAuthor().equals(author)){
                books.add(book);
            }
        }
        return books;
    }

    public void issueBook(Book book, LibraryMembers member){

        book.updateStatus(BookStatusEnum.BORROWED);
        library.getLentBooksList().put(book.getId(),member);
        member.increment();
        if(member instanceof Student){
            member.setPaymentNeeded(member.getPaymentNeeded() + book.getPrice()/2);
        } else {
            member.setPaymentNeeded(member.getPaymentNeeded() + book.getPrice());
        };
        System.out.println(book + " ödünç verildi.");

    }

    public void returnBook(Book book){
        LibraryMembers member = library.getLentBooksList().get(book.getId());
        library.getLentBooksList().remove(book.getId());
        book.updateStatus(BookStatusEnum.AVAILABLE);
        member.decrement();
        member.setPaymentNeeded(member.getPaymentNeeded() - book.getPrice());
        System.out.println(book + " iade edildi.");
    }

    public void deleteBook(long id){
            library.getLentBooksList().remove(id);
            library.getBooks().remove(id);
        System.out.println(id+" numaralı kitap sistemden silindi.");
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) return true;

        if(obj == null || obj.getClass() != getClass()) return false;

        Librarian librarian = (Librarian)obj;
        
        return librarian.id == id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}





