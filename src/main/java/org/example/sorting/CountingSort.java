package org.example.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class CountingSort {

    //TODO: Make tests instead of main() method
    public static void main(String[] args) {
        Integer[] nonSortedList = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        System.out.println(Arrays.deepToString(sort(nonSortedList)));
    }

    public static Integer[] sort(Integer[] nonSortedList) {
        //TODO: Think how could be possible to optimize memory (maybe binary tree can help us or other structure,
        // but will it be optimal by time?)
        Integer min = Arrays.stream(nonSortedList)
                .min(Comparator.comparing(Integer::intValue))
                .get();
        Integer max = Arrays.stream(nonSortedList)
                .max(Comparator.comparing(Integer::intValue))
                .get();
        int[] counterList = new int[max - min + 1];

        for (Integer integer : nonSortedList) {
            counterList[integer - min]++;
        }

        Integer[] sortedList = new Integer[nonSortedList.length];
        int counter = 0;
        for (int i = 0; i < counterList.length; i++) {
            if (counterList[i] > 0) {
                for (int j = 0; j < counterList[i]; j++) {
                    sortedList[counter] = min + i;
                    counter++;
                }
            }
        }
        return sortedList;
    }

}
