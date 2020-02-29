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

    WPI_TalonSRX ballIntake_0;
    WPI_TalonSRX ballIntake_1;
    boolean active;

    public BallIntakeSubsystem() { //Constructor

        ballIntake_0 = new WPI_TalonSRX(7); //Identifies port of talon/motor
        ballIntake_1 = new WPI_TalonSRX(8); //Identifies port of talon/motor
        active = false;

    }

    public void initDefaultCommand() { //Runs on startup

        ballIntake_0.set(0); //Sets speed to 0 at start
        ballIntake_1.set(0); //Sets speed to 0 at start
        setDefaultCommand(new BallIntakeCommand()); //Variant is REQUIRED for subsystems

    }

    public void rotateIntake(){ //Runs intermitantly after start

        if(controller.getRawButton(3)){

                ballIntake_0.set(+1); //Set speed when cross is toggled and is inactive
                ballIntake_1.set(-1); //Set speed when cross is toggled and is inactive
        }
        else { //Toggles off with cross when active
                ballIntake_0.set(0);
                ballIntake_1.set(0);
                active = false;
        }

    }

}