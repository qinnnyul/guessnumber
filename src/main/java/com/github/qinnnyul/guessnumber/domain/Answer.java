package com.github.qinnnyul.guessnumber.domain;

import com.google.common.base.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.ANSWER_SEPARATOR;
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newLinkedHashSet;

public class Answer
{

    private static final String A = "A";
    private static final String B = "B";
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
        return new StringBuilder()
                .append(countA(newArrayList(number.split(ANSWER_SEPARATOR)), newArrayList(answer.number.split(ANSWER_SEPARATOR))))
                .append(A)
                .append(countB(newArrayList(number.split(ANSWER_SEPARATOR)), newArrayList(answer.number.split(ANSWER_SEPARATOR))))
                .append(B)
                .toString();
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

    public Set<String> getNumberAsSet()
    {
        return newLinkedHashSet(Arrays.asList(number.split(ANSWER_SEPARATOR)));
    }

    @Override
    public String toString()
    {
        return number;
    }
}

