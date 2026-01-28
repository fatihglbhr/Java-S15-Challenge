package example.entity;

import java.util.Set;

public class Person {

    private String name;

    public Person(String name){

        this.name = name;
    }

    public String whoYouAre(){

        return name;
    };


}
