package test.equation;

import org.junit.Assert;
import org.junit.Test;

import equation.AddingBothSides;

import java.util.ArrayList;

public class AddingBothSidesTest {

    AddingBothSides addingBothSides;

    @Test
    public void addingBothSideTestOne(){

        ArrayList<String> list = new ArrayList<>();
        list.add("+2x");
        list.add("-3");
        list.add("=");
        list.add("+4x");
        list.add("+10");

        String answer = "-2x=+13";
        addingBothSides = new AddingBothSides();
        list = addingBothSides.addToBothSides(list, 0);
        String tempAnswer = "";
        for (int i=0; i<list.size(); i++){tempAnswer+=list.get(i);}
        Assert.assertEquals(tempAnswer, answer);

    }

    @Test
    public void addingBothSideTestTwo(){

        ArrayList<String> list = new ArrayList<>();
        list.add("-3");
        list.add("=");
        list.add("+4x");
        list.add("+8");

        String answer = "-4x=+11";
        addingBothSides = new AddingBothSides();
        list = addingBothSides.addToBothSides(list, 0);
        String tempAnswer = "";
        for (int i=0; i<list.size(); i++){tempAnswer+=list.get(i);}
        Assert.assertEquals(tempAnswer, answer);

    }

    @Test
    public void addingBothSideTestThree(){

        ArrayList<String> list = new ArrayList<>();
        list.add("-3x");
        list.add("+4");
        list.add("=");
        list.add("-3x");
        list.add("+8");

        addingBothSides = new AddingBothSides();
        list = addingBothSides.addToBothSides(list, 0);
        Assert.assertEquals(list, null);

    }
    
}
