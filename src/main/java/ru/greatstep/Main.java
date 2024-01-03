package ru.greatstep;

import ru.greatstep.models.MyArrayList;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add("string " + i);
        }

        for (String string : myArrayList) {
            System.out.println(string);
        }
        
        System.out.println();
        System.out.println(myArrayList.size());

    }

}
