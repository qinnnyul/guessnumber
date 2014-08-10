package com.github.qinnnyul.guessnumber.controller;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.view.GameView;
import com.github.qinnnyul.guessnumber.command.InputCommand;
import com.github.qinnnyul.guessnumber.service.Game;

import java.io.IOException;

import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.GUESS_TIMES;
import static com.github.qinnnyul.guessnumber.constant.AnswerConstant.RIGHT_RESULT;

public class GameController
{
    private final Game game;
    private final GameView gameView;

    public GameController(Game game, GameView gameView)
    {
        this.game = game;
        this.gameView = gameView;
    }

    public void play(InputCommand inputCommand) throws IOException
    {
        String result = "";
        int size = 0;
        do {
            Answer answer = inputCommand.input();
            result = game.guess(answer);
            size++;
        } while (!RIGHT_RESULT.equals(result) && size < GUESS_TIMES);

        System.out.println(game.getHistory().contains(RIGHT_RESULT) ? "Success" : "failed");
    }
}
