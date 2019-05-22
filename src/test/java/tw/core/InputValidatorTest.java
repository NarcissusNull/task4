package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.junit.Assert.assertEquals;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void validate() {
        InputValidator inputValidator = new InputValidator();
        assertEquals(inputValidator.validate("1 2"), false);
        assertEquals(inputValidator.validate("1 2 34 3"), false);
        assertEquals(inputValidator.validate("1 2 3 4"), true);
    }

}
