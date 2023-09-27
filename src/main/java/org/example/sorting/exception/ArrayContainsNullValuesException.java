package org.example.sorting.exception;

import java.util.stream.Stream;

/**
 * It should be extended from RuntimeException, because it's unchecked (we don't know will array contain null or not).
 * TODO: Maybe it's better to extend from another Exception under the RuntimeException. Think about it.
 */
public class ArrayContainsNullValuesException extends RuntimeException {

    private static final String messageForNullValue = "Provided array contains null value.";
    private static final String messageForNullReferenceArray = "Array references to null.";

    private ArrayContainsNullValuesException(String message) {
        super(message);
    }

    public static void checkArrayForNullValues(Object[] arr) throws ArrayContainsNullValuesException {
        if (arr == null) {
            throw new ArrayContainsNullValuesException(messageForNullReferenceArray);
        }
        Stream.of(arr).forEach(value -> {
            if (value == null) {
                throw new ArrayContainsNullValuesException(messageForNullValue);
            }
        });
    }

}
