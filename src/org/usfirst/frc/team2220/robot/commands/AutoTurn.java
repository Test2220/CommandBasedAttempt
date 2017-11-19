package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurn extends Command{
	
	   private double degrees = 30;
	    private double heading;
	    private double initialHeading;
	    private int turnDirectionCoeff;
	    private final double turnSpeed = 0.5;
	    private double goal;

	    public void AutoTurn() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		initialHeading = Robot.driveTrain.navX.getAngle();
		// This coefficient should be positive when turning right
		this.turnDirectionCoeff = (int) (degrees / (Math.abs(degrees)));
	
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
		Robot.driveTrain.stopAll();
		
		goal = (initialHeading + degrees) % 360;
		turnDirectionCoeff = (int) (degrees / (Math.abs(degrees)));
		
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    
		heading = Robot.driveTrain.navX.getAngle();
		Robot.driveTrain.setLeft(turnSpeed * turnDirectionCoeff);
		Robot.driveTrain.setRight(turnSpeed * turnDirectionCoeff);
		System.out.println(heading);
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
		return Math.abs(heading - goal) < 1;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
		Robot.driveTrain.stopAll();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	}

}
