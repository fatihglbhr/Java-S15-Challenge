package example.entity;

import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;

import java.util.ArrayList;
import java.util.List;

public class Librarian {

    private String name;
    private String password;
    SingletonLibrary library;

    public Librarian(String name, String password) {

        this.name = name;
        this.password = password;

        library = SingletonLibrary.getInstance();
    }

    public String searchBook(long id) {

        Book book = library.getBooks().get(id);
        if (book != null)
            return book.getTitle() + " is " + book.getStatus();

        return "Book with ID " +id + " not found.";
    }


    public String searchBook(String name) {

        for (Book book : library.getBooks().values())
            if (book.getTitle().equals(name))
                return book.getTitle() + " is " + book.getStatus();

        return "Book titled " + name + " not found.";
    }

    public String searchBook(Author author) {

        for (Book book : library.getBooks().values())
            if (book.getAuthor() == author)
                return book.getTitle() + " is " + book.getStatus();

        return author.getName() + " not found.";
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

    public Boolean verifyMember(long id){

        return library.getReaders().containsKey(id);
    }

    public void issueBook(Book book, MemberRecord member){

        book.updateStatus(BookStatusEnum.BORROWED);
        library.getLentBooksList().put(book.getId(),member);
        member.increment();
        member.setPaymentNeeded(member.getPaymentNeeded() + book.getPrice());
        System.out.println(book + " lent successfully.");

    }

    public void returnBook(Book book){
        MemberRecord member = library.getLentBooksList().get(book.getId());
        library.getLentBooksList().remove(book.getId());
        book.updateStatus(BookStatusEnum.AVAILABLE);
        member.decrement();
        member.setPaymentNeeded(member.getPaymentNeeded() - book.getPrice());
        System.out.println(book + " returned successfully.");
    }

    public void deleteBook(long id){
            library.getLentBooksList().remove(id);
            library.getBooks().remove(id);
        System.out.println(id+"ID'li kitap sistemden silindi.");
    }


}





