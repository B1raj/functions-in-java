package com.biraj;

import java.util.function.Supplier;

public class SupplierDemo {

    private static Function<Supplier<String>,Boolean> supplierBooleanFunction = (s) ->{
       return  s.get().equals("hello")? true :false;
    };
    private static Supplier<String> supplier = () ->{
       return "hello";
    };
    public static void main(String[] args) {
        Tuple t ;
        System.out.println(supplierBooleanFunction.apply(supplier));
        System.out.println(supplierBooleanFunction.apply(()-> "hello1"));
        System.out.println(supplier.get());
    }
}
