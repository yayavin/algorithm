package org.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    //TODO: Make tests instead of main() method
    public static void main(String[] args) {
        Integer[] nonSortedList = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        System.out.println(sort(Arrays.asList(nonSortedList)));
    }

    public static List<Integer> sort(List<Integer> nonSortedList) {
        if (nonSortedList.size() < 2) {
            return nonSortedList;
        }

        Integer middleValue = nonSortedList.get(nonSortedList.size() / 2 - 1);

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
