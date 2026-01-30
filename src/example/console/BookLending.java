package example.console;

import example.entity.*;
import example.entity.enums.BookStatusEnum;

import java.util.Scanner;

public class BookLending {

    public static void lendBook(Scanner scan, Librarian librarian, SingletonLibrary library){


        System.out.println("Kitap seçin:");
        for(Book book: library.getBooks().values()){
            if(book.getStatus().equals(BookStatusEnum.AVAILABLE.getStatus()))
                System.out.println(book.getId() + " - " + book);
        }

        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        long bookSelection = scan.nextLong();

        while (library.getBooks().get(bookSelection) == null){
            System.out.println("Lütfen mevcut bir kitap seçin. Çıkmak için 0'a basın.");
            bookSelection = scan.nextLong();
            if(bookSelection == 0)
                return;
        }


        Book book = library.getBooks().get(bookSelection);
        if(!(book.getStatus().equals(BookStatusEnum.AVAILABLE.getStatus()))){
            scan.nextLine();
            System.out.println(book +" is not available.");
            scan.nextLine();
        }


        System.out.println("Üye numaranızı girin:");

        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        long memberId = scan.nextLong();
        while (library.getReaders().get(memberId) == null){

            System.out.println("Lütfen numaranızı kontrol edin ya da kayıt olun. Çıkmak için 0'a basın.");
            memberId = scan.nextLong();
            if(memberId == 0)
                return;
        }


        LibraryMembers member = library.getReaders().get(memberId);
        int maxBook = member instanceof Student ? 2 : 3;
        if(!(member.getBookCount() < maxBook)){
            scan.nextLine();
            System.out.println("Maksimum kitap sayısına ulaştınız. Devam etmek için ödünç aldığınız bir kitabı geri vermeniz gerekli.");
            scan.nextLine();
            return;
        }


        librarian.issueBook(library.getBooks().get(bookSelection),library.getReaders().get(memberId));

        System.out.println("Toplam ödeme: "+member.getPaymentNeeded() +"\n"+
                "Ödünç alınan toplam kitap sayısı: " + member.getBookCount());


        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();

    }

}
