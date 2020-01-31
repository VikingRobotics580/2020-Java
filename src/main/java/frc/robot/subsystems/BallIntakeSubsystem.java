package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallIntakeCommand;
//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.RobotMap.*;
//Allows use of the existing joystick

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//Imports methods for talon use

public class BallIntakeSubsystem extends Subsystem {

    WPI_TalonSRX ballIntakeBack;
    WPI_TalonSRX ballIntakeFront;

    public BallIntakeSubsystem() { //Constructor

        ballIntakeBack = new WPI_TalonSRX(TLN_BIT_BAK); //Identifies port of talon/motor
        ballIntakeFront = new WPI_TalonSRX(TLN_BIT_FRT); //Identifies port of talon/motor


    }


    public void initDefaultCommand() { //Runs on startup

        ballIntakeBack.set(0); //Sets speed to 0 at start
        ballIntakeFront.set(0); //Sets speed to 0 at start
        setDefaultCommand(new BallIntakeCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateIntake(){ //Runs intermitantly after start

        if(BIT_Pul)
            ballIntakeBack.set(BIT_Spd); //Set speed when button 6 is pressed
            ballIntakeFront.set(BIT_Spd);

        if(BIT_Stp)
            ballIntakeBack.set(0); //Set speed to 0 when button 4 is pressed
            ballIntakeFront.set(0); //Set speed to 0 when button 4 is pressed


    }

}