/* 
Team 580 Drive Subsystem
    - This subsystem is basically the "driving class" that constantly runs the "drive" method
    - This subsystem constantly gets input from the joysticks, and translates that to the talons (the things that sends power to the motors)
    - Managed by Bhada Yun & Finn Cawley
*/

// All the imports:
package frc.robot.subsystems;

import static frc.robot.OI.*;
import static frc.robot.RobotMap.*;

import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.shuffleboard.*;

import edu.wpi.first.wpilibj.Sendable;

// Class declaration:
public class DriveSubsystem extends Subsystem {
    // Creating variables/objects:
    WPI_TalonSRX _rFront;
    WPI_TalonSRX _rBack;
    WPI_TalonSRX _lFront;
    WPI_TalonSRX _lBack;

    DifferentialDrive _diffDrive;

    Faults _lFaults;
    Faults _rFaults;

    // This instantiates, or sets up all of the variables. For example, it sets the right front wheel to the 2nd talon.
    public DriveSubsystem() {

        _rFront = new WPI_TalonSRX(TLN_2);
        _rBack = new WPI_TalonSRX(TLN_3);
        _lFront = new WPI_TalonSRX(TLN_0);
        _lBack = new WPI_TalonSRX(TLN_1);

        _diffDrive = new DifferentialDrive(_lFront, _rFront);
        _lFaults = new Faults();
        _rFaults = new Faults();

        SmartDashboard.putData(_diffDrive);

    }

    // This is the driver method, that is run constantly in the DriveCommand. This is what takes raw data from the joysticks and pushes power to the motors.
    public void Driver() {

        SmartDashboard.putNumber("Joystick X value",leftJoystick.getX());
        SmartDashboard.putNumber("Joystick Y value",leftJoystick.getY());

        String work = "";

        // Constantly update the forw and turn variables with joystick data:

        double forw = -1 *leftJoystick.getRawAxis(1); /* pos = forward */
        double turn = +1 *leftJoystick.getRawAxis(2); /* pos = right */
        boolean btn1 =leftJoystick.getRawButton(1); /* if button is down, print joystick values */

        // Margin of error for joystick sensitivity = 10%
        if (Math.abs(forw) < 0.10) {
            forw = 0;
        }
        if (Math.abs(turn) < 0.10) {
            turn = 0;
        }

        // DRIVE THE ROBOT:
        _diffDrive.arcadeDrive(forw, turn);

        // Data printed to make sure joystick forward is positive and joystick turn is positive for right
        work += " JF:" + forw + " JT:" + turn;

        // Get sensor values:
        double leftVelUnitsPer100ms = _lFront.getSelectedSensorVelocity(0);
        double rghtVelUnitsPer100ms = _rFront.getSelectedSensorVelocity(0);
        // double leftPos = _leftFront.GetSelectedSensorPosition(0);
        // double rghtPos = _rghtFront.GetSelectedSensorPosition(0);

        work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

        // Recognize any faults in the sensor:
        _lFront.getFaults(_lFaults);
        _rFront.getFaults(_rFaults);

        if (_lFaults.SensorOutOfPhase) {
            work += " L sensor is out of phase";
        }
        if (_rFaults.SensorOutOfPhase) {
            work += " R sensor is out of phase";
        }

        // Print to drive station when button 1 is pressed:
        if (btn1) {
            System.out.println(work);
        }
    }

    public void autonomous(){

        _diffDrive.arcadeDrive(5, 0);
        Timer.delay(2.0);
        _diffDrive.arcadeDrive(0, 0);

    }

    // This initializes everything in the subsystem, sets everything to "default":
    public void initDefaultCommand() {

        // Set all the values to factory default
        _rFront.configFactoryDefault();
        _rBack.configFactoryDefault();
        _lFront.configFactoryDefault();
        _lBack.configFactoryDefault();

        // Set up the followers
        _rBack.follow(_rFront);
        _lBack.follow(_lFront);

        // Flip values so robot moves forward when LEDs are green
        _rFront.setInverted(true); // !< Update this
        _lFront.setInverted(false); // !< Update this

        // Set values that are backward, or inverted to whatever is opposite
        _rBack.setInverted(InvertType.FollowMaster);
        _lBack.setInverted(InvertType.FollowMaster);

        // Adjust sensor phase so sensor moves positive when Talon's LEDs are green
        _rFront.setSensorPhase(true);
        _lFront.setSensorPhase(true);

        // Make sure left and right are opposite.
        _diffDrive.setRightSideInverted(false);

        // Help this subsystem recognize that DriveCommand.java is its main command file
        setDefaultCommand(new DriveCommand());

    }

}