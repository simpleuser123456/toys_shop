package com.toy_shop;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ToyStorage shop = new ToyStorage("1 2 конструктор", "2 2 робот", "3 6 кукла");

        System.out.println(shop.get());
    }
}