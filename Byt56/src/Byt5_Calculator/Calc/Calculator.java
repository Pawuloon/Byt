package Byt5_Calculator.Calc;

import Byt5_Calculator.Calc.Interfaces.ICalculator;
import Byt5_Calculator.Calc.Operations.Addition;
import Byt5_Calculator.Calc.Operations.Division;
import Byt5_Calculator.Calc.Operations.Multiplication;
import Byt5_Calculator.Calc.Operations.Subtraction;

import java.util.List;

public class Calculator
{
    private final List<ICalculator> operations;

    public Calculator()
    {
        this.operations = List.of(new Addition(), new Subtraction(), new Division(), new Multiplication());
    }

    public double calculate(double a, double b, char operator)
    {
        try
        {
            for (ICalculator operation : operations)
            {
                if (operation.isOperator(operator))
                {
                    return operation.calculate(a, b);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        throw new IllegalArgumentException("Invalid operator");
    }
}
