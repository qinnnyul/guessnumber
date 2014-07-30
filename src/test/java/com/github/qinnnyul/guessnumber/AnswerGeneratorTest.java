package com.github.qinnnyul.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{

    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception
    {
        answerGenerator = new AnswerGenerator(new RandomNumberGenerator());
    }


    @Test
    public void should_be_able_to_generate_answer() throws Exception
    {
        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer, notNullValue());
    }

    @Test(expected = AnswerInvalidException.class)
    public void should_raise_error_when_generated_invalid_answer() throws Exception
    {
        //given
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate(4)).thenReturn(newArrayList("1", "2", "4", "4"));
        answerGenerator = new AnswerGenerator(randomNumberGenerator);

        // when
        answerGenerator.generate();

    }
}
