package in.nimbo.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BinaryOperationParserTest {

    @Test
    public void testAddParser(){
        String input = "2 + 3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(2, parser.firstNumber);
        assertEquals(3, parser.secondNumber);
        assertEquals('+', parser.operator);
    }

    @Test
    public void testMinusParser(){
        String input = "2 - 3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(2, parser.firstNumber);
        assertEquals(3, parser.secondNumber);
        assertEquals('-', parser.operator);
    }

    @Test
    public void testMultiplyParser(){
        String input = "2 * 3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(2, parser.firstNumber);
        assertEquals(3, parser.secondNumber);
        assertEquals('*', parser.operator);
    }


    @Test
    public void testDivideParser(){
        String input = "2 / 3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(2, parser.firstNumber);
        assertEquals(3, parser.secondNumber);
        assertEquals('/', parser.operator);
    }


    @Test
    public void testNegativeNumberDivideParser(){
        String input = "-2 / 3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(-2, parser.firstNumber);
        assertEquals(3, parser.secondNumber);
        assertEquals('/', parser.operator);
    }

    @Test
    public void testTwoNegativeNumberDivideParser(){
        String input = "-2 / -3";
        BinaryOperationParser parser = new BinaryOperationParser(input);
        assertEquals(-2, parser.firstNumber);
        assertEquals(-3, parser.secondNumber);
        assertEquals('/', parser.operator);
    }

}
