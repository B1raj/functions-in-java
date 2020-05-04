package com.biraj;

public class CurriedSecondArgument {

    static <A,B,C>  Function<A,C> partialB(B b, Function<A, Function<B,C>> f){
        return   a -> f.apply(a).apply(b);
    }

    public static void main(String[] args) {

    }
}
