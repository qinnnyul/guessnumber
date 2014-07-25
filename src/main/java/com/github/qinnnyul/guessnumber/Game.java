package com.github.qinnnyul.guessnumber;

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
