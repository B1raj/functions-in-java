package com.biraj;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Function3 {

    static TriFunction<Double,Double,Double,Double>  add = (a,b,c)-> a+b+c ;
    public static void main(String[] args) {
        System.out.println( add.apply(2.0,3.0,4.0));
        System.out.println(add1.apply(2.0).apply(3.0).apply(4.0));
        System.out.println(print().apply("a").apply("b").apply("c").apply("d"));
    }

    static Function<Double, Function<Double,Function<Double,Double>>> add1 = x->y->z->x*y*z;


    static <A,B,C,D>  Function<A, Function<B, Function<C,Function<D,String>>>>  print(){
       return x->y->z->a-> String.format("%s,%s,%s,%s,",x,y,z,a);
    }

}

interface TriFunction<U,V,T,R>{

    R apply(U u,V v,T t);

}


