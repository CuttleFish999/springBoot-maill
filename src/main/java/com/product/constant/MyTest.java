package com.product.constant;

public class MyTest {

    public static void main(String[] args){
        ProductCategory category = ProductCategory.FOOD;
        String s = category.name();
        String s2 = "CAR";

        ProductCategory category2 = ProductCategory.valueOf(s2);
        System.out.println(category2);
        System.out.println(s);
    }
}
