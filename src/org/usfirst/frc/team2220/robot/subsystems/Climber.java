package org.usfirst.frc.team2220.robot.subsystems;

import org.usfirst.frc.team2220.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{

	public CANTalon climberMaster;
	public CANTalon climberSlave;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public Climber() {
		
		climberMaster = new CANTalon(RobotMap.climber);
		climberMaster.setInverted(false);
		
		climberSlave = new CANTalon(RobotMap.climber2);
		climberMaster.setInverted(false);

	}
	

}
