package org.example.sorting.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayContainsNullValuesExceptionTest {

    private static final String messageForNullValue = "Provided array contains null value.";
    private static final String messageForNullReferenceArray = "Array references to null.";

    @Test
    void happyPath() {
        Object[] arr = {new Object()};
        assertDoesNotThrow(() -> ArrayContainsNullValuesException.checkArrayForNullValues(arr));
    }

    @Test
    void nullArray() {
        Object[] arr = null;
        ArrayContainsNullValuesException e = assertThrows(
                ArrayContainsNullValuesException.class,
                () -> ArrayContainsNullValuesException.checkArrayForNullValues(arr)
        );
        assertEquals(messageForNullReferenceArray, e.getMessage());
    }

    @Test
    void nullValueArray() {
        Object[] arr = {null};
        ArrayContainsNullValuesException e = assertThrows(
                ArrayContainsNullValuesException.class,
                () -> ArrayContainsNullValuesException.checkArrayForNullValues(arr)
        );
        assertEquals(messageForNullValue, e.getMessage());
    }

}