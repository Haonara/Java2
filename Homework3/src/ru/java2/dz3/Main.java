package ru.java2.dz3;


public class Main {

    public static void main(String[] args) {


        String[] words={"Apple","Cat","Orange","Dog","Cat","Cloud","House","Tree","Mouse","Cat"};

        int length=words.length;
        int count1=0;
        int count2=1;


        for (int i = 0; i < length; i++) {
            if (words[i].contains("Cat")){
                count1++;
            }else {
                count2++;
                System.out.println(words[i]);

            }

        }

        System.out.println("Cat повторяется "+count1+" раз(а).");
        System.out.println("Уникальных слов: "+count2);

    }
}
