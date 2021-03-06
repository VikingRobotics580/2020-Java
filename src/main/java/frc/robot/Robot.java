/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.first.cameraserver.CameraServer;

//import io.github.oblarg.oblog;

import edu.wpi.first.wpilibj.TimedRobot;
//import com.ctre.phoenix.motorcontrol.ControlMode;



import static frc.robot.OI.*;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  
  public static final DriveSubsystem drive = new DriveSubsystem();
  //public static final BallIntakeSubsystem intake = new BallIntakeSubsystem();
  //public static final BallShooterSubsystem shooter = new BallShooterSubsystem();
  //public static final WinchSubsystem winch = new WinchSubsystem();
  public static final ArduinoSubsystem LED = new ArduinoSubsystem();
  //public static final ServoSubsystem servo = new ServoSubsystem();
  public static final LimelightSubsystem limelight = new LimelightSubsystem();
  public static final TutorialSubsystem tutorial = new TutorialSubsystem();

  @Override
  public void robotInit() {
    //Logger.configureLoggingAndConfig(this, false);
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
    camera.setResolution(320, 240);
    camera.setFPS(20);
  }

  public void periodic() {
    Scheduler.getInstance().run();
    if (controller.getRawButtonPressed(14)) {
      if (limelight.getLightState() == 1) {
        limelight.turnOnLight();
      }
      if (limelight.getLightState() == 3) {
        limelight.turnOffLight();
      }
    }
    drive.update_ultrasonic();
  }

  @Override
  public void autonomousInit() {
    drive.setAuto(true);
  }

  @Override
  public void autonomousPeriodic() {
    drive.autonomous();
  }

  @Override
  public void teleopInit() {
    drive.setAuto(false);
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
