package org.usfirst.frc.team2791.robot.commands;

import org.usfirst.frc.team2791.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Stops the Drivetrain for a given amount of time
 */
public class DrivetrainDelay extends Command {
	
	private Timer timer = new Timer();
	private double delayTime;
	
	/**
	 * @param delayTime_ the amount of time you would like to remain stationary
	 */
    public DrivetrainDelay(double delayTime_) {
    	super("DrivetrainDelay");
    	requires(Robot.drivetrain);
    	delayTime = delayTime_;
    }

    protected void initialize() {
    	System.out.println("drive train starting to wait.");
    	timer.start();
    }

    protected void execute() {
    	Robot.drivetrain.setLeftRightMotorOutputs(0, 0);
    }

    protected boolean isFinished() {
    	return timer.hasPeriodPassed(delayTime);
    }

    protected void end() {
    	System.out.println("Drive train Delay finished.");
    }

    protected void interrupted() {
    }
}
