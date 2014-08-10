package com.github.qinnnyul.guessnumber.command;

import com.github.qinnnyul.guessnumber.domain.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputCommand implements InputCommand
{
    private BufferedReader bufferedReader;

    public ConsoleInputCommand(BufferedReader bufferedReader)
    {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public Answer input() throws IOException
    {
        return Answer.createAnswer(bufferedReader.readLine());
    }
}
