package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command{

	
	public DriveWithJoysticks() {
		
		requires(Robot.driveTrain);
		
	}
	
	@Override
	protected void initialize() {
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.driveTrain.lDriveMaster.set(Robot.oi.deadzone(Robot.oi.getDriverStick().getRawAxis(1), 0.1));
		Robot.driveTrain.rDriveMaster.set(-Robot.oi.deadzone(Robot.oi.getDriverStick().getRawAxis(5), 0.1));
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
		Robot.driveTrain.stopAll();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
		Robot.driveTrain.stopAll();
		
	}

}
