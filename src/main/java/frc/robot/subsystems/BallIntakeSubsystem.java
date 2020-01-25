package frc.robot.subsystems;

import static frc.robot.OI.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntakeSubsystem extends Subsystem {

    WPI_TalonSRX ballIntake;
    public boolean btn6;
    public boolean btn4;

    public BallIntakeSubsystem() {

        ballIntake = new WPI_TalonSRX(4);

    }


    public void initDefaultCommand() {

        ballIntake.set(0); //Sets speed to 0 at start

    }

    public void rotateIntake(){

        btn4 = rightJoystick.getRawButton(4);
        btn6 = rightJoystick.getRawButton(6);

        if(btn6)
            ballIntake.set(0.2); //Set speed when button 6 is pressed

        if(btn4)
            ballIntake.set(0); //Set speed to 0 when button 4 is pressed


    }

}