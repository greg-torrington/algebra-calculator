# Algebra calculator
This tool calculates simple algebra equations involving addition, subtraction and multiplication when brackets are included. The aim is to solve a problem such as "2x+3(x+1)=9", by working out what 'x' is.

# Run the app
    1. Clone the repo:
        git clone https://github.com/greg-torrington/simple-algebra-calculator.git
    
    2. Run the project by navigating into the 'main' folder:
        javac Equation.java
        java Equation

# Usage
Once the program is running, enter a relevant algebra equation which allows addition and subtraction as well as multiplication that is done with brackets, such as: '2(3x+1)'. What will not work is: '4x4' or '4*4'. Then press the enter button :) To exit the program, enter 'q' and press the enter button.

# Further work
    1. Improve error catching when an invalid equation is entered. Most possibilities checked but not all.
    2. Imporve algorithm efficiency (look at Gauss ELimination to solve problem, time constraints were biggest blocker).
    3. Clean up code (time contraints again).
    4. Improve coding structure.