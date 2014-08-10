package com.github.qinnnyul.guessnumber.domain;

public class GuessResult
{
    private String answer;
    private String result;

    public GuessResult(String answer, String result)
    {
        this.answer = answer;
        this.result = result;
    }

    public String getAnswer()
    {
        return answer;
    }

    public String getResult()
    {
        return result;
    }
}
