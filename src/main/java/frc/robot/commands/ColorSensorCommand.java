package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ColorSensorCommand extends Command {

	public ColorSensorCommand() {
		requires(Robot.color);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.color.senseColor();
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