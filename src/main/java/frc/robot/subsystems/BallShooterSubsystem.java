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

    public BallShooterSubsystem() { //Constructor

        ballShooter0 = new WPI_TalonSRX(TLN_BS_0); //Identifies port of talon/motor
        ballShooter1 = new WPI_TalonSRX(TLN_BS_0); //Identifies port of talon/motor

    }

    public void initDefaultCommand() { //Runs on startup

        ballShooter0.set(0); //Sets speed to 0 at start
        ballShooter1.set(0); //Sets speed to 0 at start
        setDefaultCommand(new BallShooterCommand()); //Variant is REQUIRED for subsystems

    }

    public void shootBalls(){ //Runs intermitantly after start

        if(leftJoystick.getRawButton(BS_Shot)){

            ballShooter0.set(BS_Spd); //Moves when button is pushed
            ballShooter1.set(BS_Spd);

        } else {

            ballShooter0.set(0); //Sets speed to 0 if no button is pressed.
            ballShooter1.set(0);

        }

    }

}