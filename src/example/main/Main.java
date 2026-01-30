package example.main;

import example.entity.*;
import example.entity.enums.BookStatusEnum;
import example.entity.enums.BookTypesEnum;
import example.console.ConsoleHandler;

public class Main {
    public static void main(String[] args) {

        LibraryMembers member1 = new FacultyMember(1L,"FacultyMember 1", "Istanbul","5060550505");
        LibraryMembers member2 = new FacultyMember(2L,"FacultyMember 2", "Ankara","5060550505");
        LibraryMembers member3 = new Student(3L,"Student 1", "Istanbul","5060550505");
        LibraryMembers member4 = new Student(4L,"Student 2", "Ankara","5060550505");

        Author author1 = new Author(1L,"Fyodor Dostoevsky", "Rusya","905005222222");
        Author author2 = new Author(2L,"Adam Fawer", "Amerika","905005999992");

        new Book(1L,author1,"Poor Folk",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.NOVELS);
        new Book(2L,author1,"Crime and Punishment",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.JOURNALS);
        new Book(3L,author1,"Demons",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);
        new Book(4L,author1,"The Brothers Karamazov",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.MAGAZINES);
        new Book(5L,author2,"Gnosis",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);
        new Book(6L,author2,"Improbable",2.3, BookStatusEnum.AVAILABLE,"22", BookTypesEnum.STUDY_BOOKS);


        ConsoleHandler.ConsoleStarter();
    }
}