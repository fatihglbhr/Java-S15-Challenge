package example.entity;

import jdk.jshell.spi.ExecutionEnv;

import java.util.HashMap;
import java.util.Map;

public class SingletonLibrary {

    private final String libraryName;
    private final Map<Long, Book> books;
    private final Map<Long, MemberRecord> readers;
    private final Map<Long, MemberRecord> lentBooksList;
    private Librarian librarian;
    private final Map<Long, Author> authorsList;

    private static SingletonLibrary instance;

    private SingletonLibrary(){

        libraryName = System.getenv("LIBRARY_NAME");

        books = new HashMap<>();
        readers = new HashMap<>();
        lentBooksList = new HashMap<>();
        authorsList = new HashMap<>();
    }

    public static SingletonLibrary getInstance(){

        if(instance == null)
            instance = new SingletonLibrary();

        return instance;
    }

    public Map<Long, Book> getBooks() {

        return books;
    }

    public Map<Long, MemberRecord> getReaders() {

        return readers;
    }

    public Map<Long, MemberRecord> getLentBooksList() {

        return lentBooksList;
    }

    public Map<Long, Author> getAuthorsList() {

        return authorsList;
    }

    public Librarian getLibrarian(){
        if(librarian == null)
            librarian = new Librarian(System.getenv("LIBRARIAN_NAME"), System.getenv("LIBRARIAN_PWD"));
        return librarian;
    }


    @Override
    public String toString() {
        return libraryName;
    }
}
