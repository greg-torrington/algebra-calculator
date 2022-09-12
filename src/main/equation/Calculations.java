package equation;

import java.util.*;


// This class is called by other classes to perform calculations on either certain values or array lists.
public class Calculations{

    public Calculations(){
    }

    // Converts the string value (which is a number) to its negated value.
    public String convertToOpposite(String value){

        String sign = value.substring(0, 1);

        if (sign.equals("+")){

            return "-" + value.substring(1, value.length());

        } else {

            return "+" + value.substring(1, value.length());

        }
    }

    // Adds two x valued variables.
    public String addTwoVariables(String v1, String v2) { 

        String valueOne = v1.substring(0, v1.length()-1);
        String valueTwo = v2.substring(0, v2.length()-1);

        if (isNumeric(v1)){

            valueOne = v1;

        } else if (isNumeric(v2)){

            valueTwo = v2;

        }

        int answer = Integer.parseInt(valueOne) + Integer.parseInt(valueTwo);

        if (answer==0){

            return "+0";

        } else if (answer>0){

            return "+" + answer + "x";

        } else {

            return Integer.toString(answer) + "x";

        }

    }

    // Adds two values that do not have variables.
    public String addTwoValues(String v1, String v2){

        int valueOne = Integer.parseInt(v1);
        int valueTwo = Integer.parseInt(v2);

        if (valueOne+valueTwo==0){

            return "+0";

        } else if (valueOne+valueTwo>0){

            return "+" + Integer.toString(valueOne+valueTwo);

        } else {

            return Integer.toString(valueOne+valueTwo);

        }

    }

    // Determines if the string value can be a number.
    public boolean isNumeric(String strNum) {

        if (strNum == null) {

            return false;

        }
        try {

            int d = Integer.parseInt(strNum);

        } catch (NumberFormatException nfe) {

            return false;

        }

        return true;

    }


    // Multiplies two values, can be variable values or not.
    public String multiplyValues(String one, String two){

        boolean x = false;
        String answer = "";

        int oneVal;
        int twoVal;

        if (one.contains("x")){

            x = true;
            oneVal = Integer.parseInt(one.substring(0, one.length()-1));

        } else {

            oneVal = Integer.parseInt(one);

        }

        if (two.contains("x")){

            x = true;
            twoVal = Integer.parseInt(two.substring(0, two.length()-1));

        } else {

            twoVal = Integer.parseInt(two);

        }

        int a = oneVal*twoVal;
        if (a>0){

            answer = "+" + a;

        } else{

            answer = Integer.toString(a);

        }

        if (x){

            return answer + "x";

        } else {

            return answer;

        }

    }

    // Works out the HCF of two values.
    public int workoutHCF(int a, int b){

        int hcf=0;
        for(int i = 1; i <= a || i <= b; i++) {

            if( a%i == 0 && b%i == 0 )
            hcf = i;

         }

         if (hcf!=0){

            return hcf;

         } else {

            return 1;

         }

    }

    // Checks whether an equation is still valid (if it has an x value still).
    public boolean checkValidEquation(ArrayList<String> list){

        for (int i=0; i<list.size(); i++){

            if (list.get(i).contains("x")){

                return true;

            }

        }

        return false;

    }

    // Formats the equation incase any "+" are left out.
    public ArrayList<String> formatEquation(ArrayList<String> list){

        int normalValues = 0;

        for (int i=0; i<list.size(); i++){

            if (isNumeric(list.get(i))){
                normalValues++;
            }

        }

        int cancelledNormalValue = 0;

        for (int i=0; i<list.size(); i++){

            if (list.get(i).equals("(")){

                if (i==0){

                    list.add(0, "+1");
                    
                } else if (list.get(i-1).length()==1 && !isNumeric(list.get(i-1))){

                    list.set(i-1, list.get(i-1) + "1");

                }
                
            }

            if (list.get(i).equals("")){

                list.remove(i);

            }

            if ( (list.get(i).contains("x")) && (list.get(i).length()-list.get(i).replaceAll("x","").length() == 1) ){

                String value = list.get(i).substring(0, list.get(i).length()-1);

                if (isNumeric(value)){

                    if (Integer.parseInt(value)==0){

                        list.remove(i);

                    }

                } else {

                    if (value.equals("-")){

                        list.set(i, "-1x");

                    } else {

                        list.set(i, "+1x");

                    }

                }

            }

            if (list.get(i).equals("+0x") ||  list.get(i).equals("-0x") || list.get(i).equals("0x") ){

                list.remove(i);

            }

            if (list.get(i).equals("+0")){

                if (normalValues!=cancelledNormalValue+1){

                    cancelledNormalValue++;
                    list.remove(i);

                }

            }


        }

        return list;
    }

    // Works out the simplified version of a fraction.
    public String simplifyAnser(int a, int b) {
        
        String answer = "";

        if (a>0 && b>0){

            answer = a + "/" + b;

        } else if (a<0 && b<0){

            answer = a*-1 + "/" + b*-1;

        } else if (a<0){

            answer = "-(" + a*-1 + "/" + b + ")";
 
        } else {

            answer = "-(" + a + "/" + b*-1 + ")";

        }

        return answer;
    }

    // Determines if the equation is valid.
    public boolean verifyEquation(ArrayList<String> list){

        int forwardBrackets = 0;
        int backwardBrackets = 0;

        int equals = 0;

        for (int i=0; i<list.size(); i++){

            if (list.get(i).contains("x") && i!=list.size()-1){

                if (list.get(i).length() - list.get(i).replaceAll("x","").length() > 1 ) {

                    return false;

                }
            }

            if (list.get(i).equals("+") || list.get(i).equals("-")){

                if (!list.get(i+1).equals("(")){

                    return false;

                }

            }

            if (list.get(i).equals("(")){forwardBrackets++;}
            if (list.get(i).equals(")")){backwardBrackets++;}

            if (list.get(i).equals("=")){equals++;}

        }

        if (forwardBrackets!=backwardBrackets){return false;}

        if (equals!=1){return false;}

        return true;
    }
}