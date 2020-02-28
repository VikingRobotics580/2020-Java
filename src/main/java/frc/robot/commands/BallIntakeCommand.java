package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallIntakeCommand extends Command {

	public BallIntakeCommand() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.intake.rotateIntake();
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