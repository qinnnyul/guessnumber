package com.github.qinnnyul.guessnumber.validate;

import com.github.qinnnyul.guessnumber.exception.AnswerOutOfRangeException;
import com.github.qinnnyul.guessnumber.exception.AnswerLengthInvalidException;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.util.Set;

import static com.github.qinnnyul.guessnumber.domain.AnswerConstant.ANSWER_RANGE;
import static com.github.qinnnyul.guessnumber.domain.AnswerConstant.ANSWER_SIZE;

public class AnswerValidator
{
    public void validate(Set<String> numbers)
    {
        boolean isInRange = Iterators.all(numbers.iterator(), new Predicate<String>()
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
        if (numbers.size() != ANSWER_SIZE) {
            throw new AnswerLengthInvalidException();
        }
    }
}
