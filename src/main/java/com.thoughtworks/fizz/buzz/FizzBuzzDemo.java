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

        String numberStr = String.valueOf(number);
        String result = "";

        if (number % 3 == 0) {
            result += "Fizz";
        }

        if (number % 5 == 0) {
            result += "Buzz";
        }

        if (number % 7 == 0) {
            result += "Whizz";
        }

        if (numberStr.contains("3")) {
            if (result.length() > 0) {
                result = result.replaceAll(result, "");
            }
            result += "Fizz";
        }

        return result.isEmpty() ? numberStr : result;
    }



}


