package ru.java2.dz2;

public class Main {

    public static void main(String[] args) {
        String[][] str={{"1","2","3","5"},{"4","3","2","4"},{"1","2","3","3"},{"1","5","6","4"}};

        try{
            arrayInput(str);
        }catch (MyArraySizeException e){
            System.out.println("Неверный размер массива!");
        }

    }

    public static void arrayInput(String[][] numbersStr) throws MyArraySizeException{
        int result=0;

        if (numbersStr.length!=4)throw new MyArraySizeException();
        for (int i = 0; i < numbersStr.length; i++) {
            if (numbersStr[i].length!=4) throw new MyArraySizeException();
        }


        int[][] numbers=new int[numbersStr.length][numbersStr[0].length];
        for (int i = 0; i < numbersStr.length; i++) {
            for (int j = 0; j < numbersStr[i].length; j++) {

                try{
                    numbers[i][j]=Integer.parseInt(numbersStr[i][j]);
                }catch(Exception e){

                    System.out.println("Неверный тип элемента массива! Неверное значение в элементе ("+ i+ ","+j+"): "+numbersStr[i][j]);

                }

              result=result+numbers[i][j];
            }
        }
        System.out.println("Сумма элементов массива = "+result);

    }

}
