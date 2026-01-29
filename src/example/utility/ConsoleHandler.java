package example.utility;

import example.entity.*;
import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;

import java.util.Scanner;

public class ConsoleHandler {

    public void ConsoleStarter(){
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
                    "8-Kitap iade et");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1: {
                    //KİTAP EKLE

                }
                case 2: {
                    System.out.println("Kitap ID'si ya da ismi girin");
                    String entry = scan.next();
                    if(entry.replaceAll("[^a-zA-Z]","").isBlank()) {
                        System.out.println(librarian.searchBook(Long.parseLong(entry)));
                    } else {
                        System.out.println(librarian.searchBook(entry));
                    }
                    scan.nextLine();
                    System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                    scan.nextLine();
                    break;
                }
                case 3: {
                    //KİTAP GÜNCELLE
                }
                case 4: {
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
                    break;
                }
                case 5:{
                    System.out.println("Tür seçin: \n" +
                            "1-Journal\n" +
                            "2-Study Books\n" +
                            "3-Magazine");
                    int entry = scan.nextInt();
                    for(Book book: librarian.getBooksByType(BookTypesEnum.values()[entry-1]))
                        System.out.println(book);
                    scan.nextLine();
                    System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                    scan.nextLine();
                    break;
                }
                case 6:{
                    System.out.println("Yazar seçin: \n" +
                            "1-Yazar 1\n" +
                            "2-Yazar 2");
                    long entry = scan.nextLong();
                    for(Book book: librarian.getBooksByAuthor(library.getAuthorsList().get(entry))){
                        System.out.println(book);
                    }
                    scan.nextLine();
                    System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                    scan.nextLine();
                    break;
                }
                case 7:{
                    System.out.println("Kitap seçin:");
                    for(Book book: library.getBooks().values()){
                        if(book.getStatus().equals(BookStatusEnum.AVAILABLE.getStatus()))
                            System.out.println(book.getId() + " - " + book);
                    }
                    long bookSelection = scan.nextLong();
                    while (library.getBooks().get(bookSelection) == null){
                        System.out.println("Lütfen mevcut bir kitap seçin. Çıkmak için 0'a basın.");
                        bookSelection = scan.nextLong();
                        if(bookSelection == 0)
                            System.exit(0);
                    }
                    Book book = library.getBooks().get(bookSelection);
                    if(!(book.getStatus().equals(BookStatusEnum.AVAILABLE.getStatus()))){
                        scan.nextLine();
                        System.out.println(book +" is not available.");
                        scan.nextLine();
                        break;
                    }


                    System.out.println("Üye numaranızı girin:");
                    long memberId = scan.nextLong();
                    while (library.getReaders().get(memberId) == null){

                        System.out.println("Lütfen numaranızı kontrol edin ya da kayıt olun. Çıkmak için 0'a basın.");
                        memberId = scan.nextLong();
                        if(memberId == 0)
                            System.exit(0);
                    }
                    MemberRecord member = library.getReaders().get(memberId);
                    if(!(member.getBookCount() < 2)){
                        scan.nextLine();
                        System.out.println("You can't borrow anymore books. Please return a borrowed first.");
                        scan.nextLine();
                        break;
                    }
                    librarian.issueBook(library.getBooks().get(bookSelection),library.getReaders().get(memberId));
                    System.out.println("Toplam ödeme: "+member.getPaymentNeeded() +"\n"+
                            "Ödünç alınan toplam kitap sayısı: " + member.getBookCount());
                    scan.nextLine();
                    System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                    scan.nextLine();
                    break;
                }
                case 8:{

                    if(library.getLentBooksList().isEmpty()){
                        System.out.println("Şu an iade edilebilecek bir kitap yok. \n*** Başa dönmek için ENTER'a basın! ***");
                        scan.nextLine();
                        break;
                    }


                    System.out.println("İade etmek istediğiniz kitabı seçin:");

                    for(Book book: library.getBooks().values()){
                        if(library.getLentBooksList().containsKey(book.getId()))
                            System.out.println(book.getId() + " - " + book);
                    }

                    long bookSelection = scan.nextLong();
                    while (!(library.getLentBooksList().containsKey(bookSelection))){
                        System.out.println("Lütfen kitap numaranızı kontrol edin. Çıkmak için 0'a basın.");
                        bookSelection = scan.nextLong();
                        if(bookSelection == 0)
                            System.exit(0);
                    }
                    Book book = library.getBooks().get(bookSelection);

                    librarian.returnBook(book);
                    System.out.println(book.getPrice() + " iade edildi.");
                    scan.nextLine();
                    System.out.println("*** Başa dönmek için ENTER'a basın! ***");
                    scan.nextLine();
                    break;
                }
                case 9:{
                    System.exit(0);
                }
            }

        }



    }
}
