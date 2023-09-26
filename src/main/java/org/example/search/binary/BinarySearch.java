package org.example.search.binary;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    //TODO: Make tests instead of main() method
    public static void main(String[] args) {
        Integer[] arr = {9, 1, 8, 2, 7, 3, 6, 4};
        List<Integer> list = List.of(arr);
        System.out.println(find(list, 4)); //true
        System.out.println(find(list, 5)); //false
    }

    public static boolean find(List<Integer> list, Integer number) {
        list = list.stream().sorted().toList();
        if (list.size() > 1) {
            int position = list.size() / 2;
            if (list.get(position).equals(number)) {
                return true;
            } else if(list.get(position).compareTo(number) < 1) {
                return find(list.subList(position, list.size()), number);
            } else {
                return find(list.subList(0, position), number);
            }
        } else {
            return list.get(0).equals(number);
        }
    }

}
