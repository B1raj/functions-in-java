package com.biraj;

interface Function<T, U> {
     U apply(T i);
}


class FunctionImpl {



    static Function<Integer, Integer> square = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer i) {
            return i * i;
        }
    };
    static Function<Integer, Integer> square1 = x->x * x;


    static Function<Integer, Integer> thrice = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer i) {
            return i * 3;
        }
    };
    static Function<Integer, Integer> thrice1 = x->x * 3;


    static  public Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2){
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return f1.apply(f2.apply(i));
            }
        };
    }

    static  public Function<Integer, Integer> compose1(Function<Integer, Integer> f1, Function<Integer, Integer> f2){
        return i -> f1.apply(f2.apply(i));
    }

    static Function<Integer, Integer> f= x->x;
    static Function<Integer, Integer> g= x->x+1;
    
    public static void main(String[] args) {
        System.out.println(compose(square, thrice).apply(3));
        System.out.println(f.apply(1));
        g = compose(f, g);
        g.apply(0);
    }
}


