package operands;

public class Addition implements Operand {

    @Override
    public int executeOperation(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }
}