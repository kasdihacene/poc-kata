package com.mlaku.dev.kata.besttravel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class SumOfK {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {

        if (ls.size() < k) return null;
        if (ls.size() == k) return sumIntegerList(ls);

        Stream<List<Integer>> streamCombinations = getCombinations(ls, k);
        List<Integer> sumCombinations = streamCombinations.map(listElements -> listElements.stream().reduce(0, Integer::sum)).collect(Collectors.toList());
        return getRoundInteger(t,sumCombinations);
    }

    private static Integer getRoundInteger(int max, List<Integer> sumList) {
        sumList.sort(reverseOrder());
        List<Integer> summedLists = sumList.stream().filter(e -> e <= max).collect(Collectors.toList());

        Optional<Integer> maxFound = summedLists.stream().max(Integer::compareTo);
        return maxFound.orElse(null);
    }

    public static int sumIntegerList(List<Integer> listIntegers) {
        return listIntegers.stream().reduce(0, Integer::sum);
    }

    @SuppressWarnings("deprecation")
    public static <E> Stream<List<E>> getCombinations(List<E> list, int sizeList) {
        if (sizeList == 0) {
            return Stream.of(Collections.emptyList());
        } else {
            return IntStream.range(0, list.size()).
                    boxed().
                    <List<E>>flatMap(i -> getCombinations(list.subList(i + 1, list.size()), sizeList - 1).
                            map(tail -> extract(list.get(i), tail)));
        }
    }

    @SuppressWarnings("deprecation")
    public static <E> List<E> extract(E head, List<E> tail) {
        List<E> subList = new ArrayList<>(tail);
        subList.add(0, head);
        return subList;
    }

}
