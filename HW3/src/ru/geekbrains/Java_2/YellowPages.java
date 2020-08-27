package ru.geekbrains.Java_2;

import java.util.HashMap;
import java.util.Objects;

public class YellowPages {
    HashMap<String,String> yellowPages = new HashMap<>();

    public YellowPages() {
        this.yellowPages = yellowPages;
    }


    public void add(String k, String v){
        yellowPages.put(k,v);
    }
    public void get(String value){
        System.out.println("По фамилии " + value + " есть следующие телефоны:");
        yellowPages.forEach((k,v)->{
            if(value.equals(v)){
                System.out.println(k);
            }
        });
    }

    public void setYellowPages(HashMap<String, String> yellowPages) {
        this.yellowPages = yellowPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YellowPages that = (YellowPages) o;
        return Objects.equals(yellowPages, that.yellowPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yellowPages);
    }
}
