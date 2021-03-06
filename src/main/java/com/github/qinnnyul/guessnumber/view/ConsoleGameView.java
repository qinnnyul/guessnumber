package com.github.qinnnyul.guessnumber.view;

import com.github.qinnnyul.guessnumber.domain.GuessResult;

import java.util.List;

public class ConsoleGameView implements GameView
{
    @Override
    public void display(List<GuessResult> history)
    {
        for (GuessResult guessResult : history){
            displayGuessResult(guessResult);
        }
    }

    private void displayGuessResult(GuessResult guessResult)
    {
        System.out.println(guessResult.getAnswer() + ":" + guessResult.getResult());
    }

}
