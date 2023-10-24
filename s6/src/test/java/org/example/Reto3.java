package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Reto3 {
    @Test
    @DisplayName("Problemático")
    void reto(){
        List<? extends Number> numberList;

        List<Integer> integerList = List.of(1,2,3);
        numberList = integerList;

//        numberList = List.of(1,2,3,4.0,5f);

        assertNotNull(numberList);
    }
}
