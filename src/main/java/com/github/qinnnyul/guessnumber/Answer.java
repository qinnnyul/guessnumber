package com.github.qinnnyul.guessnumber;

public class Answer
{
    private String number;

    public Answer(String number)
    {
        this.number = number;
    }

    public static Answer createAnswer(String number)
    {
        return new Answer(number);
    }
}


