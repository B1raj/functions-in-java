package com.biraj;

import java.util.*;

public class CollectionUtils {

    private static <T> List<T> createEmptyList(){
        return Collections.emptyList();
    }

    private static <T> List<T> createListWithOneElement(T t){
        return Collections.singletonList(t);
    }

    private static <T> List<T> createListWithOneElement(Collection<T> a){
        return List.copyOf(a);
    }

    @SafeVarargs
    private static <T> List<T> createList(T... t){
        return List.of(Arrays.copyOf(t, t.length));
    }
}
