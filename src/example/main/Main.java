package example.main;

import example.entity.Author;
import example.entity.Book;
import example.entity.MemberRecord;
import example.entity.SingletonLibrary;
import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;
import example.entity.enums.MemberTypesEnum;
import example.utility.ConsoleHandler;

public class Main {
    public static void main(String[] args) {

        MemberRecord member1 = new MemberRecord(1L,"Test Member 1", MemberTypesEnum.STUDENT,"Istanbul","5060550505");
        MemberRecord member2 = new MemberRecord(2L,"Test Member 2", MemberTypesEnum.STUDENT,"Istanbul","5060550505");
        MemberRecord member3 = new MemberRecord(3L,"Test Member 3", MemberTypesEnum.STUDENT,"Istanbul","5060550505");
        Author author1 = new Author(1L,"Test Author 1", "Istanbul","905005222222");
        Author author2 = new Author(2L,"Test Author 2", "Ankara","905005999992");
        new Book(1L,author1,"Test Book 1",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);
        new Book(2L,author1,"Test Book 2",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.JOURNALS);
        new Book(3L,author1,"Test Book 3",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);
        new Book(4L,author2,"Test Book 4",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.MAGAZINES);
        new Book(5L,author2,"Test Book 5",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);
        new Book(6L,author2,"Test Book 6",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);

        ConsoleHandler console = new ConsoleHandler();
        console.ConsoleStarter();
    }
}