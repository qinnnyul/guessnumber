package com.github.qinnnyul.guessnumber.validate;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.exception.AnswerLengthInvalidException;
import com.github.qinnnyul.guessnumber.exception.AnswerOutOfRangeException;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.ANSWER_RANGE;
import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.ANSWER_SIZE;

public class AnswerValidator
{
    public void validate(Answer answer)
    {
        boolean isInRange = Iterators.all(answer.getNumberAsSet().iterator(), new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return ANSWER_RANGE.contains(Integer.valueOf(number));
            }
        });

        if (!isInRange) {
            throw new AnswerOutOfRangeException();
        }
        if (answer.getNumberAsSet().size() != ANSWER_SIZE) {
            throw new AnswerLengthInvalidException();
        }
    }
}
