package ru.java2.dz5;

public class MyArray {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] a1=new float[h];
    float[] a2=new float[h];


    public void myArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread mass=new Copy();
        ((Copy) mass).setA(a1);
        mass.run();
        Thread mass2=new Copy();
        ((Copy) mass2).setA(a2);
        mass2.run();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long b2 = System.currentTimeMillis();
        System.out.print("Выполенно за ");
        System.out.println(b2-b);




    }

}

class Copy extends Thread {

    float[]a;

    public void setA(float[] a) {
        this.a = a;
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            a[i] = (float)(a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long t = System.currentTimeMillis();
        System.out.print("Время выполенния: ");
        System.out.println(t-time);
    }
}
