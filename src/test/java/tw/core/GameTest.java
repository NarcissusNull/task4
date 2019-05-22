package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    @Test
    public void guess() throws OutOfRangeAnswerException {
        Answer inputAnswer = Answer.createAnswer("1 3 2 0");
        GuessResult result = new GuessResult("1A2B", inputAnswer);
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Game game = new Game(answerGenerator);
        assertEquals(game.guess(inputAnswer).getResult(), result.getResult());
    }

}
