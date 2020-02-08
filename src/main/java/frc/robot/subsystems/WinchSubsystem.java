package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.WinchCommand;
//Allows access to necessary classes

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;
//Allows access to established joystick

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//Allows use of talon/motor methods


public class WinchSubsystem extends Subsystem {

    WPI_TalonSRX winchLeft;
    WPI_TalonSRX winchRight;

    public WinchSubsystem() { //Constructor
 
        winchLeft = new WPI_TalonSRX(TLN_WNC_0); //Defines which port the talons connect to
        winchRight = new WPI_TalonSRX(TLN_WNC_1);

    }

    public void initDefaultCommand() { //Runs on startup

        winchLeft.set(0); //Stops motors by default (Precautionary)
        winchRight.set(0);
        setDefaultCommand(new WinchCommand()); //Variant REQUIRED for subsystems

    }

    public void rotateWinch() {

        if(leftJoystick.getRawButton(WNC_Pul)){ //Roate one way with button 7
            winchLeft.set(WNC_Spd);
            winchRight.set(WNC_Spd);
        } else if(leftJoystick.getRawButton(WNC_Stp)){ //And the other with 8
            winchLeft.set(-WNC_Spd);
            winchRight.set(-WNC_Spd);
        } else { //And stop with no buttons
            winchLeft.set(0);
            winchRight.set(0);
        }

    }
}