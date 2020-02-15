package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LEDCommand extends Command {

	public LEDCommand() {
		requires(Robot.LED);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.LED.LEDs();
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