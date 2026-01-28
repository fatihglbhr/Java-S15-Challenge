package example.entity;

public class Librarian {

    private String name;
    private String password;

    public Librarian(String name, String password){

        this.name = name;
        this.password = password;
        int index = SingletonLibrary.getInstance().getLibrarians().size();

        SingletonLibrary.getInstance().getLibrarians().put(index,this);
    }

    public Book searchBook(){

        SingletonLibrary.getInstance().getBooks().
    }

}
