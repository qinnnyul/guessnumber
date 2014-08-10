package com.github.qinnnyul.guessnumber.constant;

import com.google.common.collect.Range;

public final class AnswerConstant
{
    public static final int ANSWER_SIZE = 4;
    public static final int GUESS_TIMES = 6;
    public static final String ANSWER_SEPARATOR = " ";
    public static final String RIGHT_RESULT = "4A0B";
    public static final Range<Integer> ANSWER_RANGE = Range.closed(0, 9);

    private AnswerConstant()
    {
    }
}
