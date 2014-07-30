package com.github.qinnnyul.guessnumber;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

public class RandomNumberGenerator
{
    public List<String> generate(int length)
    {
        List<String> numbers = Lists.newArrayList();
        for (int i = 0; i < length; ) {
            String number = String.valueOf(new Random().nextInt(10));
            if (!numbers.contains(number)) {
                numbers.add(number);
                i++;
            }
        }

        return numbers;
    }
}
