package org.example.sorting;

import org.example.sorting.exception.ArrayContainsNullValuesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    @Test
    void happyPath() {
        Integer[] arrProvided = {9, 8, 1, 7, 4, 5, -1, -2, -3, 6, 3, 2, 1, 1};
        Integer[] arrExpected = {-3, -2, -1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrProvided = CountingSort.sort(arrProvided);
        assertArrayEquals(arrProvided, arrExpected);
    }

    @Test
    void emptyArray() {
        Integer[] arrProvided = {};
        Integer[] arrExpected = {};
        arrProvided = CountingSort.sort(arrProvided);
        assertArrayEquals(arrProvided, arrExpected);
    }

    @Test
    void nullArray() {
        Integer[] arrProvided = null;
        assertThrows(ArrayContainsNullValuesException.class, () -> CountingSort.sort(arrProvided));
    }

    @Test
    void nullValueArray() {
        Integer[] arrProvided = {null};
        assertThrows(ArrayContainsNullValuesException.class, () -> CountingSort.sort(arrProvided));
    }
    
}