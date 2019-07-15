package in.nimbo.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;

public class IntegerBinaryOperatorParserTest {


    @Test
    public void testAddOperator(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("1 + 2");
        Assert.assertEquals("firstOperand mismatch:", 1,
                integerBinaryOperatorParser.getFirstOperand());
        Assert.assertEquals("secondOperand mismatch:", 2,
                integerBinaryOperatorParser.getSecondOperand());
        Assert.assertEquals("operator mismatch:", '+',
                integerBinaryOperatorParser.getOperand());
    }

    @Test
    public void testSpaceInAddOperator(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("      1+         2");
        Assert.assertEquals("firstOperand mismatch:", 1,
                integerBinaryOperatorParser.getFirstOperand());
        Assert.assertEquals("secondOperand mismatch:", 2,
                integerBinaryOperatorParser.getSecondOperand());
        Assert.assertEquals("operator mismatch:", '+',
                integerBinaryOperatorParser.getOperand());
    }

    @Test(expected = InputMismatchException.class)
    public void testEmptyInput(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("");
    }

    @Test(expected = InputMismatchException.class)
    public void testInvalidInput(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("2a + 3");
    }

    @Test
    public void testNegativeOperand(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("-1 + -2");
        Assert.assertEquals("firstOperand mismatch:", -1,
                integerBinaryOperatorParser.getFirstOperand());
        Assert.assertEquals("secondOperand mismatch:", -2,
                integerBinaryOperatorParser.getSecondOperand());
        Assert.assertEquals("operator mismatch:", '+',
                integerBinaryOperatorParser.getOperand());
    }

    @Test(expected = InputMismatchException.class)
    public void testMultipleOperand(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("2 ++ 3");
    }

    @Test(expected = NumberFormatException.class)
    public void testBigNumber(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse("2147483648 + -2");
    }

    @Test
    public void testBigValidNumber(){
        IntegerBinaryOperatorParser integerBinaryOperatorParser = new IntegerBinaryOperatorParser();
        integerBinaryOperatorParser.parse(Integer.MAX_VALUE +" + -2");
        Assert.assertEquals("firstOperand mismatch:", Integer.MAX_VALUE,
                integerBinaryOperatorParser.getFirstOperand());
        Assert.assertEquals("secondOperand mismatch:", -2,
                integerBinaryOperatorParser.getSecondOperand());
        Assert.assertEquals("operator mismatch:", '+',
                integerBinaryOperatorParser.getOperand());
    }
}
