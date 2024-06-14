class Division implements Operand {

    @Override
    public int executeOperation(int firstValue, int secondValue) throws Exception{
        if (Math.floorMod(firstValue, secondValue) == 0) {
            return firstValue / secondValue;
        } else {
            throw new Exception();
        }
    }
}
