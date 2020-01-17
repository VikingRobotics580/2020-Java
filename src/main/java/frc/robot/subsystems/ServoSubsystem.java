package frc.robot.subsystems;


import static frc.robot.OI.*;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends Subsystem {

    public Servo servo0;
    public boolean btn3;
    public boolean btn5;

    public ServoSubsystem() {
        servo0 = new Servo(0);
    }


    public void initDefaultCommand() {
        servo0.setAngle(45);
    }

    public void rotateArm(){

        btn3 = rightJoystick.getRawButton(3);
        btn5 = rightJoystick.getRawButton(5);

        if(btn5){
            System.out.println("bitch");
            // if(servo0.getAngle() > 0 || servo0.getAngle() < 180)
                servo0.setAngle(servo0.getAngle() + 5);
        }

        if(btn3){
            // if(servo0.getAngle() > 0 || servo0.getAngle() < 180)
                servo0.setAngle(servo0.getAngle() - 5);
        }

    }
}