package example.console;

import example.entity.Author;
import example.entity.Book;
import example.entity.SingletonLibrary;
import example.entity.enums.BookTypesEnum;

import java.util.Scanner;

public class AddBook {

    public static void addBook(Scanner scan, SingletonLibrary library){

        System.out.println("ID:");
        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }
        long id = scan.nextLong();

        System.out.println("Yazar:");

        int i=1;
        for(Author author: library.getAuthorsList().values()){
            System.out.println(i + " - "+ author);
            i++;
        }
        while(!scan.hasNextLong()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }
        long entry = scan.nextLong();
        Author author = library.getAuthorsList().get(entry);

        System.out.println("Kitap adı:");
        scan.nextLine();
        String name = scan.nextLine();

        System.out.println("Fiyat:");
        while(!scan.hasNextDouble()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }
        double price = scan.nextDouble();

        System.out.println("Tür:");
        i = 1;
        for(BookTypesEnum type: BookTypesEnum.values()){
            System.out.println(i + " - " + type.getType());
            i++;
        }
        while(!scan.hasNextInt()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        BookTypesEnum type = BookTypesEnum.values()[scan.nextInt()];

        new Book(id,author,name,price,type);

        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();

    }

}
