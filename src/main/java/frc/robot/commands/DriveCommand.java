package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import static frc.robot.RobotMap.*;
import static frc.robot.OI.*;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		//if (controller.getRawButtonPressed(3)) {
		//	Robot.drive.autonomous();
		//} else {
			Robot.drive.Driver();
		//}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override

	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}