package equation;

import java.util.ArrayList;


// Performs the calculation of moving all x variable values to the LHS of the equation and 
// moves other values to the RHS.
public class AddingBothSides {
    
    ArrayList<String> arrayList = new ArrayList<>();
    Calculations calculations;
    Shout shout;
    String xMoved = "";
    String xChanging = "";
    String valueMoved = "";
    String valueChanging = "";

    public AddingBothSides(){

        calculations = new Calculations();
        shout = new Shout();

    }

    // Where calculation occurs.
    public ArrayList<String> addToBothSides(ArrayList<String> addedArrayList, int counter){

        int position = addedArrayList.indexOf("=") + 1;
        String variableValueToMove = addedArrayList.get(position);

        if (variableValueToMove.contains("x")){

            String opposite = calculations.convertToOpposite(variableValueToMove);

            addedArrayList.add(position+1, opposite);

            if (addedArrayList.get(0).contains("x")){

                addedArrayList.add(1, opposite);

                for (int i=0; i<addedArrayList.size(); i++){

                    xChanging += addedArrayList.get(i);

                }

                addedArrayList.set(0, calculations.addTwoVariables(addedArrayList.get(0), opposite));
                addedArrayList.remove(1);
                addedArrayList.remove(position);
                addedArrayList.remove(position);

                for (int i=0; i<addedArrayList.size(); i++){

                    xMoved += addedArrayList.get(i);

                }

                if (addedArrayList.get(addedArrayList.size()-1).contains("=")){

                    addedArrayList.add("0");
                    xMoved += "0";

                }

            } else {

                addedArrayList.add(0, opposite);

                for (int i=0; i<addedArrayList.size(); i++){

                    xChanging += addedArrayList.get(i);

                }

                position = addedArrayList.indexOf("=")+1;

                addedArrayList.remove(position);
                addedArrayList.remove(position);

                for (int i=0; i<addedArrayList.size(); i++){

                    xMoved += addedArrayList.get(i);

                }

            }
            


        } else {

            for (int i=0; i<addedArrayList.size(); i++){

                xMoved += addedArrayList.get(i);

            }

        }

        position = addedArrayList.indexOf("=");

        if (!addedArrayList.get(position-1).contains("x")){

            String opposite = calculations.convertToOpposite(addedArrayList.get(position-1));
            addedArrayList.add(position-1, opposite);
            addedArrayList.add(opposite);

            for (int i=0; i<addedArrayList.size(); i++){

                valueChanging += addedArrayList.get(i);

            }

            addedArrayList.remove(position-1);
            addedArrayList.remove(position-1);

            addedArrayList.remove(addedArrayList.size()-1);

            String value = calculations.addTwoValues(addedArrayList.get(addedArrayList.size()-1), opposite); /////
            addedArrayList.set(addedArrayList.size()-1, value);

            for (int i=0; i<addedArrayList.size(); i++){

                valueMoved += addedArrayList.get(i);

            }

        } else {

            for (int i=0; i<addedArrayList.size(); i++){

                valueMoved += addedArrayList.get(i);

            }

        }

        if (calculations.checkValidEquation(addedArrayList)){

            arrayList = addedArrayList;
            return calculations.formatEquation(addedArrayList);

        } else {

            return null;

        }


    }

    public String getXMoved(){return xMoved;}

    public String getValueMoved(){return valueMoved;}

    public String getXChanging(){return xChanging;}

    public String getValueChanging(){return valueChanging;}
    
}
