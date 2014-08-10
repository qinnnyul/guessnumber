package com.github.qinnnyul.guessnumber.command;

import com.github.qinnnyul.guessnumber.domain.Answer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ConsoleInputCommandTest
{
    @Mock
    private BufferedReader bufferedReader;
    private ConsoleInputCommand consoleInputCommand;

    @Before
    public void setUp() throws Exception
    {
        initMocks(this);
        consoleInputCommand = new ConsoleInputCommand(bufferedReader);
    }

    @Test
    public void should_be_able_get_input() throws Exception
    {
        // given
        when(bufferedReader.readLine()).thenReturn("1 2 3 4");
        // when
        Answer answer = consoleInputCommand.input();
        // then
        assertThat(answer.toString(), is("1 2 3 4"));
    }

    @Test(expected = IOException.class)
    public void should_be_able_to_araise_exception_when_there_is_io_error() throws Exception
    {
        // given
        when(bufferedReader.readLine()).thenThrow(new IOException());
        // when
        consoleInputCommand.input();
        // then
    }
}
