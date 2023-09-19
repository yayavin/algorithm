package org.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    //TODO: Make tests instead of main() method
    public static void main(String[] args) {
        Integer[] nonSortedList = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        System.out.println(Arrays.deepToString(sort(nonSortedList)));
    }

    public static Integer[] sort(Integer[] nonSortedList) {
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
