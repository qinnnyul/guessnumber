package com.github.qinnnyul.guessnumber.service;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.domain.GuessResult;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.util.List;

import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.RIGHT_RESULT;
import static com.google.common.collect.Lists.newArrayList;

public class Game
{
    private final Answer actualAnswer;
    private List<GuessResult> history;

    public Game(Answer actualAnswer)
    {
        this.actualAnswer = actualAnswer;
    }

    public String guess(Answer inputAnswer)
    {
        addHistoryItem(inputAnswer);
        return actualAnswer.compare(inputAnswer);
    }

    private void addHistoryItem(Answer inputAnswer)
    {
        if (history == null) {
            history = newArrayList();
        }
        GuessResult guessResult = new GuessResult(inputAnswer.toString(), actualAnswer.compare(inputAnswer));
        history.add(guessResult);
    }

    public List<GuessResult> getHistory()
    {
        return this.history;
    }

    public boolean isSuccess()
    {
        return Iterators.any(history.iterator(), new Predicate<GuessResult>()
        {
            @Override
            public boolean apply(GuessResult guessResult)
            {
                return guessResult.getResult().equals(RIGHT_RESULT);
            }
        });
    }
}
