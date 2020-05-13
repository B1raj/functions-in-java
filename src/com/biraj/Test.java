package com.biraj;

import java.util.*;


class Person{

    int age;

    Person(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}

public class Test {




    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(new Person(10), new Person(10),new Person(30));

       Person p = personList.stream().min(Comparator.comparing(Person::getAge)).orElse( null);
        System.out.println(p.getAge());


   List<String> products= Arrays.asList("rice", "sugar", "wheat", "cheese");
   List<Float> productPrices= Arrays.asList(18.99f, 56.92f, 20.89f, 345.99f);

   List<String> productSold= Arrays.asList("rice", "cheese");
   List<Float> soldPrice= Arrays.asList(18.99f, 400.89f);

        Map<String,Float> actualPriceMap = new HashMap();
        for(int i=0;i<products.size(); i++){
            actualPriceMap.put(products.get(i),productPrices.get(i));
        }

        int count=0;
        for(int i=0;i<productSold.size(); i++){
           if( !actualPriceMap.get(productSold.get(i)).equals(soldPrice.get(i))){
               count++;
           }
        }

        System.out.println(count);
    }
}


