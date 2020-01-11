package com.thoughtworks.fizz.buzz;

public class FizzBuzzDemo {

    public static void main(String[] args) {

        FizzBuzzDemo fizzBuzzMain = new FizzBuzzDemo();

        for (int i = 0; i < 120; i++) {
            String result = fizzBuzzMain.fizzBuzz(i + 1);
            System.out.println(result);
        }
    }


    public String fizzBuzz(int number) {

        return String.valueOf(number);
    }



}


