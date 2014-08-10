package com.github.qinnnyul.guessnumber.view;

import com.github.qinnnyul.guessnumber.domain.GuessResult;
import com.github.qinnnyul.guessnumber.service.Game;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.*;

public class GameViewTest
{
    @Test
    public void should_be_able_to_display_current_guess_name_and_result() throws Exception
    {
        // given
        GameView gameView = new ConsoleGameView();
        Game game = mock(Game.class);
        when(game.getHistory()).thenReturn(newArrayList(new GuessResult("1 2 3 4", "4A0B"), new GuessResult("2 3 4 5", "0A3B")));
        // when
        gameView.display(game.getHistory());
        // then
        verify(game, times(1)).getHistory();
    }

}
