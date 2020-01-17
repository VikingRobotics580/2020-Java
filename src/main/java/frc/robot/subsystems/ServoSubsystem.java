package frc.robot.subsystems;


import static frc.robot.OI.*;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends Subsystem {

    public Servo servo0;

    public ServoSubsystem() {
        servo0 = new Servo(0);
    }


    public void initDefaultCommand() {
        servo0.setAngle(90);
    }

    public void rotateArm(){

        if(rightJoystick.getRawButton(5) == true){
            if(servo0.getAngle() > 0 || servo0.getAngle() < 180)
                servo0.setAngle(servo0.getAngle() + 5);
        }

        if(rightJoystick.getRawButton(3) == true){
            if(servo0.getAngle() > 0 || servo0.getAngle() < 180)
                servo0.setAngle(servo0.getAngle() - 5);
        }

    }
}