package test.equation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import equation.Addition;

public class AdditionTest {

    Addition addition;

    @Test
    public void additionTestOne(){

        addition = new Addition();

        ArrayList<String> list = new ArrayList<>();
        list.add("+2");
        list.add("+5x");
        list.add("-7");
        list.add("=");
        list.add("+1x");
        list.add("-9x");
        list.add("+10");

        list = addition.addNumbers(list);
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "-5+5x=-8x+10");

    }

    @Test
    public void additionTestTwo(){

        addition = new Addition();

        ArrayList<String> list = new ArrayList<>();
        list.add("+7");
        list.add("+5x");
        list.add("-3");
        list.add("+1x");
        list.add("=");
        list.add("+10x");
        list.add("-8");
        list.add("-5x");
        list.add("+4");
        list.add("+4");

        list = addition.addNumbers(list);
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "+4+6x=+5x");
    }

    @Test
    public void additionTestThree(){

        addition = new Addition();

        ArrayList<String> list = new ArrayList<>();
        list.add("+7");
        list.add("+5x");
        list.add("-3");
        list.add("-5x");
        list.add("=");
        list.add("+10x");
        list.add("-8");
        list.add("-10x");

        list = addition.addNumbers(list);
        Assert.assertEquals(list, null);

    }
    
}
