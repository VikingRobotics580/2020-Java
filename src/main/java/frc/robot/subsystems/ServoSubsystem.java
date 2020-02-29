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

    public Servo servo_0;
    public Servo servo_1;
    public double defaultAngle;

    public ServoSubsystem() {

        servo_0 = new Servo(SRV_PRT_0); //Sets port for servo
        servo_1 = new Servo(SRV_PRT_1); //Sets port for servo
        defaultAngle = servo_0.getAngle();// angle for use later, change to set default

    }

    public void initDefaultCommand() { //Runs on startup

        //servo_0.setAngle(defaultAngle); //Moves servo to default position
        //servo_1.setAngle(360-servo_0.getAngle()); //Moves servo to default position
        setDefaultCommand(new ServoCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateArm() {

        if(controller.getRawButton(5)){
            //if(servo_0.getAngle() < defaultAngle + 90) {
                servo_0.setAngle(servo_0.getAngle() + 20);
                servo_1.setAngle(servo_1.getAngle() - 20);
            //}
        }

        if(controller.getRawButton(6)){
            //if(servo_0.getAngle() > defaultAngle - 3) {
                servo_0.setAngle(servo_0.getAngle() - 20);
                servo_1.setAngle(servo_1.getAngle() + 20);
            //}
        }

    }
}