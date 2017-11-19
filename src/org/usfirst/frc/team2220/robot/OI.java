package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.commands.ClimberTurn;
import org.usfirst.frc.team2220.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	
	Joystick driverStick = new Joystick(0);
	Joystick climberStick = new Joystick(1);
	
	
	Button tankDrive = new JoystickButton(driverStick, 5);
	Button climberButton = new JoystickButton(climberStick, 5);
	
	public Joystick getDriverStick() { 
		
		return driverStick;
		
	}
	
	public Joystick getClimberStick() {
		
		return climberStick;
		
	}
	
	public OI()	{
		
		tankDrive.whenPressed(new DriveWithJoysticks());
		climberButton.whenPressed(new ClimberTurn());
		
	}
	
	
	
	public double deadzone(double output, double threshold) {
		if (output <= threshold && output >= - threshold) {
			return 0.;
			
		}
		return output;
	}

	
	
}
