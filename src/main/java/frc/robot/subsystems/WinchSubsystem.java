package frc.robot.subsystems;

import static frc.robot.OI.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

    WPI_TalonSRX winchLeft;
    WPI_TalonSRX winchRight;
    public boolean btn7;
    public boolean btn8;

    public WinchSubsystem() {
 
        winchLeft = new WPI_TalonSRX(5);
        winchRight = new WPI_TalonSRX(6);

    }


    public void initDefaultCommand() {

        winchLeft.set(0);
        winchRight.set(0);

    }

    public void rotateWinch() {

        btn7 = rightJoystick.getRawButton(7);
        btn8 = rightJoystick.getRawButton(8);

        if(btn7){
            winchLeft.set(0.2);
            winchRight.set(-0.2);
        } else if(btn8){
            winchLeft.set(-0.2);
            winchRight.set(0.2);
        } else {
            winchLeft.set(0);
            winchRight.set(0);
        }

    }
}