package org.example.sorting;

import org.example.sorting.exception.CollectionContainsNullValuesException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void happyPath() {
        Integer[] arrProvided = {9, 8, 1, 7, 4, 5, -1, -2, -3, 6, 3, 2, 1, 1};
        Integer[] arrExpected = {-3, -2, -1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> listExpected = Arrays.asList(arrExpected);
        List<Integer> resultList = QuickSort.sort(Arrays.asList(arrProvided));
        assertEquals(resultList.toString(), listExpected.toString());
    }

    @Test
    void emptyArray() {
        Integer[] arrProvided = {};
        Integer[] arrExpected = {};
        List<Integer> listExpected = Arrays.asList(arrExpected);
        List<Integer> resultList = QuickSort.sort(Arrays.asList(arrProvided));
        assertEquals(resultList.toString(), listExpected.toString());
    }

    @Test
    void nullArray() {
        assertThrows(CollectionContainsNullValuesException.class, () -> QuickSort.sort(null));
    }

    @Test
    void nullValueArray() {
        Integer[] arrProvided = {null};
        List<Integer> listProvided = Arrays.asList(arrProvided);
        assertThrows(CollectionContainsNullValuesException.class, () -> QuickSort.sort(listProvided));
    }
    
}