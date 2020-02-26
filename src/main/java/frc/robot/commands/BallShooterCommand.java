package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BallShooterCommand extends Command {

	public BallShooterCommand() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		//Robot.shooter.shootBalls();
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