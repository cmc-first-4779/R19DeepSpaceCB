/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.autoCommands.BlastOffHighHabPlatformAutoCommand;
import frc.robot.autoCommands.BlastOffMedHabPlatformAutoCommand;
import frc.robot.autoCommands.DefenseModeAutoCommand;
import frc.robot.autoCommands.OffenseModeAutoCommand;
import frc.robot.commands.BlackHole.BlackHoleBoomCommand;
import frc.robot.commands.BlastOff.BlastOffSetHeightCommand;
import frc.robot.commands.DinoArms.DinoArmsGrabCommand;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeForwardCommand;
import frc.robot.commands.NoseCone.NoseConeOpenCommand;
import frc.robot.commands.NoseCone.NoseConeReverseCommand;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;
import frc.robot.commands.WarpDrive.DriveLimeLightCommand;

public class OI {
	// Declare the two joysticks and initate them on the two appropriate USB ports
	// recognized by the Drivers Station.
	Joystick driverStick = new Joystick(XBoxJoystickMap.DRIVERSTICK_USB_PORT);
	Joystick operStick = new Joystick(XBoxJoystickMap.OPERSTICK_USB_PORT);

	public OI() {
		//// CREATING BUTTONS
		// One type of button is a joystick button which is any button on a
		//// joystick.
		// You create one by telling it which joystick it's on and which button
		// number it is.
		// Joystick stick = new Joystick(port);
		// Button button = new JoystickButton(stick, buttonNumber);

		// Declare and Initiate all of the Buttons on the OperStick
		JoystickButton operStickYButton = new JoystickButton(operStick, XBoxJoystickMap.Y_BUTTON);
		JoystickButton operStickXButton = new JoystickButton(operStick, XBoxJoystickMap.X_BUTTON);
		JoystickButton operStickAButton = new JoystickButton(operStick, XBoxJoystickMap.A_BUTTON);
		JoystickButton operStickBButton = new JoystickButton(operStick, XBoxJoystickMap.B_BUTTON);
		JoystickButton operStickLeftBumper = new JoystickButton(operStick, XBoxJoystickMap.LEFT_BUMPER_BUTTON);
		JoystickButton operStickRightBumper = new JoystickButton(operStick, XBoxJoystickMap.RIGHT_BUMPER_BUTTON);
		JoystickButton operStickBackButton = new JoystickButton(operStick, XBoxJoystickMap.BACK_BUTTON);
		JoystickButton operStickStartButton = new JoystickButton(operStick, XBoxJoystickMap.START_BUTTON);
		JoystickButton operStickLeftStickButton = new JoystickButton(operStick, XBoxJoystickMap.LEFT_STICK_BUTTON);
		JoystickButton operStickRightStickButton = new JoystickButton(operStick, XBoxJoystickMap.RIGHT_STICK_BUTTON);



		// Declare and Initiate all of the Buttons on the Driver Stick
		JoystickButton driverStickYButton = new JoystickButton(driverStick, XBoxJoystickMap.Y_BUTTON);
		JoystickButton driverStickXButton = new JoystickButton(driverStick, XBoxJoystickMap.X_BUTTON);
		JoystickButton driverStickAButton = new JoystickButton(driverStick, XBoxJoystickMap.A_BUTTON);
		JoystickButton driverStickBButton = new JoystickButton(driverStick, XBoxJoystickMap.B_BUTTON);
		JoystickButton driverStickLeftBumper = new JoystickButton(driverStick, XBoxJoystickMap.LEFT_BUMPER_BUTTON);
		JoystickButton driverStickRightBumper = new JoystickButton(driverStick, XBoxJoystickMap.RIGHT_BUMPER_BUTTON);
		JoystickButton driverStickBackButton = new JoystickButton(driverStick, XBoxJoystickMap.BACK_BUTTON);
		JoystickButton driverStickStartButton = new JoystickButton(driverStick, XBoxJoystickMap.START_BUTTON);
		JoystickButton driverStickLeftStickButton = new JoystickButton(driverStick, XBoxJoystickMap.LEFT_STICK_BUTTON);
		JoystickButton driverStickRightStickButton = new JoystickButton(driverStick, XBoxJoystickMap.RIGHT_STICK_BUTTON);
	

	// SETUP OUR JOYSTICK BUTTON MAPPINGS HERE!!!
		// Driver Stick
		//driverStickRightStickButton.whileHeld(new DriveLimeLightCommand());
		driverStickLeftStickButton.whenPressed(new DriveJoystickCommand());
		driverStickXButton.whenPressed(new NoseConeForwardCommand());
		driverStickBButton.whenPressed(new NoseConeReverseCommand());
		driverStickAButton.whileHeld(new DriveLimeLightCommand());
		driverStickLeftBumper.whenPressed(new NoseConeOpenCommand());
		driverStickRightBumper.whenPressed(new NoseConeCloseCommand());
		driverStickBackButton.whenPressed(new DefenseModeAutoCommand());
		driverStickStartButton.whenPressed(new OffenseModeAutoCommand());

		// Operator Stick
		//operStickBackButton.whenPressed(new BlastOffHighHabPlatformCommand());
		//operStickStartButton.whenPressed(new BlastOffMedHabPlatformCommand());
		operStickXButton.whenPressed(new DinoArmsGrabCommand());
		operStickBButton.whenPressed(new DinoArmsReleaseCommand());	
		operStickLeftBumper.whenPressed(new BlackHoleBoomCommand());
		operStickAButton.whenPressed(new BlastOffHighHabPlatformAutoCommand());
	
}

	// This method is used later to return the the driverStick when called.
	public Joystick getDriverStick() {
		return driverStick;
	}

	// This method is used later to return the the operStick when called.
	public Joystick getOperStick() {
		return operStick;
	}

}

