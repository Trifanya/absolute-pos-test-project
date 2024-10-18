package dev.trifonov;

public class App {
    public static void main(String[] args) {
        Product dough = new Product("Тесто");
        Product flour = new Product("Мука");
        Product eggs = new Product("Яйца");
        Product water = new Product("Вода");
        Product wheat = new Product("Пшеница");

        System.out.println(dough.addProduct(flour)); // true
        System.out.println(dough.addProduct(eggs)); // true
        System.out.println(dough.addProduct(water)); // true

        System.out.println(flour.addProduct(dough)); // false
        System.out.println(flour.addProduct(wheat)); // true

        System.out.println(wheat.addProduct(dough)); // false
    }
}