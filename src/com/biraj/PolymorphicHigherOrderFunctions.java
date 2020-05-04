package com.biraj;

public class PolymorphicHigherOrderFunctions {

    static Function<Integer,Integer> square = x -> x*x;
    static Function<Integer,Integer> triple = x -> 3*x;

    //Function<Integer,Integer>
    static Function<Function<Integer,Integer>,
            Function<Function<Integer,Integer>,
                    Function<Integer,Integer>>> compose = x-> y-> z->x.apply(y.apply(z));

    public static void main(String[] args) {
        Function<Integer,Integer> f = compose.apply(square).apply(triple);
        System.out.println(f.apply(2));
    }
}
