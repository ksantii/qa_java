package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private final Feline feline; // Объявление переменной feline

    public Lion(String sex, Feline feline) throws Exception { // Добавлен параметр feline в конструктор
        this.feline = feline; // Инициализация переменной feline
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
