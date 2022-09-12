package test.equation;

import org.junit.Assert;
import org.junit.Test;

import equation.EquationFormatter;

import java.util.ArrayList;

public class EquationFormatterTest {

    EquationFormatter equationFormatter;

    @Test
    public void equationFormatTest(){

        equationFormatter = new EquationFormatter();

        ArrayList<String> list = equationFormatter.formatString("2(2x +1 )- 3 = 4(-x-4 )-3x");
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "+2(2x+1)-3=+4(-1x-4)-3x");

    }
    
}
