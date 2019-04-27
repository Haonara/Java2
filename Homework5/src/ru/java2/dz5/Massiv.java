package ru.java2.dz5;

public class Massiv implements Runnable{

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];


    @Override
    public void run() {
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.print("Время работы метода= ");
        System.out.println(b-a);
    }


}
