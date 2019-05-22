package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    @Test
    public void generateNums() {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        Random ran = mock(Random.class);
        when(ran.nextInt(9)).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
        assertEquals(randomIntGenerator.generateNums(9,4), "1 2 3 4");
    }
}