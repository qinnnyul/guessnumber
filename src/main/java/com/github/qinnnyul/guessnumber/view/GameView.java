package com.github.qinnnyul.guessnumber.view;

import com.github.qinnnyul.guessnumber.domain.GuessResult;

import java.util.List;

public interface GameView
{

    void display(List<GuessResult> history);
}
