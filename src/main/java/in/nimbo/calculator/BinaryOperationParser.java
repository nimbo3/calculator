package in.nimbo.calculator;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryOperationParser {

    public final int firstNumber;
    public final int secondNumber;
    public final char operator;

    public BinaryOperationParser(String input){
        String pattern = "\\s*(\\d+)\\s*(\\+|\\-|/|\\*)\\s*(\\d+)\\s*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        if(matcher.find()){
            firstNumber = Integer.parseInt(matcher.group(1));
            operator = matcher.group(2).charAt(0);
            secondNumber = Integer.parseInt(matcher.group(3));
        }
        else
        {
            throw new InputMismatchException();
        }
    }
}
