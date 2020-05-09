package com.biraj.collectionutil;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

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

    }

     static String addSILeft(String s, Integer i) {
        return "("+s+" + "+i+")";
    }

    static String addSIRight(Integer i, String s) {
        return "("+i+" + "+s+")";
    }
}
