package test.equation;

import org.junit.Assert;
import org.junit.Test;

import equation.Distributive;

import java.util.ArrayList;

public class DistributiveTest {

    Distributive distributive;

    @Test
    public void distributiveTestOne(){

        distributive = new Distributive();

        ArrayList<String> list = new ArrayList<>();
        list.add("+3x");
        list.add("+2");
        list.add("(");
        list.add("+1x");
        list.add("-3");
        list.add(")");
        list.add("=");
        list.add("+1");
        list.add("(");
        list.add("-5x");
        list.add("+4");
        list.add(")");

        list = distributive.workoutDistributivity(list);
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "+3x+2x-6=-5x+4");

    }
    
}
