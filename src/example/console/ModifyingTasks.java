package example.console;

import example.entity.Author;
import example.entity.Book;
import example.entity.Librarian;
import example.entity.SingletonLibrary;
import example.entity.enums.BookTypesEnum;

import java.util.Scanner;

public class ModifyingTasks {

    public static void deleteBook(Scanner scan, Librarian librarian, SingletonLibrary library){

        System.out.println("Silmek istediğiniz kitabı seçin:");
        for(Book book: library.getBooks().values()){
            System.out.println(book.getId() + " - " + book);
        }
        long bookSelection = scan.nextLong();
        while (library.getBooks().get(bookSelection) == null){
            System.out.println("Lütfen mevcut bir kitap seçin. Çıkmak için 0'a basın.");
            bookSelection = scan.nextLong();
            if(bookSelection == 0)
                System.exit(0);
        }

        librarian.deleteBook(bookSelection);
        scan.nextLine();
        System.out.println("*** Başa dönmek için ENTER'a basın! ***");
        scan.nextLine();
    }

    public static void updateBook(Scanner scan, Librarian librarian, SingletonLibrary library){

        System.out.println("Güncellemek istediğiniz kitabı seçin:");
        for(Book book: library.getBooks().values()){
            System.out.println(book.getId() + " - " + book);
        }

        long bookSelection = scan.nextLong();
        while (library.getBooks().get(bookSelection) == null){
            System.out.println("Lütfen mevcut bir kitap seçin. Çıkmak için 0'a basın.");
            bookSelection = scan.nextLong();
            if(bookSelection == 0)
                return;
        }

        Book book = library.getBooks().get(bookSelection);

        System.out.println("Güncellemek istediğiniz özelliği seçin:\n" +
                "1- Yazar" +
                "2- İsim" +
                "3- Fiyat" +
                "4- Baskı" +
                "5- Tür");

        while(!scan.hasNextInt()){
            System.out.println("Lütfen sayı girin:");
            scan.next();
        }

        int selection = scan.nextInt();
        System.out.println("Yeni değer:");
        switch (selection){
            case 1:{

                int i=1;
                for(Author author: library.getAuthorsList().values()){
                    System.out.println(i + " - "+ author);
                    i++;
                }

                while(!scan.hasNextLong()){
                    System.out.println("Lütfen sayı girin:");
                    scan.next();
                }

                long id = scan.nextLong();
                book.setAuthor(library.getAuthorsList().get(id));
                scan.nextLine();
                System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                scan.nextLine();
            }

            case 2:{

                String newName = scan.next();
                book.setName(newName);

                scan.nextLine();
                System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                scan.nextLine();
            }

            case 3:{

                while(!scan.hasNextDouble()){
                    System.out.println("Lütfen sayı girin:");
                    scan.next();
                }

                double newPrice = scan.nextDouble();
                book.setPrice(newPrice);

                scan.nextLine();
                System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                scan.nextLine();
            }

            case 4:{

                String newEdition = scan.next();
                book.setEdition(newEdition);

                scan.nextLine();
                System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                scan.nextLine();
            }

            case 5:{
                int i = 1;
                for(BookTypesEnum type: BookTypesEnum.values()){
                    System.out.println(i + " - " + type.getType());
                    i++;
                }

                while(!scan.hasNextInt()){
                    System.out.println("Lütfen sayı girin:");
                    scan.next();
                }

                selection = scan.nextInt();
                book.setType(BookTypesEnum.values()[selection-1]);

                scan.nextLine();
                System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                scan.nextLine();
            }
            default:
                break;
        }


    }

}
