package com.github.qinnnyul.guessnumber;

public class AnswerInvalidException extends RuntimeException
{
    public AnswerInvalidException(String message)
    {
        super(message);
    }
}
