package com.github.qinnnyul.guessnumber;

import com.sun.deploy.util.StringUtils;

import java.util.List;

public class AnswerGenerator
{
    private static final int LENGTH = 4;

    private RandomNumberGenerator randomNumberGenerator;

    public AnswerGenerator(RandomNumberGenerator randomNumberGenerator)
    {
        this.randomNumberGenerator = randomNumberGenerator;
    }


    public Answer generate()
    {
        List<String> numbers = randomNumberGenerator.generate(LENGTH);

        if (!Validator.isValid(numbers)) {
            throw new AnswerInvalidException("Not Valid Input");
        }
        return Answer.createAnswer(StringUtils.join(numbers, " "));
    }
}
