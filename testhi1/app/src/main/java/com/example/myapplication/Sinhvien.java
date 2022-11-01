package com.example.myapplication;

public class Sinhvien {
    String name;
    int date;

    public Sinhvien(String name, int date) {
        this.name = name;
        this.date = date;
    }

    public Sinhvien() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
