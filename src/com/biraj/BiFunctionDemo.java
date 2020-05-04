package com.biraj;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    static BiFunction<Integer,Integer,Integer> mul = (x,y)->x*y;

    static Function<Integer, Function<Integer,Integer>>  mul1 = x->y->x*y;


    public static void main(String[] args) {
        System.out.println( mul.apply(2,3));
        System.out.println(mul1.apply(2).apply(3));

        Function<Integer,Integer> fun = mul1.apply(3);
        System.out.println(fun.apply(2));

    }



}
