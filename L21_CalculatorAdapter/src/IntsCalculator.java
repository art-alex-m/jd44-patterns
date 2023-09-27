public class IntsCalculator implements Ints {
    private final Calculator calculator;

    public IntsCalculator() {
        this.calculator = new Calculator();
    }

    @Override
    public int sum(int arg0, int arg1) {
        return (int) makeFormula(arg0, arg1)
                .calculate(Calculator.Operation.SUM)
                .result();
    }

    @Override
    public int mult(int arg0, int arg1) {
        return (int) makeFormula(arg0, arg1)
                .calculate(Calculator.Operation.MULT)
                .result();
    }

    @Override
    public int pow(int a, int b) {
        return (int) makeFormula(a, b)
                .calculate(Calculator.Operation.POW)
                .result();
    }

    private Calculator.Formula makeFormula(int arg0, int arg1) {
        return calculator.newFormula()
                .addOperand(arg0)
                .addOperand(arg1);
    }
}
