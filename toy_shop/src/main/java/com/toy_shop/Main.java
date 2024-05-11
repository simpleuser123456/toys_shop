package com.toy_shop;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStorage shop = new ToyStorage("1 2 конструктор", "2 2 робот", "3 6 кукла");

        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < 10; i++) {
                int result = shop.get();
                writer.write(result + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}