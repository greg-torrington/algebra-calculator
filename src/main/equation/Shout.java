package equation;

import java.util.ArrayList;

// Outputs the equation which is stored in an array list.
public class Shout {
    
    public void shoutEquation(ArrayList<String> list){


        System.out.print("      ");
        for (int i=0; i<list.size(); i++){

            System.out.print(list.get(i));

        }
        
        System.out.println();

    }
    
}
