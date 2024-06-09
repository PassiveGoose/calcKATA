package operands;

import operands.Operand;

public class Subtraction implements Operand {

    @Override
    public int executeOperation(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
}
