package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void setNumList() throws NoSuchFieldException, IllegalAccessException {
        List<String> result = new ArrayList<>();
        result.add("1");
        result.add("2");
        result.add("3");
        result.add("4");

        Answer answer = new Answer();
        answer.setNumList(result);

        Field field = answer.getClass().getDeclaredField("numList");
        field.setAccessible(true);
        assertEquals(field.get(answer), result);
    }

    @Test
    public void createAnswer() throws NoSuchFieldException, IllegalAccessException {
        List<String> result = new ArrayList<>();
        result.add("1");
        result.add("2");
        result.add("3");
        result.add("4");

        Answer answer = Answer.createAnswer("1 2 3 4");
        Field field = answer.getClass().getDeclaredField("numList");
        field.setAccessible(true);
        assertEquals(field.get(answer), result);
    }

    @Test
    public void validate() {
        Answer answer = Answer.createAnswer("11 2 3 4");

        try {
            answer.validate();
        } catch (OutOfRangeAnswerException e) {
            assertEquals(e.getMessage(), "Answer format is incorrect");
        }
    }

    @Test
    public void check() {
        Answer answer1 = Answer.createAnswer("1 2 3 4");
        Answer answer2 = Answer.createAnswer("1 3 2 0");

        Record record = answer1.check(answer2);
        assertEquals(record.getValue(), "1A2B");
    }

}