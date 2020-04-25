package com.mlaku.dev.kata.datastructures;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStructureTest {

    @Test
    public void priorityQueueUsualTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(6);

        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.poll()+ " - ");
        }
    }

    @Test
    public void linkedKListUsualTest(){
        SortedMap<Integer,Integer> sortedMap = new TreeMap<>();
        sortedMap.put(1,1);
        sortedMap.put(2,2);
        sortedMap.put(3,3);
        sortedMap.put(5,5);
        sortedMap.put(4,4);
        sortedMap.put(6,6);

        System.out.println(sortedMap);
    }

    @Test
    public void functional_programming_try(){
        Supplier<String> callFunction = ()->{
            List<String> elements = Stream.of("A",2,55,true).map(e-> e.getClass().toString()).collect(Collectors.toList());
            return elements.toString();
        };

        System.out.println(callFunction.get());
    }
}
