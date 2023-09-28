package org.example.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.sorting.exception.CollectionContainsNullValuesException.checkListOfIntegerForNullValues;

public class QuickSort {

    public static List<Integer> sort(List<Integer> nonSortedList) {
        Random random = new Random();
        return sort(nonSortedList, random);
    }

    private static List<Integer> sort(List<Integer> nonSortedList, Random random) {
        checkListOfIntegerForNullValues(nonSortedList);

        if (nonSortedList.size() < 2) {
            return nonSortedList;
        }

        //Check for sublist containing only one value (ex. [1, 1, 1]).
        //TODO: This is mostly looks like a hack, think how to optimize it.
        Integer firstValue = nonSortedList.get(0);
        boolean areAllElementsEqual = true;
        for (Integer value : nonSortedList) {
            if (!value.equals(firstValue)) {
                areAllElementsEqual = false;
                break;
            }
        }
        if (areAllElementsEqual) {
            return nonSortedList;
        }

        int randomValue = random.nextInt(nonSortedList.size());
        Integer middleValue = nonSortedList.get(randomValue);

        List<Integer> moreOrEqualThanMidList = new ArrayList<>();
        List<Integer> lessThanMidList = new ArrayList<>();

        for (Integer element : nonSortedList) {
            if (element >= middleValue) {
                moreOrEqualThanMidList.add(element);
            } else {
                lessThanMidList.add(element);
            }
        }
        moreOrEqualThanMidList = sort(moreOrEqualThanMidList);
        lessThanMidList = sort(lessThanMidList);

        List<Integer> sortedList = lessThanMidList;
        sortedList.addAll(moreOrEqualThanMidList);
        return sortedList;
    }

}
