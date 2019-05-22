package tw.controllers;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    @Test
    public void beginGame() throws OutOfRangeAnswerException, IOException {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Game game = new Game(answerGenerator);
        GameView gameView = new GameView();
        GameController gameController = new GameController(game, gameView);
        ByteOutputStream out = new ByteOutputStream();
        System.setOut(new PrintStream(out));
        gameController.beginGame();
        assertEquals(out.toString(), "------Guess Number Game, You have 6 chances to guess!  ------\r\n");
    }

}