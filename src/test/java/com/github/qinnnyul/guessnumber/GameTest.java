package com.github.qinnnyul.guessnumber;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.domain.GuessResult;
import com.github.qinnnyul.guessnumber.service.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest
{
    private Answer actualAnswer;
    private Game game;

    @Before
    public void setUp() throws Exception
    {
        actualAnswer = Answer.createAnswer("1 2 3 4");
        game = new Game(actualAnswer);
    }


    @Test
    public void should_be_able_to_return_0A0B_if_all_number_are_not_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_be_able_to_return_4A0B_if_all_number_are_correct()
    {
        //given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result, is("4A0B"));
    }


    @Test
    public void should_be_able_to_return_0A2B_if_input_2478_for_1234()
    {
        //given
        Answer answer = Answer.createAnswer("2 4 7 8");

        //when
        String result = game.guess(answer);

        //then
        assertThat(result, is("0A2B"));
    }

    @Test
    public void should_be_able_to_return_1A2B_if_input_0324_for_1234()
    {
        //given
        Answer answer = Answer.createAnswer("0 3 2 4");

        //when
        String result = game.guess(answer);

        //then
        assertThat(result, is("1A2B"));
    }


    @Test
    public void should_be_able_to_return_0A4B_if_input_4321_for_1234()
    {
        //given
        Answer answer = Answer.createAnswer("4 3 2 1");

        //when
        String result = game.guess(answer);

        //then
        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_be_able_to_get_history_from_game() throws Exception
    {
        // given
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("4 5 3 1"));
        // when
        List<GuessResult> records = game.getHistory();
        // then

        assertThat(records.size(), is(2));
    }
}
