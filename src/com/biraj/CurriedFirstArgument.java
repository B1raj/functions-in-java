package com.biraj;

public class CurriedFirstArgument {

    static <A,B,C> Function<B,C> partial(A a, Function<A , Function <B,C>> f){
       return f.apply(a);
    }

    public static void main(String[] args) {

    }
}
