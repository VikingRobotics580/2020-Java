package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimelightCommand extends Command {

	public LimelightCommand() {
		requires(Robot.limelight);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.limelight.update();
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