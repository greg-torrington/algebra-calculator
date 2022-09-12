package equation;

import java.util.ArrayList;

// Performs the calculation of bracket multiplication.
public class Distributive {
    Calculations calculations;
    Shout shout;
    String result="";
    ArrayList<String> arrayList;

    public Distributive(){
        calculations = new Calculations();
        shout = new Shout();
    }

    // Where the calculation occurrs.
    public ArrayList<String> workoutDistributivity(ArrayList<String> valuesArray){

        ArrayList<String> prev = new ArrayList<>();
        for (int i=0; i<valuesArray.size(); i++){
            prev.add(valuesArray.get(i));
        }

        boolean times = false;
        String timesValue = "";
        for (int i=0; i<valuesArray.size(); i++){

            if (valuesArray.get(i).equals("x")){

                valuesArray.set(i, "+1x");

            } else if (valuesArray.get(i).equals("+x")){

                valuesArray.set(i, "+1x");

            } else if(valuesArray.get(i).equals("-x")){

                valuesArray.set(i, "-1x");

            }

            if (valuesArray.get(i).equals("(")){

                times = true;
                timesValue = valuesArray.get(i-1);
                continue;

            } else if (valuesArray.get(i).equals(")")){

                times = false;

            }       

            if (times){

                String answer = calculations.multiplyValues(timesValue, valuesArray.get(i));
                valuesArray.set(i, answer);

            }

        }

        for (int i=0; i<valuesArray.size(); i++){

            if (valuesArray.get(i).equals("(")){

                valuesArray.remove(i);
                valuesArray.remove(i-1);

            } else if (valuesArray.get(i).equals(")")){

                valuesArray.remove(i);

            }

        }

        arrayList = valuesArray;
        return valuesArray;

    }   

    public String getStringResult(){
        
        for (int i=0; i<arrayList.size(); i++){

            result += arrayList.get(i);
            
        }
        return result;

    }
    
}
