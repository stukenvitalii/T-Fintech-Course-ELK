package org.tinkoff.tfintechcourseelk.examples;

public class StackOverflowExample {
    public static void recursiveMethod() {
        recursiveMethod(); // Рекурсивный вызов без остановки
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}