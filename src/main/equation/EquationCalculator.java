package equation;

import java.util.ArrayList;

public class EquationCalculator {
    
    ArrayList<String> valuesArray =  new ArrayList<>();
    ArrayList<String> addedArrayList =  new ArrayList<>();


    EquationFormatter equationFormatter = new EquationFormatter();
    Distributive distributive = new Distributive();
    Addition addition = new Addition();
    Rearrange rearrange = new Rearrange();
    AddingBothSides addingBothSides = new AddingBothSides();
    Simplify simplify = new Simplify();
    Shout shout = new Shout();
    Calculations calculations = new Calculations();

    String resultBeforeAddition="";
    String resultBeforeRearrange="";
    String resultBeforeAddingBothSides="";
    String resultBeforeSimplify="";

    int counter = 0;

    // Called by the main class to perform the calculations
    public void runCalculator(String equation){

        valuesArray = equationFormatter.formatString(equation);

        if (valuesArray!=null && calculations.verifyEquation(valuesArray)){

            checkBrackets();

        } else {

            System.out.println("Invaled equation entered :(");

        }

    }

    // Determines if brackets exist, if relevant will call another class to do bracket calculations.
    public void checkBrackets(){

        if (valuesArray.contains("(")){

            counter++;

            System.out.println(counter + ". DISTRIBUTIVE:");
            shout.shoutEquation(valuesArray);

            valuesArray = distributive.workoutDistributivity(valuesArray);
            shout.shoutEquation(valuesArray);
            System.out.println();

        }

        add();


    }

    // Determines if like values on either sides of the brackets need to be added, calls relevant class if applicable.
    public void add(){

        for (int i=0; i<valuesArray.size(); i++){

            resultBeforeAddition += valuesArray.get(i);

        }

        addedArrayList = addition.addNumbers(valuesArray);

        if (addedArrayList==null){

            counter++;
            System.out.println(counter + ". ADD LIKE TERMS ON EACH SIDE");
            System.out.println("      " + resultBeforeAddition);

            shout.shoutEquation(addition.getWrongCalculatedArrayList());
            System.out.println();

            System.out.println("Error:((");

        } else {

            if (!resultBeforeAddition.equals(addition.getStringResult())){

                counter++;
                System.out.println(counter + ". ADD LIKE TERMS ON EACH SIDE");
                System.out.println("      " + resultBeforeAddition);
                shout.shoutEquation(addedArrayList);
                System.out.println();

            }
    
            rearrange();
        }

    }

    // Will call a function to rearrange each side of the equation where the x values are first and the normal values are second, 
    // if applicable.
    public void rearrange(){

        for (int i=0; i<addedArrayList.size(); i++){
            resultBeforeRearrange += addedArrayList.get(i);
        }

        addedArrayList = rearrange.rearrangeList(addedArrayList);

        if (!resultBeforeRearrange.equals(rearrange.getStringResult())){

            counter++;
            System.out.println(counter + ". Rearrange Terms");
            System.out.println("      " + resultBeforeRearrange);
            shout.shoutEquation(addedArrayList);
            System.out.println();

        }

        swap();

    }

    // Moves the x values to the LHS of the equations and normal values to the RHS, if applicable.
    public void swap(){

        if (addedArrayList.size()==3){

            if (addedArrayList.get(0).contains("x") && addedArrayList.get(2).contains("x")){

                counter++;

                System.out.println(counter + ". Move x value variables to LHS and move normal values to RHS:");
                shout.shoutEquation(addedArrayList);
                System.out.println();

                System.out.println("   ->Start with x values and simplify:");
                String opposite = calculations.convertToOpposite(addedArrayList.get(2));
                System.out.println("      " + opposite + addedArrayList.get(0) + "=" + addedArrayList.get(2) + opposite);

                addedArrayList.set(0, calculations.addTwoVariables(opposite, addedArrayList.get(0)));
                addedArrayList.set(2, "0");
                shout.shoutEquation(addedArrayList);

            } else if (addedArrayList.get(2).contains("x")){

                counter++;
                System.out.println(counter + ". Move x value variables to LHS and move normal values to RHS:");
                shout.shoutEquation(addedArrayList);
                System.out.println();

                String LHS = addedArrayList.get(0);
                String RHS = addedArrayList.get(2);

                String RHSopp = calculations.convertToOpposite(RHS);
                String LHSopp = calculations.convertToOpposite(LHS);

                System.out.println("   ->Start with x values and simplify:");
                System.out.println("      " + RHSopp + addedArrayList.get(0) + addedArrayList.get(1) + addedArrayList.get(2) + RHSopp);
                System.out.println("      " + RHSopp + addedArrayList.get(0) + "=0");
                System.out.println();

                System.out.println("   ->Do normal values and simplify:");
                System.out.println("      " + RHSopp + addedArrayList.get(0) + LHSopp + "=" + LHSopp);
                System.out.println("      " + RHSopp + "=" + LHSopp);
                System.out.println();

                addedArrayList.set(0, RHSopp);
                addedArrayList.set(2, LHSopp);

            }

        } else {

            for (int i=0; i<addedArrayList.size(); i++){

                resultBeforeAddingBothSides += addedArrayList.get(i);

            }
    
            addedArrayList = addingBothSides.addToBothSides(addedArrayList, counter);
    
            if (!resultBeforeAddingBothSides.equals(addingBothSides.getXMoved()) || !resultBeforeAddingBothSides.equals(addingBothSides.getValueMoved())){

                counter++;
                System.out.println(counter + ". Move x value variables to LHS and move normal values to RHS:");
                System.out.println("      " + resultBeforeAddingBothSides);
                System.out.println();

            }
    
            if (!resultBeforeAddingBothSides.equals(addingBothSides.getXMoved())){

                System.out.println("   ->Start with x values and simplify:");
                System.out.println("      " + addingBothSides.getXChanging());
                System.out.println("      " + addingBothSides.getXMoved());
                System.out.println();

            }
    
            if (!addingBothSides.getXMoved().equals(addingBothSides.getValueMoved())){

                System.out.println("   ->Do normal values and simplify:");
                System.out.println("      " + addingBothSides.getValueChanging());
                System.out.println("      " + addingBothSides.getValueMoved());
                System.out.println();
                
            }

        }

        if (addedArrayList!=null && calculations.checkValidEquation(addedArrayList)){

            
            System.out.println();
            simplify();

        } else {

            System.out.println();
            System.out.println("Error :(");

        }


    }

    // Calls a class to simplify the equation
    public void simplify(){

        //counter = counter + 2;
        simplify.simplify(addedArrayList, counter);
        System.out.println();
        System.out.println("Answer: " + simplify.getAnswer());
        counter = counter + 2;

    }

    public String getFinalResult(){
        return simplify.getAnswer();
    }

    public int getCounter(){return counter;}

    
}
