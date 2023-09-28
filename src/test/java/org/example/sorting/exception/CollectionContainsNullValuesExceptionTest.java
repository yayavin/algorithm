package org.example.sorting.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionContainsNullValuesExceptionTest {

    private static final String messageForNullValue = "Provided array contains null value.";
    private static final String messageForNullReferenceArray = "Array references to null.";

    @Test
    void happyPath() {
        Object[] arr = {new Object()};
        assertDoesNotThrow(() -> CollectionContainsNullValuesException.checkArrayForNullValues(arr));
    }

    @Test
    void nullArray() {
        Object[] arr = null;
        CollectionContainsNullValuesException e = assertThrows(
                CollectionContainsNullValuesException.class,
                () -> CollectionContainsNullValuesException.checkArrayForNullValues(arr)
        );
        assertEquals(messageForNullReferenceArray, e.getMessage());
    }

    @Test
    void nullValueArray() {
        Object[] arr = {null};
        CollectionContainsNullValuesException e = assertThrows(
                CollectionContainsNullValuesException.class,
                () -> CollectionContainsNullValuesException.checkArrayForNullValues(arr)
        );
        assertEquals(messageForNullValue, e.getMessage());
    }

}