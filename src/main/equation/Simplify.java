package equation;

import java.util.ArrayList;

// Peforms the calculation of cross cancelling and simplifying fractions.
public class Simplify {
    Calculations calculations;
    Shout shout;
    String answer = ""; 

    public Simplify(){

        calculations = new Calculations();
        shout = new Shout();
        
    }

    // Calculation performed here.
    public void simplify(ArrayList<String> addedArrayList, int counter){

        ArrayList<String> prev = new ArrayList<>();
        for (int i=0; i<addedArrayList.size(); i++){
            prev.add(addedArrayList.get(i));
        }

        int position = addedArrayList.indexOf("=");
        String value = addedArrayList.get(position-1).substring(0, addedArrayList.get(position-1).length()-1);
        addedArrayList.add(position, "/"+value);
        addedArrayList.add("/"+value);

        counter++;
        System.out.println(counter + ". DIVIDE BOTH SIDES BY THE SAME FACTOR:");
        shout.shoutEquation(addedArrayList);
        System.out.println();

        counter++;
        System.out.println(counter + ". SIMPLIFY (cancel the terms that are both in the numerator and denominator):");

        addedArrayList.remove(0);
        addedArrayList.remove(0);
        addedArrayList.add(0, "x");

        shout.shoutEquation(addedArrayList);

        int numerator = Integer.parseInt(addedArrayList.get(2));
        int denominator = Integer.parseInt(addedArrayList.get(3).substring(1, addedArrayList.get(3).length()));
        int hcf = calculations.workoutHCF(numerator, denominator);
        
        if (numerator==0){

            System.out.println("      x=0");
            answer = "x=0";

        } else if (denominator==0){

            System.out.println("ERORRR :((, the denominator cannot be 0.");

        } else {

            if (hcf!=0){

                int n = numerator / hcf;
                int d = denominator / hcf;
                System.out.println("      x=" + calculations.simplifyAnser(n, d));
                answer = "x=" + calculations.simplifyAnser(n, d);

                if (n%d==0){

                    System.out.println("      x=" + Integer.toString(n/d));
                    answer = "x=" + Integer.toString(n/d);

                } else if (d%n==0 && n!=1){

                    System.out.println("      x=1/" + Integer.toString(d/n));
                    answer = "x=1/" + Integer.toString(d/n);

                }
                
            }

        }



    }

    public String getAnswer(){return answer;}
    
}
