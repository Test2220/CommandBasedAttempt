package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.OI;
import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimberTurn extends Command{

	public ClimberTurn() {
		
		requires(Robot.climber);
		
	}
	
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		if (Robot.oi.getClimberStick().getRawAxis(1) > 0) {
			
			Robot.climber.climberMaster.set(0);
			Robot.climber.climberSlave.set(0);
			
			
		} else {
			
		
		Robot.climber.climberMaster.set(Robot.oi.deadzone(Robot.oi.getClimberStick().getRawAxis(1), 0.1));
		Robot.climber.climberSlave.set(Robot.oi.deadzone(Robot.oi.getClimberStick().getRawAxis(1), 0.1));
		
		}
		
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
