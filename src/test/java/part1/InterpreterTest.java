package part1;

import Util.ConstVal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seven on 05/07/16.
 */
public class InterpreterTest {
    Interpreter interpreter;

    @Before
    public void setUp() throws Exception {
        interpreter = new Interpreter("3+5");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNextToken() throws Exception {
        Interpreter interpreter = new Interpreter("3+5");
        assertEquals(new Token(ConstVal.INTEGER, "3"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.PLUS, "+"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.INTEGER, "5"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.EOF, null), interpreter.getNextToken());
    }

    @Test
    public void getNextTokenMultiDigits() throws Exception {
        Interpreter interpreter = new Interpreter(" 13 +  025  ");
        assertEquals(new Token(ConstVal.INTEGER, "13"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.PLUS, "+"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.INTEGER, "025"), interpreter.getNextToken());
        assertEquals(new Token(ConstVal.EOF, null), interpreter.getNextToken());
    }

    @Test
    public void skipWhiteSpace() throws Exception {
        Interpreter interpreter = new Interpreter(" 3+  5  ");
        assertEquals(8, interpreter.expr());
    }

    @Test
    public void expr() throws Exception {
        Interpreter interpreter = new Interpreter(" 13  +15 ");
        assertEquals(interpreter.expr(), 28);
        interpreter = new Interpreter(" 13-  15 ");
        assertEquals(interpreter.expr(), -2);
    }

}