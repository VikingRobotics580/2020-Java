/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;

//import io.github.oblarg.oblog;

import edu.wpi.first.wpilibj.TimedRobot;
//import com.ctre.phoenix.motorcontrol.ControlMode;

import static frc.robot.OI.*;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //public static final DriveSubsystem drive = new DriveSubsystem();
  //public static final BallIntakeSubsystem intake = new BallIntakeSubsystem();
  //public static final WinchSubsystem winch = new WinchSubsystem();
  //public static final LEDSubsystem LED = new LEDSubsystem();
  public static final ServoSubsystem servo = new ServoSubsystem();
  public static final LimelightSubsystem limelight = new LimelightSubsystem();

  ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  @Override
  public void robotInit() {
    SmartDashboard.putData(gyro);
    //Logger.configureLoggingAndConfig(this, false);
  }


  public void periodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    periodic();
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
