package com.mlaku.dev.kata.descendingorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrder {

    public static int sortDesc(final int num) {
        String numAsString = String.valueOf(num);
        if (numAsString.length() == 1) return num;

        List<Integer> listOccurrences = buildSortedNumbers(numAsString);

        return Integer.valueOf(concatListElements(listOccurrences));
    }

    private static List<Integer> buildSortedNumbers(String numAsString) {
        ArrayList<Integer> listOccurrences = new ArrayList<>();
        for (int i = 0; i < numAsString.length(); i++) {
            listOccurrences.add(Character.getNumericValue(numAsString.charAt(i)));
        }
        Collections.sort(listOccurrences, Collections.reverseOrder());
        return listOccurrences;
    }

    private static String concatListElements(List<Integer> objects) {
        String concats = "";
        for (Object o : objects)
            concats += o;
        return concats;
    }
}
