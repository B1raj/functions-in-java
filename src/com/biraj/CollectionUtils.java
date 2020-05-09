package com.biraj;

import java.util.*;

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
}
