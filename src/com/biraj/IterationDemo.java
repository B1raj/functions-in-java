package com.biraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterationDemo {

    private static Function<Integer, Double> addTwentyPercentFunction = x -> x + x * 0.2;

    private static Function<Integer, Double> addTwentyPercent = x -> x + x * 0.2;

    private static Function<List<Integer>, List<Double>> mapFunction = x -> {
        List<Double> newList = new ArrayList<>();
        x.stream().forEach(a -> {
            newList.add(addTwentyPercentFunction.apply(a));
        });
        return newList;
    };

    private static <T,U> List<U> map(List<T> list, Function<T, U> f){
        List<U> newList = new ArrayList<>();
        for(T value :list){
            newList.add(f.apply(value));
        }
        return newList;
    }
    private static Consumer<List<Double>> print = (x) -> x.forEach(System.out::println);

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        print.accept(mapFunction.apply(intList));
        print.accept(map(intList,addTwentyPercent));

    }
}