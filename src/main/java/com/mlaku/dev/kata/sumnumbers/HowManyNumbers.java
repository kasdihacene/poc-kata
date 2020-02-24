package com.mlaku.dev.kata.sumnumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HowManyNumbers {

    public static ArrayList<Long> findAll(final int sumDigits, final int numDigits) {
        List<Integer> allResults = findAllCombinations(sumDigits, numDigits);

        if (allResults.isEmpty()) return new ArrayList<>();
        if (allResults.size() == 1) {
            ArrayList<Long> r = new ArrayList<>();
            r.add(1L);
            r.add(Long.valueOf(allResults.get(0)));
            r.add(Long.valueOf(allResults.get(0)));
            return r;
        }
        return getListNumbers(allResults);
    }

    public static ArrayList<Long> getListNumbers(List<Integer> allResults) {
        List<Integer> filtered = allResults.stream().filter(HowManyNumbers::isMaxFromTheEnd).collect(Collectors.toList());
        ArrayList<Long> r = new ArrayList<>();
        r.add(Long.valueOf(filtered.size()));
        r.add(Long.valueOf(filtered.get(0)));
        r.add(Long.valueOf(filtered.get(filtered.size()-1)));
        return r;
    }

    public static boolean isMaxFromTheEnd(Integer number) {
        List<String> listDigits = Arrays.asList((number + "").split(""));
        List<Integer> foundList = IntStream.range(0, listDigits.size()).boxed().filter(i -> {
            if (i + 1 < listDigits.size()) {
                return (Integer.valueOf(listDigits.get(i)) <= Integer.valueOf(listDigits.get(i + 1)));
            }
            return false;
        }).collect(Collectors.toList());

        return (foundList.size() + 1 == listDigits.size());
    }

    public static List<Integer> findAllCombinations(final int sumDigits, final int numDigits) {
        List<Integer> list = new ArrayList<>();
        int count = numDigits;
        while (count > 0) {
            if (list.isEmpty())
                list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
            else
                list = list.stream().map(x -> IntStream.range(1, 10).boxed().map(ee -> Integer.valueOf(x + "" + ee)).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());

            count--;
        }
        return list.stream().filter(number -> subDigitsNumber(number + "") == sumDigits).collect(Collectors.toList());
    }

    private static Integer subDigitsNumber(String number) {
        return Arrays.asList(number.split("")).stream().map(Integer::valueOf).reduce(0, (a, b) -> a + b);
    }

    public static <E> List<Object> generateCombinations(List<E> inputList, int nbrCombinations) {
        return treeCombinationsOfHeadCall(inputList, nbrCombinations, new ArrayList<>())
                .stream().map(pair -> (List) pair.getValue()).collect(Collectors.toList()).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static <E> List<AbstractMap.SimpleEntry> treeCombinationsOfHeadCall(List<E> inputList, int nbrCombinations, List<AbstractMap.SimpleEntry> results) {
        if (nbrCombinations == 0) return Collections.emptyList();
        if (nbrCombinations == 1 && results.isEmpty())
            return Arrays.asList(new AbstractMap.SimpleEntry(null, inputList.stream().map(Arrays::asList).collect(Collectors.toList())));
        if (nbrCombinations == 1 && !results.isEmpty()) return results;
        nbrCombinations--;

        if (results.isEmpty()) {
            nbrCombinations--;
            results = recursiveTree(new ArrayList<>(inputList), new ArrayList<>());
            if (nbrCombinations == 0) return results;
        }

        return treeCombinationsOfHeadCall(inputList, nbrCombinations, recursiveMainCombinations(results));
    }

    public static List<AbstractMap.SimpleEntry> recursiveMainCombinations(List<AbstractMap.SimpleEntry> results) {
        return results.stream().map(e -> {
            List<AbstractMap.SimpleEntry> combinations = new ArrayList<>();
            List<Integer> tailComb = (List) e.getKey();

            for (int index = 0; index < ((List) e.getValue()).size() - 1; index++) {
                ArrayList listCombs = new ArrayList((List) e.getValue());
                int finalI = index;
                List<List<Object>> listCombinations = tailComb.subList(index, tailComb.size()).stream().map(xx ->
                {
                    List<Object> listInts = new ArrayList<>();
                    listInts.addAll((List<Object>) listCombs.get(finalI));
                    listInts.add(xx);
                    return listInts;
                }).collect(Collectors.toList());

                combinations.add(new AbstractMap.SimpleEntry(new ArrayList<>(tailComb.subList(index, tailComb.size()).subList(1, tailComb.subList(index, tailComb.size()).size())), listCombinations));
            }
            if (!tailComb.isEmpty())
                tailComb.remove(0);

            return combinations;
        }).collect(Collectors.toList()).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static <T> List<AbstractMap.SimpleEntry> recursiveTree(List<T> tail, List<AbstractMap.SimpleEntry> results) {
        if (tail.isEmpty()) return results;

        List<List<T>> result = Arrays.asList(tail.remove(0)).stream()
                .map(e -> tail.stream().map(ex -> Arrays.asList(e, ex))).collect(Collectors.toList()).stream()
                .map(e -> e.collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());

        if (!tail.isEmpty()) {

            results.add(new AbstractMap.SimpleEntry(new ArrayList<>(tail.subList(1, tail.size())), result));
            return recursiveTree(tail, results);
        }

        return results;
    }


}
