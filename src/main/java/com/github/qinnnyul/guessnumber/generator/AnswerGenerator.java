package com.github.qinnnyul.guessnumber.generator;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.validate.AnswerValidator;
import com.google.common.base.Joiner;

import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.ANSWER_SEPARATOR;

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
        Answer answer = Answer.createAnswer(Joiner.on(ANSWER_SEPARATOR).join(randomNumberGenerator.generate()));
        answerValidator.validate(answer);
        return answer;
    }
}
