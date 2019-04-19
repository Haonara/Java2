package ru.java2.dz3;

import java.util.*;

public class PhoneList {

    public static void main(String[] args) {

        int key;
        String word;
        Map<Integer, String> phones = new HashMap<>();
        phones.put(123456,"Иванов");
        phones.put(456987,"Петров");
        phones.put(325698,"Сидоров");
        phones.put(785412,"Иванов");
        phones.put(365284,"Козлов");

        for (Map.Entry<Integer,String> ph: phones.entrySet()) {
            word=ph.getValue();
            if (word.contains("Петров")){
                key=ph.getKey();
                System.out.println(word+ " "+key);
            }

            
        }

    }




}
