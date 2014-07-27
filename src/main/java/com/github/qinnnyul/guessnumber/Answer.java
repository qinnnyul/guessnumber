package com.github.qinnnyul.guessnumber;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class Answer
{

    private String number;

    public Answer(String number)
    {
        this.number = number;
    }

    public static Answer createAnswer(String number)
    {
        return new Answer(number);
    }

    public String compare(Answer answer)
    {
        return countA(newArrayList(number.split(" ")), newArrayList(answer.number.split(" ")))
                + "A" + countB(newArrayList(number.split(" ")), newArrayList(answer.number.split(" "))) + "B";
    }

    private int countB(final List<String> actualNumbers, final List<String> inputNumbers)
    {
        return from(inputNumbers).filter(new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return actualNumbers.contains(number) && actualNumbers.indexOf(number) != inputNumbers.indexOf(number);
            }
        }).toList().size();
    }

    private int countA(final List<String> actualNumbers, final List<String> inputNumbers)
    {
        return from(inputNumbers).filter(new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return actualNumbers.contains(number) && actualNumbers.indexOf(number) == inputNumbers.indexOf(number);
            }
        }).toList().size();
    }

    @Override
    public String toString()
    {
        return number;
    }
}

