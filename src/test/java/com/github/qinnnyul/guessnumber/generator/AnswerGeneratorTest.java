package com.github.qinnnyul.guessnumber.generator;

import com.github.qinnnyul.guessnumber.domain.Answer;
import com.github.qinnnyul.guessnumber.exception.AnswerLengthInvalidException;
import com.github.qinnnyul.guessnumber.exception.AnswerOutOfRangeException;
import com.github.qinnnyul.guessnumber.generator.AnswerGenerator;
import com.github.qinnnyul.guessnumber.generator.RandomNumberGenerator;
import com.github.qinnnyul.guessnumber.validate.AnswerValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{

    private AnswerGenerator answerGenerator;
    private AnswerValidator answerValidator;

    @Before
    public void setUp() throws Exception
    {
        answerValidator = new AnswerValidator();
        answerGenerator = new AnswerGenerator(new RandomNumberGenerator(new Random()), answerValidator);
    }


    @Test
    public void should_be_able_to_generate_answer() throws Exception
    {
        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer, notNullValue());
    }

    @Test(expected = AnswerOutOfRangeException.class)
    public void should_raise_error_when_generated_answer_is_out_of_range() throws Exception
    {
        //given
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn(newHashSet("1", "2", "10", "4"));
        answerGenerator = new AnswerGenerator(randomNumberGenerator, answerValidator);

        // when
        answerGenerator.generate();

    }

    @Test(expected = AnswerLengthInvalidException.class)
    public void should_raise_error_when_generated_answer_length_is_not_4() throws Exception
    {
        // given
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn(newHashSet("1", "2"));
        answerGenerator = new AnswerGenerator(randomNumberGenerator, answerValidator);

        // when
        answerGenerator.generate();

    }
}
