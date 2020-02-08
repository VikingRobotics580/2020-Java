package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem; 
import frc.robot.commands.ServoCommand;
//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;
//Allows use of the existing joystick

import edu.wpi.first.wpilibj.Servo;
//Allows use of servo methods


public class ServoSubsystem extends Subsystem {

    public Servo servo0;
    public int defaultAngle;

    public ServoSubsystem() { //Constructor, Finn's huge mistake

        servo0 = new Servo(SRV_PRT); //Sets port for servo
        defaultAngle = 0; //Default angle for use later, change to set default

    }

    public void initDefaultCommand() { //Runs on startup

        servo0.setAngle(defaultAngle); //Moves servo to default position
        setDefaultCommand(new ServoCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateArm() {

        if(rightJoystick.getRawButton(SRV_Pos)){
            if(servo0.getAngle() < defaultAngle + 90)
                servo0.setAngle(servo0.getAngle() + SRV_Spd);
        }

        if(rightJoystick.getRawButton(SRV_Neg)){
            if(servo0.getAngle() > defaultAngle + 3)
                servo0.setAngle(servo0.getAngle() - SRV_Spd);
        }

    }
}