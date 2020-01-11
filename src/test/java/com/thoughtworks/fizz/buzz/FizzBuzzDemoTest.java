package com.thoughtworks.fizz.buzz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FizzBuzzDemoTest {

    @Test
    public void return_this_number_when_number_is_common() {

        FizzBuzzDemo fizzBuzzDemo = new FizzBuzzDemo();
        String result = fizzBuzzDemo.fizzBuzz(2);
        assertThat(result, is("2"));
    }

    @Test
    public void return_fizz_when_number_is_a_multiplier_of_3() {
        FizzBuzzDemo fizzBuzzDemo = new FizzBuzzDemo();
        String result = fizzBuzzDemo.fizzBuzz(9);
        assertThat(result, is("Fizz"));
    }


    @Test
    public void return_buzz_when_number_is_a_multiplier_of_5() {
        FizzBuzzDemo fizzBuzzDemo = new FizzBuzzDemo();
        String result = fizzBuzzDemo.fizzBuzz(20);
        assertThat(result, is("Buzz"));
    }

    @Test
    public void return_whizz_when_number_is_a_multiplier_of_7() {
        FizzBuzzDemo fizzBuzzDemo = new FizzBuzzDemo();
        String result = fizzBuzzDemo.fizzBuzz(14);
        assertThat(result, is("Whizz"));
    }

}