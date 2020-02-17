package com.mlaku.dev.kata.runes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryExpression {

    private static final String REGEX_EXPRESSION = "(-?[0-9|?]+)([+|*|-])(-?[0-9|?]+)([=])([0-9|?]+)";

    private String term1;
    private OperatorExp operator;
    private String term2;
    private String result;
    private String allIntegers;

    public BinaryExpression(String expression) {
        parseExpression(expression);
    }

    private void parseExpression(String exp) {
        Pattern pattern = Pattern.compile(REGEX_EXPRESSION);
        Matcher matcher = pattern.matcher(exp);
        if (matcher.find()) {
            term1 = matcher.group(1);
            setOperator(matcher.group(2));
            term2 = matcher.group(3);
            result = matcher.group(5);
            allIntegers = term1.concat(term2).concat(result);
        }
    }

    private void setOperator(String op) {
        if (OperatorExp.ADD.getOperation().equals(op)) {
            operator = OperatorExp.ADD;
        }

        if (OperatorExp.SUBS.getOperation().equals(op)) {
            operator = OperatorExp.SUBS;
        }

        if (OperatorExp.MULT.getOperation().equals(op)) {
            operator = OperatorExp.MULT;
        }
    }

    public String getTerm1() {
        return term1;
    }

    public String getTerm2() {
        return term2;
    }

    public String getResult() {
        return result;
    }

    public String getAllIntegers() {
        return allIntegers;
    }

    public OperatorExp getOperator() {
        return operator;
    }

}
