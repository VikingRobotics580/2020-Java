package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallIntakeCommand;
//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;
//Allows use of the existing joystick

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//Imports methods for talon use

public class BallIntakeSubsystem extends Subsystem {

    WPI_TalonSRX ballIntake;

    public BallIntakeSubsystem() { //Constructor

        ballIntake = new WPI_TalonSRX(0); //Identifies port of talon/motor

    }

    public void initDefaultCommand() { //Runs on startup

        ballIntake.set(0); //Sets speed to 0 at start
        setDefaultCommand(new BallIntakeCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateIntake(){ //Runs intermitantly after start

        if(rightJoystick.getRawButton(6)){
            ballIntake.set(BIT_Spd); //Set speed when button 6 is pressed
        }


        if(rightJoystick.getRawButton(4))
            ballIntake.set(0); //Set speed to 0 when button 4 is pressed

    }

}