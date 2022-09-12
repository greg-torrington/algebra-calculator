package equation;

import java.util.ArrayList;


// Equation is formatted into an arraylist that is more readable for the program to perform other functions
public class EquationFormatter {

    ArrayList<String> valuesArray = new ArrayList<>();
    Calculations calculations;


    public EquationFormatter(){

        calculations = new Calculations();

    }

    // Where formatting occurs
    public ArrayList<String> formatString(String e){

        e = e.replaceAll("\\s","");

        String value = "";
        for (int i=0; i<e.length(); i++){

            String letter = e.substring(i, i+1);

            if ( calculations.isNumeric(letter) || letter.equals("x") ){

                value = value + letter;

            } else if ( letter.equals("+") || letter.equals("-") ){

                valuesArray.add(value);
                value = letter;

            } else if ( letter.equals("(") || letter.equals(")") || letter.equals("=") ){

                if (!value.equals("")){valuesArray.add(value);}
                valuesArray.add(letter);
                value = "";

            } else {

                return null;

            }
            
        }

        if(!value.equals("")){valuesArray.add(value);}

        valuesArray = calculations.formatEquation(valuesArray);

        int position = valuesArray.indexOf("=");
        String number = valuesArray.get(position+1);
        String l = number.substring(0, 1);

        if (calculations.isNumeric(l)){

            number = "+" + number;
            valuesArray.set(position+1, number);

        }

        number = valuesArray.get(0);
        if (calculations.isNumeric(number.substring(0, 1))){

            valuesArray.set(0, "+" + number);

        }

        return valuesArray;
        
    }
    
}
