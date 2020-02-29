package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import static frc.robot.OI.*;

public class ArduinoCommand extends Command {

	public ArduinoCommand() {
		requires(Robot.LED);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
        Robot.LED.write();
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