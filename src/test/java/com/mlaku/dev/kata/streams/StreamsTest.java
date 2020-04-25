package com.mlaku.dev.kata.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mlaku.dev.kata.streams.Profession.*;

public class StreamsTest {

    @Test
    public void shouldReturnDivisorOfTheNumber() {
        List<Object> generatedList = StreamsPoc.generateDivisorsNumber(Arrays.asList(0, 1, 3, 6, 9, 45, 77, 89, 18, 55, 18), 27);
        System.out.println(generatedList);
        Assert.assertTrue(3 == generatedList.size());
    }

    @Test
    public void shouldReturnMapOccurrences() {
        Map<Object, Long> generatedMap = StreamsPoc.generateMapOccurrences(Arrays.asList("A", "B", "C", "D", "D", "B", "D", "G", "KK", "K", "OO"));
        System.out.println(generatedMap);

    }

    @Test
    public void shouldReturnOccurrencesWithMax() {
        AbstractMap.SimpleEntry<Object, Long> generatedList = StreamsPoc.getMaxOccurrences(Arrays.asList(0, 1, 3, 6, 9, 45, 1, 3, 9, 9, 89, 18, 55, 18, 18, 18, 18));
        System.out.println(generatedList);
    }

    @Test
    public void returnsMapPersonsGroupedByProfessionWhenProcessingListPersons() {


        // List<T> --> Map<T.e, List<T>>

        List<Person> people = Person.init();

        // ["Arnold", "Phillipe", "Luise"] ==> ["ARNOLD", "PHILLIPE", "LUISE"]
        List<String> uppercaseNames = people
                .stream()
                .limit(3) // Take only three objects
                .map(person -> person.getName().toUpperCase())
                .collect(Collectors.toList());

        // List<T> --> Map<T.e, List<T>>
        Map<Profession, List<Person>> personsByProfession = people
                .stream()
                .collect(Collectors.groupingBy(Person::getProfession));
        System.out.println(personsByProfession);


        // List<T> --> Map<T.e, Long>
        Map<Profession, Long> countByProfession = people
                .stream()
                .collect(Collectors.groupingBy(Person::getProfession, Collectors.counting()));
        System.out.println(countByProfession);



        // List<List<T>> --> List<T>

        List<String> stringWithLength3 = Arrays.asList("BBB", "DDD", "AAA");
        List<String> stringWithLength2 = Arrays.asList("EE", "FF", "CC");
        List<List<String>> stringsByLength = Arrays.asList(stringWithLength3, stringWithLength2);

        List<String> allStrings = stringsByLength
                .stream()
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());

        System.out.println(allStrings);

        // [{A}{B}{C}{D}{E}] --> {A B C D E}
        List<String> tokens = Arrays.asList("I", "am", "a", "software", "craftsman.");
        Optional<String> longestString = tokens
                .stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.println(longestString);


        tokens
                .stream()
                .reduce((string1, string2) -> string1 + " " + string2)
                .ifPresent(System.out::println);

        String max = Stream.of("A", "B", "C", "D", "D", "B", "D", "G", "E", "K", "N")
                .max(Comparator.comparing(String::toString))
                .orElse(null);


        System.out.println(max);


    }


}
