package com.biraj;

import java.util.function.Function;

public class AnonymousFunction {

    Function<Integer,Integer> add1 = x->x+1;
    Function<Integer,Integer> add2 = x->x+2;

  static<U,T,V> Function<U,T> compose (Function<V,T>f, Function<U,V> g){
      return i-> f.apply(g.apply(i));
  }


    public static void main(String[] args) {
        AnonymousFunction ob = new AnonymousFunction();
        System.out.println( ob.compose(ob.add1,ob.add2).apply(2));
        //Anonymous function
        System.out.println(ob.compose(x->x+1,x->(Integer) x+2).apply(2));


    }
}
