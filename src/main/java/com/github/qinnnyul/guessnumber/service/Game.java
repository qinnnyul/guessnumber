package com.github.qinnnyul.guessnumber.service;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.domain.GuessResult;

import java.util.List;

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
}
