package operands;

public class Subtraction implements Operand {

    @Override
    public int executeOperation(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
}
