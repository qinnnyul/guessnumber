package com.github.qinnnyul.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest
{
    private Answer actualAnswer;

    @Before
    public void setUp() throws Exception
    {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }


    @Test
    public void should_be_able_to_return_0A0B_if_all_number_are_not_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");
        Game game = new Game(actualAnswer);

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
        Game game = new Game(actualAnswer);

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result, is("4A0B"));
    }
}
