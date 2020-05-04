package com.biraj;

interface BiFunctionAddition extends Function<Integer, Function<Integer,Integer>> {
}

public class Add2Integers {
    public static void main(String[] args) {
        BiFunctionAddition add = x->y-> x+y;
        System.out.println(add.apply(2).apply(3));
    }
}
