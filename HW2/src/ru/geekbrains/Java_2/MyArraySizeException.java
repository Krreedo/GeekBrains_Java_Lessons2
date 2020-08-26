package ru.geekbrains.Java_2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    private final String[][] arr;

    public MyArraySizeException(String[][] arr) {
        this.arr = arr;
    }

    public MyArraySizeException(String s, String[][] arr) {
        super(s);
        this.arr = arr;
    }
}
