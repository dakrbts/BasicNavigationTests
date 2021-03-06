package com.cbt.utilities;

public class StringUtility {
    public static void verifyEquals(String expected, String actual){
        if(actual.equals(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }

    public static void verifyContains(String first, String second){
        if(first.contains(second)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("first = " + first);
            System.out.println("second = " + second);
        }
    }
}
