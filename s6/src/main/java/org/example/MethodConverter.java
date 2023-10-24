package org.example;

public class MethodConverter {

    public static <E> String convertToString(E input){
        return input.toString();
    }
}
