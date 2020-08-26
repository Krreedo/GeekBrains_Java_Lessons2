package ru.geekbrains.Java_2;

import java.util.Arrays;
import java.util.Random;

import static java.lang.String.valueOf;

public class HW2 {

    public static Random random = new Random();
    public static void main(String[] args) {

        String [][] arr = new String[4][4];
        try{
            fillArr(arr);
            modifyArr(arr);
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } catch (MyArrayDataException ex){
            System.out.printf("Ошибка данных в ячейке [%d %d] %n",ex.getLineIndex(),ex.getColumnIndex());
            ex.printStackTrace();
        }
        System.out.println(Arrays.deepToString(arr));


    }
    public static void modifyArr(String[][] arr) throws MyArrayDataException{

//        arr[0][3] = "one"; // для проверки эксепшена
        int arrSum = 0;
            for (int i = 0; i <arr.length; i++) {
                for (int j = 0; j <arr[i].length ; j++) {
                    try {
                        arrSum = arrSum + Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyArrayDataException("Ошибка в данных",arr,i,j);
                    }
                }
            }
            System.out.println("Сумма всех элементов равна: " + arrSum);


    }
    public static void fillArr(String[][] arr) throws MyArraySizeException{
        String randomNumber;
        if(arr.length!=4 || arr[0].length!=4){
            throw new MyArraySizeException("Массив может быть только 4х4",arr);
        }
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                randomNumber = valueOf(random.nextInt(10));
                arr[i][j] = randomNumber;
            }
        }
    }
}
