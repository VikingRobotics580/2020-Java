/*
Hello, world! This is Finn Cawley, co-captain of the Programming Team (as of 2020). My goal her is to give a basic explaination as to
how some aspects of how Java and WPILib work. Java is obviously the programming language we're using, and all java files have the .java
file extension, like this one. WPILib is the software used by FRC to help us communicate with our robot.

First things first, comments. Comments are used to leave messages for other programmers without affecting the program.
Comments are designated in two ways. Using a slash asterisk to open, and asterisk slash to close can make a large amount of text into a
comment (Like this paragraph). Or, using two consecutive forward slashes can designate the rest of a line as a comment.
Make sure to leave comments for other programmers, so they can understand what your code does.

Really quickly, I should explain semicolons and curly braces. (With exceptions) all lines will end with a curly brace or a semicolon.
If it's a statement like a variable declaration, importing or calling a method, it'll end with a semicolon. If it's a sort of container,
like an if statement, class header or method header, it will be followed with an open curly brace. The contents of the 'container' will
follow, then a close curly brace. If only one line of code follows a container, these curly braces are unnecessary, and the container
will run the first line of code to follow it.

With that out of the way, let's import some objects.
*/

package frc.robot; //A variant of this package is necessary for every class in this project
import static frc.robot.RobotMap.*; //Lets this class communicate with the "RobotMap" class, we'll get into that later
import static frc.robot.OI.*; //Lets this class communicate with the "OI" class, used for the joystick

/*
Importing is very important , as it allows a class to access methods and variables that aren't available in a class by default.
Methods are a sort of command meant to complete a specific task when given an input.
*/

public class Tutorial { //This is a class header, every class has one with its own name in place of "Tutorial"

    public void tutorial() { /*This is a method header, which can be accessed from other classes. We won't be calling this method in
        another class, but some stuff won't work for demonstration purposes if it's not in a method. 
        */

        /*
        Besides imports, practically everything takes place within the public class header

        Next, let's talk about variables, of which there are five main types.
        The first word is the data type, the second word is the name of the variable, and the number is the value assigned to it.
        */

        int integer = 0; //An integer, or whole number. Very useful for degrees, ports and button inputs.
        double decimals = 0.0; //Like an integer, but allows decimal places. Often used for speeds.
        char letter = 'A'; //A single character, can be a letter, number, symbol... we pretty much never use these.
        boolean binary = true; //A simple true or false. Used for recording statuses and if statements, very useful.
        String word = "Hello, world!"; //A full word or statement. VERY useful, but not too much for robotics.

        /*
        Now that we've got some variables, let's use them in an "if statement". If statements will check for a boolean value, then run the 
        code that follows.
        */

        if(binary){ //This is an if statement, since "binary" is already a boolean value itself, so it doesn't need anything else to test
            System.out.println("binary is true!"); //This is a print statement, it prints the quoted line in the terminal
        } else { //If the previous if statement isn't true, the else statement runs
            System.out.println("binary is false."); //This will run from the else statement
        }

        //We can use the other variables in conjunction with operators to create boolean values.

        if(integer == 1){ //Using "==" we can test if integer is equal to 1. The second value must match the variable's data type
            System.out.println("Integer equals 1!");
        } else if(integer != 2){ //Else if tests after if, if the if statement is true, it won't run. != means "not equal".
            System.out.println("Integer doesn't equal 2.");
        } else { //If it's not one, and it's not not 2, it must be 2.
            System.out.println("Integer equals 2."); //It's 2 by process of elimination
        }

        if(rightJoystick.getRawButton(TUT)) //This is an example of a single line following an if statement not requiring curly braces
            System.out.println("Button -1 is pushed!?");
        /*rightJoystick was imported from OI.java, so it can be used despite not being declared in this class. getRawButton is a method
        usable by a joystick that detects a boolean value from a specific button, specified by the variable in parenthesis, in this
        case it's TUT. TUT is a variable imported from RobotMap, and is set to -1 (to not conflict with actual robot code).
        */

    }

}

/* Before we move on to other classes, let's talk about common conventions in writing java files. These are VERY important, and while
breaking these rules won't crash your program, I will personally beat the crap out of you if you disobey them.

First, anything inside of curly braces will be tabbed over once, if it's inside a curly brace in a curly brace, it'll be tabbed over
twice, so on and so forth. VSCode does this automatically for the most part, but rewriting some parts my misplace some code. Makes sure
you're keeping your code on the correct line. See the code above for reference.

Second, leave a blank line in between seperate headings or statements. It's a little hard to explain when to place a space and when not
to, but the goal is to make it as easy to read as possible. Keep an eye on the spacing in this class and the others in the project to
get a feel for how it should be spaced.

Lastly, leave comments wherever you feel they may be useful. If something you've writted isn't self explanitory, make sure to leave a
comment explaining it. You're not the only one working here (hopefully), and your teammates need to know what you're doing.


Moving on, let's run through what some of the other classes do.

Main.java: The first class that runs, everything stems from it. DO NOT MESS WITH IT, IT DOESN'T NEED TO CHANGE

OI.java: Creates the joystick object. It's imported pretty much everywhere, that was every class can potentially use it.

Robot.java: Another important class, don't need to change much. If you're creating a new subsystem, you need to create a new object
below the class header. You can look at the others already written there to base it off of.

RobotMap.java: My baby boy. It stores values for ports, button inputs, etc. That way, if we change a port, we change it once in one
place, rather than in five different places across multiple classes. Like OI, it's also imported virtually everywhere.


All the classes in the commands and subsystems folders complete a specific task. I've created a tutorial command and subsystem class to
look at next, so go ahead and head to the TutorialCommand.java file first, and read from the top.
*/