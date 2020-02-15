package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem; 
import frc.robot.commands.LEDCommand;

//Imports data from other classes, variant is REQUIRED for subsystems

import static frc.robot.RobotMap.*;

public class LEDSubsystem extends Subsystem {

    public LEDSubsystem() { //Constructor

    }

    public void initDefaultCommand() { //Runs on startup

        setDefaultCommand(new LEDCommand()); //Variant is REQUIRED for subsystems

    }

    public void LEDs(){

        

    }

}