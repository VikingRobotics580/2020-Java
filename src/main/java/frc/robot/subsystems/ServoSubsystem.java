package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem; 
import frc.robot.commands.ServoCommand;
//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.OI.*;
//Allows use of the existing joystick

import edu.wpi.first.wpilibj.Servo;
//Allows use of servo methods


public class ServoSubsystem extends Subsystem {

    public Servo servo0;
    public boolean btn3;
    public boolean btn5;
    public int defaultAngle;

    public ServoSubsystem() { //Consatructor

        servo0 = new Servo(0); //Sets port for servo
        defaultAngle = 145; //Default angle for use later, change to set default

    }


    public void initDefaultCommand() { //Runs on startup

        servo0.setAngle(defaultAngle); //Moves servo to default position
        setDefaultCommand(new ServoCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateArm() {

        btn3 = rightJoystick.getRawButton(3); //checks if button is pressed, returns true or false
        btn5 = rightJoystick.getRawButton(5); //^

        if(btn5){
           // if(servo0.getAngle() < defaultAngle + 90)
                servo0.setAngle(servo0.getAngle() + 2);
        }

        if(btn3){
           // if(servo0.getAngle() > defaultAngle - 90)
                servo0.setAngle(servo0.getAngle() - 2);
        }

    }
}