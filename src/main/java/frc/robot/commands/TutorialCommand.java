/* This is a command file. There's not much to customize here, it's mosty used to communicate with a corresponding subsystem file, but
it is still required. You can literally copy and paste a different command file and change a few values to make it work. I'll asume
you're doing that, so I'll outline what needs to be changed.

But first, head over to Robot.java and look at the objects declared below the class header. Each one corresponds to a pair of commands
and subsystems. If you're creating a new one, just copy another and sub out the Subsystem mentioned for the one you're using, and change
the name to something more appropriate. The name of this pair's object is 'tutorial', you'll see that referenced a few times.
*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TutorialCommand extends Command { //Change TutorialCommand to the name of the file.

	public TutorialCommand() {
		requires(Robot.tutorial); //Change tutorial to whatever you named your object in Robot.java
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
        Robot.tutorial.tutorialCode(); /*Change to tutorial to your name again, and change tutorialCode to whatever you'll name the
        method your subsystem will run. If you take a quick glance over at tutorialSubsystem you'll see the method I'm talking about.
        I'll get more into what that method is when we go over that class, just remember to change tutorialCode to whatever you end up
        naming that method.
        */
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

//Alright, that's really all there is for this class, head over to tutorialSubsystem and we'll go over that. It's more complicated...