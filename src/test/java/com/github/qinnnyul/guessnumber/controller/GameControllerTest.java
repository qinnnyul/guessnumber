package com.github.qinnnyul.guessnumber.controller;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.view.GameView;
import com.github.qinnnyul.guessnumber.command.InputCommand;
import com.github.qinnnyul.guessnumber.service.Game;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameControllerTest
{
    @Test
    public void should_return_six_times_when_you_input_wrong_answer_all_the_time() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("3 4 5 6"));
        Game game = new Game(Answer.createAnswer("1 2 3 4"));
        GameView gameView = mock(GameView.class);

        GameController gameController = new GameController(game, gameView);
        // when
        gameController.play(inputCommand);
        // then
        verify(inputCommand, times(6)).input();
    }
}
