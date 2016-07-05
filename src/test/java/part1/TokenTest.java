package part1;

import static org.junit.Assert.*;

/**
 * Created by seven on 05/07/16.
 */
public class TokenTest {
    Token t1;
    Token t12;
    Token t2;
    Token t3;
    @org.junit.Before
    public void setUp() throws Exception {
        t1 = new Token("INTEGER", "1");
        t12 = new Token("INTEGER", "1");
        t2 = new Token("PLUS", "+");
        t3 = new Token("EOF", "EOF");

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void equalsT() throws Exception {
        assertEquals(t1.equals(t12), true);
    }

    @org.junit.Test
    public void hashCodeT() throws Exception {

    }

}