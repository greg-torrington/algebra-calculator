package test.equation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import equation.Rearrange;

public class RearrangeTest {

    Rearrange rearrange;

    @Test
    public void rearrangeTestOne(){

        rearrange = new Rearrange();

        ArrayList<String> list = new ArrayList<>();
        list.add("+4");
        list.add("+2x");
        list.add("=");
        list.add("+1x");
        list.add("+10");

        list = rearrange.rearrangeList(list);
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "+2x+4=+1x+10");

    }

    @Test
    public void rearrangeTestTwo(){

        rearrange = new Rearrange();

        ArrayList<String> list = new ArrayList<>();
        list.add("+4");
        list.add("+4x");
        list.add("=");
        list.add("+10");

        list = rearrange.rearrangeList(list);
        String answer = "";
        for (int i=0; i<list.size(); i++){answer+=list.get(i);}
        Assert.assertEquals(answer, "+4x+4=+10");

    }
    
}
