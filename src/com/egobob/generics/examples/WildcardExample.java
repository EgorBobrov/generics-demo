package com.egobob.generics.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WildcardExample {

    public static void printAnyObjectList(List<Object> list) {
        for (Object o: list) {
            System.out.println(o.toString());
        }
    }

    public static void printAnyGenericList(List<?> list) {
        for (Object o: list) {
            System.out.println(o.toString());
        }
    }

    public static Number maxNumber(List<? extends  Number> numbers) {
        return numbers.stream()
                .max(Comparator.comparingDouble(Number::doubleValue))
                .orElseThrow();
    }

    public static void addAnObjectToAnyObjectList(List<Object> list) {
        list.add(new Object());
    }

    public static void demonstrateTypeErasure() {
        List<String> strings = new ArrayList<>();
        String stringValue = "String value";
        strings.add(stringValue);
        String string = strings.get(0);

        List probablyStrings = new ArrayList();
        String definitelyString = "String value";
        if (definitelyString instanceof String) {
            probablyStrings.add(definitelyString);
        } else {
            throw new RuntimeException("What are you doing? This List is supposed to contain strings!");
        }
        String probablyString = (String) probablyStrings.get(0);

    }

    public static void main(String[] args) {
        List<String> strings = List.of("first", "second");
        printAnyGenericList(strings);
        // printAnyObjectList(strings); compile-time error!
    }
}
