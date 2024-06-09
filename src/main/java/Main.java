import operands.*;
import utils.ConvertingUtils;
import utils.ValidationUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static boolean isRoman;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(reader.readLine()));
    }

    public static String calc(String input) throws Exception {
        String[] rawData = input.split("\\s");
        if (!validateInput(rawData)) throw new Exception();

        int firstValue = parseInteger(rawData[0]);
        int secondValue = parseInteger(rawData[2]);
        Operand operand = parseOperand(rawData[1]);

        return parseResult(operand.executeOperation(firstValue, secondValue));
    }

    private static boolean validateInput(String[] data){
        try {
            ValidationUtils.validateNumberOfInputs(data);
            isRoman = ValidationUtils.validateValues(data);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static int parseInteger(String input) throws Exception{
        if (isRoman) {
            return ConvertingUtils.romanToInt(input);
        }
        return Integer.parseInt(input);
    }

    private static String parseResult(int result) {
        if (isRoman) {
            return ConvertingUtils.intToRoman(result);
        }
        return Integer.toString(result);
    }

    private static Operand parseOperand(String input) throws Exception{
        return switch (input) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "/" -> new Division();
            case "*" -> new Multiplication();
            default -> throw new Exception();
        };
    }
}