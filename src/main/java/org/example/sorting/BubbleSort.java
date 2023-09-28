package org.example.sorting;

import static org.example.sorting.exception.CollectionContainsNullValuesException.checkArrayForNullValues;

public class BubbleSort {

    public static Integer[] sort(Integer[] nonSortedList) {
        checkArrayForNullValues(nonSortedList);

        //Copy to new array for better readability. In prod it's better to keep one array
        Integer[] sortedList = nonSortedList.clone();
        int bufferedValue;
        for (int i = sortedList.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (sortedList[j - 1] > sortedList[j]) {
                    bufferedValue = sortedList[j];
                    sortedList[j] = sortedList[j - 1];
                    sortedList[j - 1] = bufferedValue;
                }
            }
        }
        return sortedList;
    }

}
