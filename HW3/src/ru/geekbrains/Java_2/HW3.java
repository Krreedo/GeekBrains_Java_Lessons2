package ru.geekbrains.Java_2;

import java.util.*;

public class HW3 {

    public static void main(String[] args) {
        ArrayList<String> wordsArrayList = new ArrayList<>(Arrays.asList("banana", "apple", "cucumber", "melon", "pear", "mushroom", "strawberry", "apple", "mushroom", "banana", "cucumber", "banana", "strawberry", "apple", "banana"));
        int frequency;
        Set<String> wordsSet = new LinkedHashSet<>(wordsArrayList);
        System.out.println(wordsArrayList);
        System.out.println(wordsSet);
        for (String s : wordsSet) {
            frequency = Collections.frequency(wordsArrayList,s);
            System.out.println("Слово " + s + " встречается " + frequency + " раз.");

        }

        YellowPages yp = new YellowPages();
        yp.add("89112246232","Софронов");
        yp.add("89998887766","Емельяненко");
        yp.add("89911224565","Kozlov");
        yp.add("89445644894","Kozlov");
        yp.get("Емельяненко");
        yp.get("Kozlov");
    }

}
