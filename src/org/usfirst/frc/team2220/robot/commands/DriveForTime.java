package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForTime extends Command{

	
	public DriveForTime() { 
		
		requires(Robot.driveTrain);
		
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.driveTrain.lDriveMaster.set(0.5);
		Robot.driveTrain.rDriveMaster.set(-0.5);
		Timer.delay(2);
		Robot.driveTrain.stopAll();
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
	
}
