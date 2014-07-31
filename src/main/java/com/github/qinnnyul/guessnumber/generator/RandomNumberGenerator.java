package com.github.qinnnyul.guessnumber.generator;

import java.util.Random;
import java.util.Set;

import static com.github.qinnnyul.guessnumber.domain.AnswerConstant.ANSWER_RANGE;
import static com.github.qinnnyul.guessnumber.domain.AnswerConstant.ANSWER_SIZE;
import static com.google.common.collect.Sets.newLinkedHashSet;

public class RandomNumberGenerator
{

    private Random random;

    public RandomNumberGenerator(Random random)
    {
        this.random = random;
    }

    public Set<String> generate()
    {
        Set<String> numbers = newLinkedHashSet();
        while (numbers.size() < ANSWER_SIZE) {
            numbers.add(String.valueOf(createAnswerValue()));
        }
        return numbers;
    }

    private int createAnswerValue()
    {
        return random.nextInt(ANSWER_RANGE.upperEndpoint() - ANSWER_RANGE.lowerEndpoint()) + ANSWER_RANGE.lowerEndpoint();
    }

}
