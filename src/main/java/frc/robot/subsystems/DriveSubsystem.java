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

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.LinearFilter;

import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
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

    double kHoldDistance = 12.0;
    double kValueToInches = 0.125;

    final double kP = 0.05;

    final int kUltrasonicPort = 0;

    AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);

    DifferentialDrive _diffDrive;

    Faults _lFaults;
    Faults _rFaults;

    ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    private boolean m_LimelightHasValidTarget = false;
    private double m_LimelightDriveCommand = 0.0;
    private double m_LimelightSteerCommand = 0.0;

    private boolean autonomous;

    private boolean firstAuto = true;

    // This instantiates, or sets up all of the variables. For example, it sets the right front wheel to the 2nd talon.
    public DriveSubsystem() {

        _rFront = new WPI_TalonSRX(1);
        _rBack = new WPI_TalonSRX(2);
        _lFront = new WPI_TalonSRX(3);
        _lBack = new WPI_TalonSRX(4);

        _diffDrive = new DifferentialDrive(_rFront, _lFront);
        _lFaults = new Faults();
        _rFaults = new Faults();

        SmartDashboard.putData(_diffDrive);

        SmartDashboard.putData(gyro);

    }

    // This is the driver method, that is run constantly in the DriveCommand. This is what takes raw data from the joysticks and pushes power to the motors.
    public void Driver() {

        SmartDashboard.putNumber("Left Joystick",controller.getRawAxis(1));
        SmartDashboard.putNumber("Right Joystick",controller.getRawAxis(5));

        String work = "";

        // Constantly update the forw and turn variables with joystick data:

        double left = -1 * controller.getRawAxis(1); /* pos = forward */
        double right = -1 * controller.getRawAxis(5); /* pos = right */
        //boolean btn1 = controller.getRawButton(1); /* if button is down, print joystick values */

        // Margin of error for joystick sensitivity = 10%
        if (Math.abs(left) < 0.05) {
            right = 0;
        }
        if (Math.abs(right) < 0.05) {
            right = 0;
        }

        // DRIVE THE ROBOT:
        _diffDrive.tankDrive(left, right);

        // Data printed to make sure joystick forward is positive and joystick turn is positive for right
        //work += " JF:" + forw + " JT:" + turn;

        // Get sensor values:
        double leftVelUnitsPer100ms = _lFront.getSelectedSensorVelocity(0);
        double rghtVelUnitsPer100ms = _rFront.getSelectedSensorVelocity(0);
        // double leftPos = _leftFront.GetSelectedSensorPosition(0);
        // double rghtPos = _rghtFront.GetSelectedSensorPosition(0);

        //work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

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
        //if (btn1) {
        //    System.out.println(work);
        //}
    }

    public void setAuto(boolean t) {
        autonomous = t;
    }

    public void autonomous(){

        _diffDrive.tankDrive(3, 0); //Begin driving forwards
        Timer.delay(3); //Wait three seconds
        _diffDrive.tankDrive(0, 0); //Stop driving

        /*if (update_ultrasonic() > 35 && autonomous) { //test ultrasonic alone
            if (gyro.getAngle() > 2) {
                _diffDrive.tankDrive(-0.3, 0.3); //test gyro angles alone
            } else if (gyro.getAngle() < -2) {
                _diffDrive.tankDrive(0.3, -0.3);
            }
            Robot.limelight.turnOffLight();
            _diffDrive.tankDrive(0.5, 0.5);
        } else if (autonomous) {                  
            Robot.limelight.turnOnLight();
            update_limelight_tracking();
            _diffDrive.tankDrive(0.3, 0.3); //Drive forward at speed 5 and 0 rotation
            Timer.delay(2.0); //Continue for 2 seconds
            _diffDrive.tankDrive(0, 0); //Stop driving
    
            if (Robot.limelight.getTV() != 1) { //Check to see if target is detected
                autonomousSeeking();
            }

            //if (m_LimelightHasValidTarget) {
            //    _diffDrive.tankDrive(m_LimelightDriveCommand, m_LimelightSteerCommand);
            //} else {
            //    _diffDrive.tankDrive(0.0, 0.0);
            //}
            
            //if (Robot.limelight.tx() < 1 && Robot.limelight.tx() > -1) {
                //Robot.shooter.shootBalls();
            }*/
        
    }

    public double update_ultrasonic() {
        double currentDistance = m_ultrasonic.getValue() * kValueToInches;
        SmartDashboard.putNumber("Ultrasonic", currentDistance);
        //convert distance error to a motor speed
        double currentSpeed = (kHoldDistance - currentDistance) * kP;
        SmartDashboard.putNumber("Current Speed", currentSpeed);
        //_diffDrive.arcadeDrive(currentSpeed, 0);
        return currentDistance;
    }

    public void update_limelight_tracking() {
        final double STEER_K = 0.03;
        final double DRIVE_K = 0.26;
        final double DESIRED_TARGET_AREA = 13.0;
        final double MAX_DRIVE = 0.7;

        if (Robot.limelight.getTV() < 1.0) {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0.0;
            m_LimelightSteerCommand = 0.0;
            return;
        }

        m_LimelightHasValidTarget = true;

        double steer_cmd = Robot.limelight.tx() * STEER_K;
        m_LimelightSteerCommand = steer_cmd;

        double drive_cmd = (DESIRED_TARGET_AREA - Robot.limelight.getTA() * DRIVE_K);

        if (drive_cmd > MAX_DRIVE) {
            drive_cmd = MAX_DRIVE;
        }

        m_LimelightDriveCommand = drive_cmd;
    }

    public void autonomousSeeking() { //Attempts to find target by driving and rotating
        if (!controller.getRawButtonPressed(EMG_Stp)) { //Checks autonomous kill button
            _diffDrive.arcadeDrive(0.1, 0.1);
        }
    }

    public void ranging() { //Attempts to rotate to find target
        if (Robot.limelight.calcXDist() > 125) {
            _diffDrive.arcadeDrive(0, -0.1);
        }
        if (Robot.limelight.calcXDist() < 115) {
            _diffDrive.arcadeDrive(0, 0.1);
        }
    }

    public void goto180() { //Rotates to 180 degrees
        if (gyro.isConnected()) {
            while ((!(gyro.getAngle() > 179 && gyro.getAngle() < 181)) && !controller.getRawButtonPressed(2)) {
                _diffDrive.arcadeDrive(0, -0.1);
            }
        } else {
            System.out.println("Gyro not connected!");
        }
    }

    public void goto90() { //Rotates to 90 degrees
        if (gyro.isConnected()) {
            while ((!(gyro.getAngle() > 89 && gyro.getAngle() < 91)) && !controller.getRawButtonPressed(2)) {
                _diffDrive.arcadeDrive(0, 0.1);
            }
        }
    }
    
    public void goto270() { //Rotates to 270 degrees
        if (gyro.isConnected()) {
            while ((!(gyro.getAngle() > 269 && gyro.getAngle() < 271)) && !controller.getRawButtonPressed(2)) {
                _diffDrive.arcadeDrive(0, -0.1);
            }
        }
    }

    public void resetGyro() { //Sets gyro to 0 
        gyro.reset();
    }

    // This initializes everything in the subsystem, sets everything to "default":
    public void initDefaultCommand() {

        _rFront.setExpiration(0.1);
        _rBack.setExpiration(0.1);
        _lFront.setExpiration(0.1);
        _lBack.setExpiration(0.1);

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