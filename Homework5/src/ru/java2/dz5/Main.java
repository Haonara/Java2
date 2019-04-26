package ru.java2.dz5;

public class Main {

    public static void main(String[] args) {

        //1 method
        Thread method1=new Thread(new Massiv());
        method1.start();

        //2 method
        MyArray method2=new MyArray();
        method2.myArray();



    }


}
