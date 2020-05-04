package com.biraj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {

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


