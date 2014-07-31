package com.github.qinnnyul.guessnumber.domain;

import com.google.common.collect.Range;

public final class AnswerConstant
{
    public static final int ANSWER_SIZE = 4;
    public static final String ANSWER_SEPARATOR = " ";
    public static final Range<Integer> ANSWER_RANGE = Range.closed(0, 9);

    private AnswerConstant()
    {
    }
}
