package com.mlaku.dev.kata.descendingorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrder {

    public static int sortDesc(final int num) {
        String numAsString = String.valueOf(num);
        if (numAsString.length() == 1) return num;

        List<Integer> listOccurrences = buildSortedNumbers(numAsString);

        return Integer.parseInt(concatListElements(listOccurrences));
    }

    private static List<Integer> buildSortedNumbers(String numAsString) {
        ArrayList<Integer> listOccurrences = new ArrayList<>();
        for (int i = 0; i < numAsString.length(); i++) {
            listOccurrences.add(Character.getNumericValue(numAsString.charAt(i)));
        }
        listOccurrences.sort(Collections.reverseOrder());
        return listOccurrences;
    }

    private static String concatListElements(List<Integer> objects) {
        StringBuilder concats = new StringBuilder();
        for (Object o : objects)
            concats.append(o);
        return concats.toString();
    }
}
