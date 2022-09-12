package test.equation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import equation.Simplify;

public class SimplifyTest {

    Simplify simplify;

    @Test
    public void simplifyTestOne(){

        simplify = new Simplify();

        ArrayList<String> list = new ArrayList<>();
        list.add("+5x");
        list.add("=");
        list.add("+10");

        simplify.simplify(list, 0);
        Assert.assertEquals(simplify.getAnswer(), "x=2");

    }

    @Test
    public void simplifyTestTwo(){

        simplify = new Simplify();

        ArrayList<String> list = new ArrayList<>();
        list.add("-5x");
        list.add("=");
        list.add("+10");

        simplify.simplify(list, 0);
        Assert.assertEquals(simplify.getAnswer(), "x=-2");

    }

    @Test
    public void simplifyTestThree(){

        simplify = new Simplify();

        ArrayList<String> list = new ArrayList<>();
        list.add("-13x");
        list.add("=");
        list.add("+5");

        simplify.simplify(list, 0);
        Assert.assertEquals(simplify.getAnswer(), "x=-(5/13)");

    }
    
}
