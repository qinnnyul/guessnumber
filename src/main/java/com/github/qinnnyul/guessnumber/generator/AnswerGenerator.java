package com.github.qinnnyul.guessnumber.generator;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.validate.AnswerValidator;
import com.google.common.base.Joiner;

import java.util.Set;

import static com.github.qinnnyul.guessnumber.domain.AnswerConstant.ANSWER_SEPRARTOR;

public class AnswerGenerator
{

    private RandomNumberGenerator randomNumberGenerator;
    private AnswerValidator answerValidator;

    public AnswerGenerator(RandomNumberGenerator randomNumberGenerator, AnswerValidator answerValidator)
    {
        this.randomNumberGenerator = randomNumberGenerator;
        this.answerValidator = answerValidator;
    }

    public Answer generate()
    {
        Set<String> numbers = randomNumberGenerator.generate();
        answerValidator.validate(numbers);
        return Answer.createAnswer(Joiner.on(ANSWER_SEPRARTOR).join(numbers));
    }
}
