package app;

import util.DataInitializer;

public class App {
    public static void main(String[] args) {
        DataInitializer initializer = new DataInitializer();
        initializer.init();

        System.out.println("Data loaded");
    }
}