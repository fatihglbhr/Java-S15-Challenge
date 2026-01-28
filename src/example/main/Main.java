package example.main;

import example.entity.SingletonLibrary;

public class Main {
    public static void main(String[] args) {

        System.out.println(SingletonLibrary.getInstance());
    }
}