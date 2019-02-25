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
import frc.robot.autoCommands.*;

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
		//driverStickAButton.whenPressed(new ArmSetPositionCommand(10000));
		//driverStickBButton.whenPressed(new ArmSetPositionCommand(50000));
		//driverStickBackButton.whenPressed(new BlastOffAutoCommand());
		driverStickAButton.whenPressed(new BlackHoleRotateToAngleCommand(45));
		driverStickBButton.whenPressed(new BlackHoleRotateToAngleCommand(-45));


		// Operator Stick
		//operStickLeftBumper.whenPressed(new EventHorizonCaptureCargoCommand());
		//operStickRightBumper.whenPressed(new EventHorizonRetractCommand());
		//operStickAButton.whenPressed(new BlackHolePlungeCommand());
		//operStickYButton.whenPressed(new BlackHoleRetractPlungerCommand());
		//operStickXButton.whenPressed(new ArmSetPositionCommand(175000));
		operStickBButton.whenPressed(new ArmSetPositionCommand(75000));
		//operStickXButton.whenPressed(new NoseConeOpenCommand());
		//operStickBButton.whenPressed(new NoseConeCloseCommand());
		//operStickBackButton.whenPressed(new BlastOffLaunchCommand());
		//operStickStartButton.whenPressed(new BlastOffLandCommand());
		//operStickAButton.whileHeld(new BlastOffMoveForwardCommand());
		//operStickBButton.whileHeld(new BlastOffMoveReverseCommand());

		



/*		operStickLeftBumper.whenPressed(new PositionForCargoIntakeAutoCommand());
		operStickRightBumper.whenPressed(new PositionForCargoCarryAutoCommand());
		operStickBackButton.whenPressed(new PositionForHatchIntakeAutoCommand());
		operStickStartButton.whenPressed(new PositionForHatchCarryAutoCommand());
		operStickXButton.whenPressed(new TargetCargoShipCargoAutoCommand());
		operStickBButton.whenPressed(new TargetCargoShipHatchCoverAutoCommand()); */
	


		


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

