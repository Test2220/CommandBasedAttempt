package org.usfirst.frc.team2220.robot.subsystems;

import org.usfirst.frc.team2220.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;



public class DriveTrain extends Subsystem{


	public CANTalon lDriveMaster;
	public CANTalon lDriveSlave;
	public CANTalon rDriveMaster; 
	public CANTalon rDriveSlave;
	public int secondsToMove; 
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	public final static int CLOSEDLOOPERROR = 30;
	

	public static double rDriveMotorSetpoint = 0;
	public static double lDriveMotorSetpoint = 0;
	
	public AHRS navX;
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
public DriveTrain() {
	
		navX = new AHRS(SPI.Port.kMXP);
		
		lDriveMaster = new CANTalon(RobotMap.leftMaster);
		lDriveSlave = new CANTalon(RobotMap.leftSlave);
		rDriveMaster = new CANTalon(RobotMap.rightMaster);
		rDriveSlave = new CANTalon(RobotMap.rightSlave);
		
		//Set Invertions
		lDriveMaster.setInverted(false);
		lDriveSlave.setInverted(false);
		rDriveMaster.setInverted(false);
		rDriveSlave.setInverted(false);
		
		//Set Modes
		lDriveSlave.changeControlMode(TalonControlMode.Follower);
		lDriveSlave.set(lDriveMaster.getDeviceID());
		rDriveSlave.changeControlMode(TalonControlMode.Follower);
		rDriveSlave.set(rDriveMaster.getDeviceID());
		
		rDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rDriveMaster.reverseSensor(true);
		lDriveMaster.setAllowableClosedLoopErr(CLOSEDLOOPERROR);
		rDriveMaster.configEncoderCodesPerRev(256); // 4 x 256 = 1024
		

		lDriveMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		lDriveMaster.reverseSensor(false);
		lDriveMaster.configEncoderCodesPerRev(256);
		lDriveMaster.setAllowableClosedLoopErr(CLOSEDLOOPERROR);

		rDriveMaster.setEncPosition(0);
		
	}
	
	public void resetEncoderPos(){
		
		rDriveMotorSetpoint = rDriveMaster.getPosition();
		lDriveMotorSetpoint = lDriveMaster.getPosition();
		
	}
	
	public double getRPosition(){
		
		return rDriveMaster.getPosition();
		
	}
	
	public double getLPosition(){
		
		return lDriveMaster.getPosition();
		
	}
	
	public void setLeft(double value) {
		
		lDriveMaster.set(value);
		
	}
	
	public void setRight(double value) {
		
		rDriveMaster.set(value);
		
	}
	public void driveForward(double value) {
		
		lDriveMaster.set(value);
		rDriveMaster.set(value);
		
	}
	
	public void turnRight(double value) {
		
		lDriveMaster.set(-value);
		rDriveMaster.set(value);
		
	}
	
	public  void stopAll() {
		
		lDriveMaster.set(0);
		rDriveMaster.set(0);
		
	}
	
	public void controllerTank(double rVal, double lVal)
	{
		rDriveMaster.set(rVal);
		lDriveMaster.set(lVal);
	}
	
	

}
