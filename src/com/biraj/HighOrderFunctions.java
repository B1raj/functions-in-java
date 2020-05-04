package com.biraj;

import javax.print.DocFlavor;
import java.util.function.Function;

public class HighOrderFunctions {

    static Function<Integer,Integer> square = x -> x*x;
    static Function<Integer,Integer> triple = x -> 3*x;

    //Function<Integer,Integer>

    static Function<Function<Integer,Integer>,
            Function<Function<Integer,Integer>,
                    Function<Integer,Integer>>> compose = x->y->z->x.apply(y.apply(z));

    public static void main(String[] args) {
        Function<Integer,Integer> f = compose.apply(square).apply(triple);
        System.out.println(f.apply(2));
        System.out.println(FunctionImpl.compose(x -> x*x,x -> 3*x).apply(2));
    }
}
