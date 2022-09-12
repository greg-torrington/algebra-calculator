package equation;

import java.util.ArrayList;

// Rearranges the values on the LHS and RHS so the x values variables come first.
public class Rearrange {
    ArrayList<String> arrayList = new ArrayList<>();
    Calculations calculations;
    Shout shout;

    public Rearrange(){

        calculations = new Calculations();
        shout = new Shout();

    }

    // Rearranging occurs here.
    public ArrayList<String> rearrangeList(ArrayList<String> addedArrayList){


        int variableValuePos = -1;
        int valuePos = -1;

        for (int i=0; i<addedArrayList.size(); i++){

            String number = addedArrayList.get(i);

            if (number.equals("=")){

                if ( (variableValuePos!=-1) && (valuePos!=-1) && (variableValuePos>valuePos) ){

                    String valueWithoutVariables = addedArrayList.get(valuePos);
                    addedArrayList.set(valuePos, addedArrayList.get(variableValuePos));
                    addedArrayList.set(variableValuePos, valueWithoutVariables);

                }

                variableValuePos = -1;
                valuePos = -1;

            } else if (number.contains("x")){

                variableValuePos = i;

            } else {

                valuePos = i;

            }

        }

        if ( (variableValuePos!=-1) && (valuePos!=-1) && (variableValuePos>valuePos) ){

            String valueWithoutVariables = addedArrayList.get(valuePos);
            addedArrayList.set(valuePos, addedArrayList.get(variableValuePos));
            addedArrayList.set(variableValuePos, valueWithoutVariables);
            
        } 

        arrayList = addedArrayList;
        return addedArrayList;

    }

    public String getStringResult(){

        String result = "";

        for (int i=0; i<arrayList.size(); i++){
            result += arrayList.get(i);
        }

        return result;
        
    }
    
}
