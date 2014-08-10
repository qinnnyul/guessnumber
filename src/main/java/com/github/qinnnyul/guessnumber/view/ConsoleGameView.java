package com.github.qinnnyul.guessnumber.view;

import com.github.qinnnyul.guessnumber.domain.GuessResult;

import java.util.List;

public class ConsoleGameView implements GameView
{
    @Override
    public void display(List<GuessResult> history)
    {
        for (GuessResult guessResult : history){
            System.out.println(guessResult.getAnswer() + ":" + guessResult.getResult());
        }
    }
}
