package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ServoCommand extends Command {

	public ServoCommand() {
		requires(Robot.servo);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.servo.rotateArm();
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