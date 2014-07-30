package com.github.qinnnyul.guessnumber;

import com.github.qinnnyul.guessnumber.domain.Answer;

public class Game
{
    private final Answer actualAnswer;

    public Game(Answer actualAnswer)
    {
        this.actualAnswer = actualAnswer;
    }

    public String guess(Answer inputAnswer)
    {
        return actualAnswer.compare(inputAnswer);
    }

}
