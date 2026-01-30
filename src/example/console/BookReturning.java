package example.console;

import example.entity.Book;
import example.entity.Librarian;
import example.entity.SingletonLibrary;

import java.util.Scanner;

public class BookReturning {

    public static void returnBook(Scanner scan, Librarian librarian, SingletonLibrary library){

        if(library.getLentBooksList().isEmpty()){
            System.out.println("Şu an iade edilebilecek bir kitap yok. \n*** Başa dönmek için ENTER'a basın! ***");
            scan.nextLine();
            return;
        }


        System.out.println("İade etmek istediğiniz kitabı seçin:");

        for(Book book: library.getBooks().values()){
            if(library.getLentBooksList().containsKey(book.getId()))
                System.out.println(book.getId() + " - " + book);
        }

        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        long bookSelection = scan.nextLong();
        while (!(library.getLentBooksList().containsKey(bookSelection))){
            System.out.println("Lütfen kitap numaranızı kontrol edin. Çıkmak için 0'a basın.");
            bookSelection = scan.nextLong();
            if(bookSelection == 0)
                return;
        }
        Book book = library.getBooks().get(bookSelection);

        librarian.returnBook(book);
        System.out.println(book.getPrice() + " iade edildi.");
        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();

    }


}
