package com.github.qinnnyul.guessnumber.command;

import com.github.qinnnyul.guessnumber.domain.Answer;

import java.io.IOException;

public interface InputCommand
{
    Answer input() throws IOException;
}
