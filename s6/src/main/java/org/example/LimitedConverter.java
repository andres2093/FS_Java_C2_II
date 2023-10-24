package org.example;

public class LimitedConverter <E extends Number>{

    public boolean esMayorQue(E number1, E number2){
        return (number1.doubleValue() - number2.doubleValue()) > 0;
    }
}
