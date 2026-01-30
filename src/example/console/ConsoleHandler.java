package example.console;

import example.entity.*;
import example.entity.enums.BookStatusEnum;

import java.util.Scanner;

public class ConsoleHandler {

    public static void ConsoleStarter(){
        Librarian librarian = SingletonLibrary.getInstance().getLibrarian();
        SingletonLibrary library = SingletonLibrary.getInstance();
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("1-Kitap Ekle\n" +
                    "2-Kitap Ara\n" +
                    "3-Kitap Güncelle\n" +
                    "4-Kitap Sil\n" +
                    "5-Kategoriye göre listele\n" +
                    "6-Yazara göre listele\n" +
                    "7-Kitap ödünç al\n" +
                    "8-Kitap iade et\n" +
                    "9-Çıkış");



            while(scan.hasNextInt()){
                System.out.println("Lütfen bir işlem seçin.");
                scan.next();
            }

            int option = scan.nextInt();

            scan.nextLine();

            switch (option){
                case 1: {

                    AddBook.addBook(scan, library);

                    break;

                }
                case 2: {

                    SearchTasks.searchBook(scan,librarian);

                    break;

                }
                case 3: {

                    ModifyingTasks.updateBook(scan,librarian,library);

                    break;

                }
                case 4: {

                    ModifyingTasks.deleteBook(scan,librarian,library);

                    break;

                }
                case 5:{

                    SearchTasks.searchByType(scan,librarian);

                    break;

                }
                case 6:{

                    SearchTasks.searchByAuthor(scan,librarian,library);

                    break;

                }
                case 7:{

                    BookLending.lendBook(scan,librarian,library);

                    break;

                }
                case 8:{

                    BookReturning.returnBook(scan,librarian,library);

                    break;

                }
                case 9:{

                    System.exit(0);

                }
            }

        }



    }
}
