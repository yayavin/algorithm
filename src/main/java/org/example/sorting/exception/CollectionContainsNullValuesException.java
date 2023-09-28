package org.example.sorting.exception;

import java.util.List;
import java.util.stream.Stream;

/**
 * It should be extended from RuntimeException, because it's unchecked (we don't know will array contain null or not).
 * TODO: Maybe it's better to extend from another Exception under the RuntimeException. Think about it.
 */
public class CollectionContainsNullValuesException extends RuntimeException {

    private static final String messageForNullValue = "Provided collection contains null value.";
    private static final String messageForNullReferenceCollection = "Collection references to null.";

    private CollectionContainsNullValuesException(String message) {
        super(message);
    }

    public static void checkArrayForNullValues(Object[] arr) throws CollectionContainsNullValuesException {
        if (arr == null) {
            throw new CollectionContainsNullValuesException(messageForNullReferenceCollection);
        }
        Stream.of(arr).forEach(value -> {
            if (value == null) {
                throw new CollectionContainsNullValuesException(messageForNullValue);
            }
        });
    }

    public static void checkListOfIntegerForNullValues(List<Integer> list) throws CollectionContainsNullValuesException {
        if (list == null) {
            throw new CollectionContainsNullValuesException(messageForNullReferenceCollection);
        }
        Object[] arr = list.toArray();
        checkArrayForNullValues(arr);
    }

}
