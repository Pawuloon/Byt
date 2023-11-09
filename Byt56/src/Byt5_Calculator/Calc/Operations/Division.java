package Byt5_Calculator.Calc.Operations;

import Byt5_Calculator.Calc.Interfaces.ICalculator;

public class Division implements ICalculator
{

    @Override
    public boolean isOperator(char c) {
        return c == '/';
    }

    @Override
    public double calculate(double a, double b) {
        return a / b;
    }
}
