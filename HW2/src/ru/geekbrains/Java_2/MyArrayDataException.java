package ru.geekbrains.Java_2;

public class MyArrayDataException extends NumberFormatException{
    private final String[][] arr;
    private int lineIndex;
    private int columnIndex;

    public MyArrayDataException(String s, String[][] arr, int lineIndex, int columnIndex) {
        super(s);
        this.arr = arr;
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
