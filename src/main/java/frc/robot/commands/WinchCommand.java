package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WinchCommand extends Command {

	public WinchCommand() {
		//requires(Robot.winch);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		//Robot.winch.rotateWinch();
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