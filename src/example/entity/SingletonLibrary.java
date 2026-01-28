package example.entity;

import jdk.jshell.spi.ExecutionEnv;

import java.util.HashMap;
import java.util.Map;

public class SingletonLibrary {

    private final String libraryName;
    private final Map<Integer, Book> books;
    private final Map<Integer, Reader> readers;
    private final Map<Integer, Librarian> librarians;

    private static SingletonLibrary instance;

    private SingletonLibrary(){

        libraryName = System.getenv("LIBRARY_NAME");
        books = new HashMap<>();
        readers = new HashMap<>();
        librarians = new HashMap<>();
    }

    public static SingletonLibrary getInstance(){

        if(instance == null)
            instance = new SingletonLibrary();

        return instance;
    }

    public Map<Integer, Book> getBooks() {

        return books;
    }

    public Map<Integer, Librarian> getLibrarians() {

        return librarians;
    }

    public Map<Integer, Reader> getReaders() {

        return readers;
    }

    @Override
    public String toString() {
        return libraryName;
    }
}
