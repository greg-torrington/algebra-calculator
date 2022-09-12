import java.util.*;
import equation.*;


public class Equation {

    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        String e = "";
        while (!e.equals("q")){

            System.out.print("Enter first equation ('q' to quit): ");

            e = sc.nextLine();
            System.out.println();

            if (e.equals("q")){

                break;

            } else {

                Equation equation = new Equation();
                equation.runCalculator(e);

                System.out.println();

            }

        }

        sc.close();

    }

    public void runCalculator(String e){

        EquationCalculator equationCalculator = new EquationCalculator();
        equationCalculator.runCalculator(e);

    }

}
