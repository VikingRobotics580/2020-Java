package frc.robot.subsystems;


import static frc.robot.OI.*;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends Subsystem {

    public Servo servo0;
    public boolean btn3;
    public boolean btn5;
    public int defaultAngle;

    public ServoSubsystem() {
        servo0 = new Servo(0);
        defaultAngle = 145;
    }


    public void initDefaultCommand() {
        servo0.setAngle(55);
    }

    public void rotateArm(){

        btn3 = rightJoystick.getRawButton(3);
        btn5 = rightJoystick.getRawButton(5);

        if(btn5){
            if(servo0.getAngle() < defaultAngle + 90)
                servo0.setAngle(servo0.getAngle() + 5);
        }

        if(btn3){
            if(servo0.getAngle() > defaultAngle - 90)
                servo0.setAngle(servo0.getAngle() - 5);
        }

    }
}