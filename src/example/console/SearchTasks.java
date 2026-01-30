package example.console;

import example.entity.Author;
import example.entity.Book;
import example.entity.Librarian;
import example.entity.SingletonLibrary;
import example.entity.enums.BookTypesEnum;

import java.util.Scanner;

public class SearchTasks {

    public static void searchBook(Scanner scan, Librarian librarian){

        System.out.println("Kitap ID'si ya da ismi girin");
        String entry = scan.next();

        if(!entry.replaceAll("[0-9]","").isBlank()) {
            System.out.println(librarian.searchBook(entry));
        } else {
            System.out.println(librarian.searchBook(Long.parseLong(entry)));
        }

        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();
    }

    public static void searchByType(Scanner scan, Librarian librarian){

        System.out.println("Tür seçin:");
        int i = 1;
        for(BookTypesEnum type: BookTypesEnum.values()){
            System.out.println(i + " - " + type.getType());
            i++;
        }

        while(!scan.hasNextInt()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        int type = scan.nextInt();
        while(type > BookTypesEnum.values().length || type <= 0){
            System.out.println("Lütfen mevcut bir tür seçin:");
            type = scan.nextInt();
        }
        for(Book book: librarian.getBooksByType(BookTypesEnum.values()[type-1]))
            System.out.println(book);

        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();
    }

    public static void searchByAuthor(Scanner scan, Librarian librarian, SingletonLibrary library){

        System.out.println("Yazar seçin:");
        int i=1;
        for(Author author: library.getAuthorsList().values()){
            System.out.println(i + " - "+ author);
            i++;
        }

        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }


        Author author = library.getAuthorsList().get(scan.nextLong());
        while (author == null){
            System.out.println("Lütfen mevcut bir yazar seçin:");
            author = library.getAuthorsList().get(scan.nextLong());
        }
        for(Book book: librarian.getBooksByAuthor(author)){
            System.out.println(book);
        }
        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();

    }
}
