package com.biraj.collectionutil;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import static com.biraj.collectionutil.CollectionUtils.*;

public class CollectionUtilsDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int result = fold(list,0,x->y->x+y);
        System.out.println(result);

        String s = foldLeft(list,"0", x -> y -> addSILeft(x,y));
        System.out.println(s);

        s = foldRight(list,"0", x -> y -> addSIRight(x,y));
        System.out.println(s);

       map(list,addTax.andThen(addShipping));

        List<Double> doubleList = Arrays.asList(1.0,2.0,3.0,4.0,5.0);


        forEach(doubleList, printWith2Decimals );



    }
    static Consumer<Double> printWith2Decimals = x->{
        System.out.printf("%.2f ",x);
    };

    public static <T> void forEach(Collection<T> ts, Consumer<T> c){
        for (T t : ts){
            c.accept(t);
        }
    }

    private static Consumer<Integer> print = (s) -> {
        System.out.println(s);
    };

     static String addSILeft(String s, Integer i) {
        return "("+s+" + "+i+")";
    }

    static String addSIRight(Integer i, String s) {
        return "("+i+" + "+s+")";
    }

    static Function<Integer,Integer> addTax = s->s *2;
    static Function<Integer,Integer> addShipping = s->s +3;



}
