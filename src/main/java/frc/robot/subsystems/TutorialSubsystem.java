/* This is the tutorialSubsystem. Subsystems are where most of the unique code gets writen. Like in tutorialCommand, I'll mention what
needs to change from something like this if you want to make your own subsystem. For example purposes, this subsystem will print out
a number when an imaginary button is pushed. The number will increase when a different button is pushed, and decrease with another. */

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem; 
import frc.robot.commands.ServoCommand;
import frc.robot.commands.TutorialCommand; //Change 'TutorialCommand' to whatever the name of your command class is.

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;
//Just like in the Tutorial class, these let us use the joystick and variables from the RobotMap.

public class TutorialSubsystem extends Subsystem { //Change 'TutorialSubsystem' to the name of the class.

    int value; //This instantiates the value we'll be printing and changing.

    public TutorialSubsystem() { //Constructor, runs on startup. Use it to declare objects and variables.

        value = 0; //Sets value to 0 by default.

    }

    public void initDefaultCommand() { //Also runs on startup, use it for things other than declaring, though.

        setDefaultCommand(new TutorialCommand()); /* A variant of this 'setDefaultCommand' is REQUIRED for all subsystems. Otherwise it
        won't work, and it won't return an error so you'll be confused. Just paste this into the 'initDefaultCommand' of your new
        subsystem and change 'TutorialCommand' to the name of the corresponding command file. */

    }

    public void tutorialCode() {
        /* This method is the crux of this entire file. Assuming that the rest of the process was done correctly, this method should be
        running every few milliseconds. Whatever you want to be happening will be written in here. For this tutorial, I'll apply a lot
        of what I've mentioned in the other files. */

        if(rightJoystick.getRawButton(TUT_Val)) //Gets input from the joystick button 'TUT_Val'. If pressed, the next line runs.
            System.out.println(value); //Prints 'value' to the terminal

        if(rightJoystick.getRawButton(TUT_Neg)) //Gets input from the joystick button 'TUT_Neg'. If pressed, the next line runs.
            value += 1; //Increases the value of 'value' by one every time the method runs and the button is pushed.
        else if(rightJoystick.getRawButton(TUT_Pos)) //Gets input from the joystick button 'TUT_Neg'. If pressed, the next line runs.
            value -= 1; //Decreases the value of 'value' by one every time the method runs and the button is pushed.

    }
}

/* And like that, the tutorial's pretty much over. Hopefully I could convey at a basic level how most of the code works. There's a lot
of stuff that we don't have to know the function of, because WPILib builds it automatically, like Robot.java. Just don't mess with it
and it should work fine. If you have any questions, Google it if it's about what a method does, but if it's more general, definitely
ask a senior programmer about it (assuming you have one, Bhada and I had to learn everything from scratch). */