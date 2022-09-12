package equation;

import java.util.ArrayList;

// Performs the calculation of adding all like terms on each of the equation.
public class Addition {
    ArrayList<String> arrayList = new ArrayList<>();
    Calculations calculations;
    Shout shout;
    ArrayList<String> wrongCalcArrayList = new ArrayList<>();

    public Addition(){

        calculations = new Calculations();
        shout = new Shout();

    }

    // Calculation performed here.
    public ArrayList<String> addNumbers(ArrayList<String> valuesArray){

        ArrayList<String> addedArrayList = new ArrayList<>();

        System.out.println();

        int variableValuePosition = -1;
        int valuePosition = -1;

        for (int i=0; i<valuesArray.size(); i++){
            
            String number = valuesArray.get(i);

            if (number.equals("=")){

                variableValuePosition = -1;
                valuePosition = -1;
                addedArrayList.add(number);

            } else if (number.contains("x")){

                if (variableValuePosition==-1){

                    addedArrayList.add(number);
                    variableValuePosition = addedArrayList.size()-1;

                } else {

                    String value = calculations.addTwoVariables(addedArrayList.get(variableValuePosition), number);

                    if (value.equals("")){

                        addedArrayList.remove(variableValuePosition);
                        variableValuePosition = -1;

                    } else {

                        addedArrayList.set(variableValuePosition, value);

                    }

                }

            } else {

                if (valuePosition==-1){

                    addedArrayList.add(number);
                    valuePosition = addedArrayList.size()-1;

                } else {

                    String value = calculations.addTwoValues(addedArrayList.get(valuePosition), number);

                    if (value.equals("")){

                        addedArrayList.remove(valuePosition);
                        valuePosition = -1;

                    } else {

                        addedArrayList.set(valuePosition, value);

                    }

                }

            }

        }

        if (calculations.checkValidEquation(addedArrayList)){

            arrayList = addedArrayList;
            addedArrayList = calculations.formatEquation(addedArrayList);
            return addedArrayList;

        } else {

            wrongCalcArrayList = addedArrayList;
            return null;

        }

    }

    public String getStringResult(){

        String result = "";

        for (int i=0; i<arrayList.size(); i++){

            result += arrayList.get(i);

        }

        return result;
    }

    public ArrayList<String> getWrongCalculatedArrayList(){return wrongCalcArrayList;}
    
}
