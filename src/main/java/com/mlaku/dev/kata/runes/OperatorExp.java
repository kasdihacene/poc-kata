package com.mlaku.dev.kata.runes;

public enum OperatorExp {
    ADD("+") {
        @Override
        public String getOperation() {
            return "+";
        }

        @Override
        public Integer applyOperation(Integer left, Integer right) {
            return left + right;
        }
    },
    SUBS("-") {
        @Override
        public String getOperation() {
            return "-";
        }

        @Override
        public Integer applyOperation(Integer left, Integer right) {
            return left - right;
        }
    },
    MULT("*") {
        @Override
        public String getOperation() {
            return "*";
        }

        @Override
        public Integer applyOperation(Integer left, Integer right) {
            return left * right;
        }
    };

    private String operator;

    OperatorExp(String op) {
        this.operator = op;
    }

    public abstract String getOperation();

    public abstract Integer applyOperation(Integer left, Integer right);
}
