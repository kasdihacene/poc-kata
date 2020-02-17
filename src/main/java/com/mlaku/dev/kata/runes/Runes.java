package com.mlaku.dev.kata.runes;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runes {

    public static int solveExpression(final String expression) {
        int missingDigit = -1;

        BinaryExpression binaryExpression = new BinaryExpression(expression);
        Set<Integer> integers = seekForCorrectEquation(binaryExpression);

        if (integers.isEmpty()) return missingDigit;
        return integers.stream().min(Integer::compareTo).orElse(missingDigit);
    }

    // TODO : to refactor
    public static Set<Integer> seekForCorrectEquation(BinaryExpression expression) {

        Set<Integer> possibilities = Runes.getPossibleIntegers(expression.getAllIntegers());

        return possibilities.stream().filter(suggestion -> {
            Integer term1 = replaceCharInTerm(expression.getTerm1(), (String.valueOf(suggestion)));
            Integer term2 = replaceCharInTerm(expression.getTerm2(), (String.valueOf(suggestion)));
            Integer result = replaceCharInTerm(expression.getResult(), (String.valueOf(suggestion)));

            if (term1 == 0 || term2 == 0 || result == 0) return false;
            if (!isTermsInRange(term1) || !isTermsInRange(term2) || !isTermsInRange(result)) return false;

            return (expression.getOperator().applyOperation(term1, term2).compareTo(result) == 0);

        }).collect(Collectors.toSet());
    }

    public static Set<Integer> getPossibleIntegers(String allIntegers) {
        String ints = allIntegers.replace("?", "").replace("-", "").trim();
        return IntStream.range(0, 10).boxed().filter(current -> !ints.contains(String.valueOf(current))).collect(Collectors.toSet());
    }

    public static Integer replaceCharInTerm(String term, String charReplacement) {
        return Integer.valueOf(term.replace("?", charReplacement));
    }

    private static boolean isTermsInRange(Integer term) {
        return (term <= 1000000 && term >= -1000000);
    }

}
