package ru.java2.dz2;

public class Main {

    public static void main(String[] args) {
        String[][] str={{"1","2","3","4"},{"4","3","2","1"},{"1","2","3","1"},{"2","5","6","2"}};
        arrayInput(str);
    }

    public static void arrayInput(String[][] numbersStr){
        int length;
        int result=0;
        length=numbersStr.length*numbersStr[0].length;
        System.out.println("Длина массива = "+length);
        int[][] numbers=new int[numbersStr.length][numbersStr[0].length];
        for (int i = 0; i < numbersStr.length; i++) {
            for (int j = 0; j < numbersStr[i].length; j++) {
              numbers[i][j]=Integer.parseInt(numbersStr[i][j]);
              result=result+numbers[i][j];
            }
        }
        System.out.println("Сумма элементов массива = "+result);

    }

}
