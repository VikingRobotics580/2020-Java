package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallShooterCommand;
//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;
//Allows use of the existing joystick

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//Imports methods for talon use

public class BallShooterSubsystem extends Subsystem {

    WPI_TalonSRX ballShooter0;
    WPI_TalonSRX ballShooter1;
    //Instantiates ball shooters

    public BallShooterSubsystem() { //Constructor

        ballShooter0 = new WPI_TalonSRX(5); //Identifies port of talon/motor
        ballShooter1 = new WPI_TalonSRX(6); //Identifies port of talon/motor

    }

    public void initDefaultCommand() { //Runs on startup

        ballShooter0.set(0); //Sets speed to 0 at start
        ballShooter1.set(0); //Sets speed to 0 at start
        setDefaultCommand(new BallShooterCommand()); //Variant is REQUIRED for subsystems

    }

    public void shootBalls(){ //Runs intermitantly after start

        if(leftJoystick.getRawButton(7)){

            ballShooter0.set(-0.7); //Moves when button is pushed
            ballShooter1.set(-0.7);

        } else if (leftJoystick.getRawButton(8)){

            ballShooter0.set(-0.1); //Moves slower when button is pushed
            ballShooter1.set(-0.1);

        } else {

            ballShooter0.set(0); //Sets speed to 0 if no button is pressed.
            ballShooter1.set(0);

        }

    }

}