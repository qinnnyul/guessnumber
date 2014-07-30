package com.github.qinnnyul.guessnumber;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public final class Validator
{
    private Validator()
    {
    }

    public static boolean isValid(List<String> numbers)
    {
        return from(numbers).filter(new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return Integer.valueOf(number) <= 9 && Integer.valueOf(number) >= 0;
            }
        }).toSet().size() == 4;
    }
}
