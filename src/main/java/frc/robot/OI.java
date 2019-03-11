/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Arms.*;
import frc.robot.commands.BlackHole.*;
import frc.robot.commands.BlastOff.*;
import frc.robot.commands.EventHorizon.*;
import frc.robot.commands.NoseCone.*;
import frc.robot.commands.WarpDrive.WarpDriveAdjustLeftTurnCommand;
import frc.robot.commands.WarpDrive.WarpDriveAdjustRightTurnCommand;
import frc.robot.commands.WarpDrive.WarpDriveTurnSome;
import frc.robot.autoCommands.*;
import frc.robot.positionCommands.*;

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

		// Declare and Initiate all of the Buttons on the Driver Stick
		JoystickButton driverStickYButton = new JoystickButton(driverStick, XBoxJoystickMap.Y_BUTTON);
		JoystickButton driverStickXButton = new JoystickButton(driverStick, XBoxJoystickMap.X_BUTTON);
		JoystickButton driverStickAButton = new JoystickButton(driverStick, XBoxJoystickMap.A_BUTTON);
		JoystickButton driverStickBButton = new JoystickButton(driverStick, XBoxJoystickMap.B_BUTTON);
		JoystickButton driverStickLeftBumper = new JoystickButton(driverStick, XBoxJoystickMap.LEFT_BUMPER_BUTTON);
		JoystickButton driverStickRightBumper = new JoystickButton(driverStick, XBoxJoystickMap.RIGHT_BUMPER_BUTTON);
		JoystickButton driverStickBackButton = new JoystickButton(driverStick, XBoxJoystickMap.BACK_BUTTON);
		JoystickButton driverStickStartButton = new JoystickButton(driverStick, XBoxJoystickMap.START_BUTTON);

	// SETUP OUR JOYSTICK BUTTON MAPPINGS HERE!!!
		// Driver Stick

		//driverStickLeftBumper.whenPressed(new WarpDriveTurnSome(-RobotMap.WARPDRIVE_BUMPER_TURN_INCREMENT));
		//driverStickRightBumper.whenPressed(new WarpDriveTurnSome(RobotMap.WARPDRIVE_BUMPER_TURN_INCREMENT));
		driverStickXButton.whenPressed(new EventHorizonCaptureCargoCommand());
		driverStickBButton.whenPressed(new EventHorizonRetractCommand());
		driverStickLeftBumper.whenPressed(new NoseConeOpenCommand());
		driverStickRightBumper.whenPressed(new NoseConeCloseCommand());
		driverStickYButton.whileHeld(new BlastOffMoveForwardCommand());
		driverStickAButton.whileHeld(new BlastOffMoveReverseCommand());
		driverStickBackButton.whenPressed(new BlastOffLaunchCommand());
		driverStickStartButton.whenPressed(new BlastOffLandCommand());

		// Operator Stick
		operStickYButton.whenPressed(new DeployUpperAutoCommand());
		operStickXButton.whenPressed(new DeployMiddleAutoCommand());
		operStickAButton.whenPressed(new DeployLowerAutoCommand());
		operStickBButton.whenPressed(new DeployCargoShipCommand());
		operStickLeftBumper.whenPressed(new MoveToLowerAutoCommand());

		operStickRightBumper.whenPressed(new BlackHolePlungeCommand()); 
		operStickBackButton.whenPressed(new ArmsResetEncoderCommand());

		//operStickLeftBumper.whenPressed(new BlastOffStopMotorCommand());
		//operStickRightBumper.whenPressed(new ArmConfigForBlastOff());
		
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

