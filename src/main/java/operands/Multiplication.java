package operands;

public class Multiplication implements Operand {

    @Override
    public int executeOperation(int firstValue, int secondValue){
        return firstValue * secondValue;
    }
}
