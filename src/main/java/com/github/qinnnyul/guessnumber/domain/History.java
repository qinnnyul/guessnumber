package com.github.qinnnyul.guessnumber.domain;

import java.util.Map;

import static com.google.common.collect.Maps.newLinkedHashMap;

public class History
{
    private Map<Answer, String> records;

    public Map<Answer, String> show()
    {
        return records;
    }

    public void add(Answer answer, String result)
    {
        if (records == null) {
            records = newLinkedHashMap();
        }
        records.put(answer, result);
    }
}
