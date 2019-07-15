package in.nimbo.calculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerBinaryOperatorParser {
    private int firstOperand;
    private int secondOperand;
    private char operand;

    public void parse(String input) {
        Pattern pattern = Pattern.compile("^(-?\\d+)\\s*([+\\-\\*\\/])\\s*(-?\\d+)$");
        Matcher matcher = pattern.matcher(input.trim());

        if(matcher.matches()){
            firstOperand = Integer.parseInt(matcher.group(1));
            operand = matcher.group(2).charAt(0);
            secondOperand = Integer.parseInt(matcher.group(3));
        }
        else {
            throw  new InputMismatchException();
        }
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public char getOperand() {
        return operand;
    }
}
