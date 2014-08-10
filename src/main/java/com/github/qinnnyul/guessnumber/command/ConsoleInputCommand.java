package com.github.qinnnyul.guessnumber.command;

import com.github.qinnnyul.guessnumber.domain.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputCommand implements InputCommand
{
    private BufferedReader bufferedReader;

    @Override
    public Answer input() throws IOException
    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Answer.createAnswer(bufferedReader.readLine());
    }
}
