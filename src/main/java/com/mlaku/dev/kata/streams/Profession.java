package com.mlaku.dev.kata.streams;

public enum Profession {
    SOFTWARE_ENGINEER("Software engineer"), NETWORK_ADMINISTRATOR("Network Administrator"), MANAGER("Manager"), ARCHITECT("Architect");
    private String value;

    public String getValue() {
        return value;
    }

    Profession(String value) {
        this.value = value;
    }
}