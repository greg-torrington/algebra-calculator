package test.equation;

import org.junit.Assert;
import org.junit.Test;

import equation.AddingBothSides;
import equation.Addition;
import equation.Distributive;
import equation.EquationCalculator;
import equation.EquationFormatter;
import equation.Rearrange;
import equation.Simplify;

public class EquationCalculatorTest {

    AddingBothSides addingBothSides;
    Addition addition;
    Distributive distributive;
    EquationCalculator equationCalculator;
    EquationFormatter equationFormatter;
    Rearrange rearrange;
    Simplify simplify;

    @Test
    public void equationCalculatorEverythingTest(){
        equationCalculator = new EquationCalculator();
        equationCalculator.runCalculator("2x+3(x+1)=-(1+x)-3");
        Assert.assertEquals(equationCalculator.getFinalResult(), "x=-(7/6)");
        Assert.assertEquals(equationCalculator.getCounter(), 6);
    }

    @Test
    public void equationCalculatorWithoutRearrange(){
        equationCalculator = new EquationCalculator();
        equationCalculator.runCalculator("2x+3(x+1)=-(x+1)-3");
        Assert.assertEquals(equationCalculator.getFinalResult(), "x=-(7/6)");
        Assert.assertEquals(equationCalculator.getCounter(), 5);
    }


    @Test
    public void equationCalculatorWithoutRearrangeOrDistribution(){
        equationCalculator = new EquationCalculator();
        equationCalculator.runCalculator("2x+3x+1=-x+1-3");
        Assert.assertEquals(equationCalculator.getFinalResult(), "x=1/-2");
        Assert.assertEquals(equationCalculator.getCounter(), 4);
    }
    
    
}
