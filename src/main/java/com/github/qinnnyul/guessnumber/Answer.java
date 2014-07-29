package com.github.qinnnyul.guessnumber;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class Answer
{

    public static final String A = "A";
    public static final String B = "B";
    public static final String DEMILITER = " ";
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
        return new StringBuilder().append(countA(newArrayList(number.split(DEMILITER)), newArrayList(answer.number.split(DEMILITER)))).append(A)
                .append(countB(newArrayList(number.split(DEMILITER)), newArrayList(answer.number.split(DEMILITER)))).append(B).toString();

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

}

