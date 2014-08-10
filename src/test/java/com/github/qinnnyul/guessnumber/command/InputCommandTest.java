package com.github.qinnnyul.guessnumber.command;

import com.github.qinnnyul.guessnumber.domain.Answer;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputCommandTest
{
    @Test
    public void should_be_able_to_get_answer_from_console() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));
        // when
        Answer answer = inputCommand.input();
        // then
        assertThat(answer.toString(), is("1 2 3 4"));
    }
}
