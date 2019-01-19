package com.example.henry.trytolenrnactivity;

public class Book {

    private int type;
    private String name;
    public Book(String name,int type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public int getType(){return type;}
}
