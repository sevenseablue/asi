package part2;

import org.junit.Test;
import part1.*;

import static org.junit.Assert.*;

/**
 * Created by seven on 05/07/16.
 */
public class InterpreterTest {
    @Test
    public void expr() throws Exception {
        Interpreter interpreter = new Interpreter(" 13  +15 ");
        assertEquals(interpreter.expr(), 28);
        interpreter = new Interpreter(" 13-  15 ");
        assertEquals(interpreter.expr(), -2);
        interpreter = new Interpreter(" 13 *  15 ");
        assertEquals(interpreter.expr(), 13*15);
        interpreter = new Interpreter(" 13/  15 ");
        assertEquals(interpreter.expr(), 0);
    }

}