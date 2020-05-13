package com.biraj.collectionutil;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CollectionUtils {

    private static <T> List<T> list(){
        return Collections.emptyList();
    }

    private static <T> List<T> list(T t){
        return Collections.singletonList(t);
    }

    private static <T> List<T> list(Collection<T> a){
        return List.copyOf(a);
    }

    @SafeVarargs
    private static <T> List<T> list(T... t){
        return List.of(Arrays.copyOf(t, t.length));
    }

    private static <T> T head(List<T> t){
       if (t.size() == 0) {
           throw new IllegalArgumentException("Head of empty list");
       }
        return t.get(0);
    }

    private static <T> List<T> tail(List<T> t){
        if (t.size() == 0) {
            throw new IllegalArgumentException("Tail of empty list");
        }
        List<T> tailList = copy(t);
        tailList.remove(0);
        return Collections.unmodifiableList(tailList);

    }

    private static <T> List<T> copy(List<T> t){
        return new ArrayList<>(t);
    }

    private static <T> List<T> append(List<T> list, T t){
        List<T> ls = copy(list);
        ls.add(t);
        return Collections.unmodifiableList(ls);
    }

    public static <T> T fold(List<T> list, T startValue, Function<T, Function<T,T>> f ){
        T result = startValue;
        for(T t: list){
            result = f.apply(result).apply(t);
        }
        return result;
    }
    public static <S,I> S foldLeft(List<I> list, S startValue, Function<S, Function<I,S>> f ){
        S result = startValue;
        for(I t: list){
            result = f.apply(result).apply(t);
        }
        return result;
    }

    public static <S,I> S foldRight(List<I> list, S startValue, Function<I, Function<S,S>> f ){
        S result = startValue;
        for(int i = list.size();i>0;i--){
            result = f.apply(list.get(i-1)).apply(result);
        }
        return result;
    }

    public static <T> List<T> reverse(List<T> list){
        List<T>  newList = new ArrayList<>();
        for(int i = list.size();i>0;i--){
            newList.add(list.get(i-1));
        }
        return Collections.unmodifiableList(newList);
    }



    public static <T,U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> newList = new ArrayList<>();
        for(T value :list){
            newList.add(f.apply(value));
        }
        return newList;
    }
}
