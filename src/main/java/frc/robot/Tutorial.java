/*
Hello, world! This is Finn Cawley, co-captain of the Programming Team (as of 2020). My goal her is to give a basic explaination as to
how some aspects of how Java and WPILib work. Java is obviously the programming language we're using, and all java files have the .java
file extension, like this one. WPILib is the software used by FRC to help us communicate with our robot.

First things first, comments. Comments are used to leave messages for other programmers without affecting the program.
Comments are designated in two ways. Using a slash asterisk to open, and asterisk slash to close can make a large amount of text into a
comment (Like this paragraph). Or, using two consecutive forward slashes can designate the rest of a line as a comment.
Make sure to leave comments for other programmers, so they can understand what your code does.

With that out of the way, let's import some objects.
*/

package frc.robot; //A variant of this package is necessary for every class in this project
import static frc.robot.RobotMap.*; //Lets this class communicate with the "RobotMap" class, we'll get into that later
import static frc.robot.OI.*; //Lets this class communicate with the "OI" class, used for the joystick

/*
Importing is very important , as it allows a class to access methods and variables that aren't available in a class by default.
Methods are a sort of command meant to complete a specific task when given an input.
*/

public class Tutorial { //Curly braces act as a sort of container, similar to the slash asterisk for comments

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


*/