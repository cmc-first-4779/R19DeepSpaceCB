/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.PrintAngleCommand;
import frc.robot.commands.RaiseArmCommand;
import frc.robot.commands.SetArmEncoderPositionCommand;
import frc.robot.commands.SpinningBecauseWhyNot;
import frc.robot.commands.TurnToAngle;
import frc.robot.commands.Phasers.PhasersBlackCommand;
import frc.robot.commands.Phasers.PhasersGlitterCommand;
import frc.robot.commands.Phasers.PhasersLarsonScannerCommand;
import frc.robot.commands.Phasers.PhasersLavaCommand;
import frc.robot.commands.Phasers.PhasersOceanCommand;
import frc.robot.commands.Phasers.PhasersSetPhaserCommand;
import frc.robot.commands.Phasers.PhasersShotCommand;

public class OI {
	// Declare the two joysticks and initate them on the two appropriate USB ports
	// recognized by the Drivers Station.
	Joystick driverStick = new Joystick(RobotMap.DRIVERSTICK_USB_PORT);
	Joystick operStick = new Joystick(RobotMap.OPERSTICK_USB_PORT);

	public OI() {
		//// CREATING BUTTONS
		// One type of button is a joystick button which is any button on a
		//// joystick.
		// You create one by telling it which joystick it's on and which button
		// number it is.
		// Joystick stick = new Joystick(port);
		// Button button = new JoystickButton(stick, buttonNumber);

		// Declare and Initiate all of the Buttons on the OperStick
		JoystickButton operStickYButton = new JoystickButton(operStick, RobotMap.Y_BUTTON);
		JoystickButton operStickXButton = new JoystickButton(operStick, RobotMap.X_BUTTON);
		JoystickButton operStickAButton = new JoystickButton(operStick, RobotMap.A_BUTTON);
		JoystickButton operStickBButton = new JoystickButton(operStick, RobotMap.B_BUTTON);
		JoystickButton operStickLeftBumper = new JoystickButton(operStick, RobotMap.LEFT_BUMPER_BUTTON);
		JoystickButton operStickRightBumper = new JoystickButton(operStick, RobotMap.RIGHT_BUMPER_BUTTON);
		JoystickButton operStickBackButton = new JoystickButton(operStick, RobotMap.BACK_BUTTON);
		JoystickButton operStickStartButton = new JoystickButton(operStick, RobotMap.START_BUTTON);

		// Declare and Initiate all of the Buttons on the Driver Stick
		JoystickButton driverStickYButton = new JoystickButton(driverStick, RobotMap.Y_BUTTON);
		JoystickButton driverStickXButton = new JoystickButton(driverStick, RobotMap.X_BUTTON);
		JoystickButton driverStickAButton = new JoystickButton(driverStick, RobotMap.A_BUTTON);
		JoystickButton driverStickBButton = new JoystickButton(driverStick, RobotMap.B_BUTTON);
		JoystickButton driverStickLeftBumper = new JoystickButton(driverStick, RobotMap.LEFT_BUMPER_BUTTON);
		JoystickButton driverStickRightBumper = new JoystickButton(driverStick, RobotMap.RIGHT_BUMPER_BUTTON);
		JoystickButton driverStickBackButton = new JoystickButton(driverStick, RobotMap.BACK_BUTTON);
		JoystickButton driverStickStartButton = new JoystickButton(driverStick, RobotMap.START_BUTTON);

		// SETUP OUR JOYSTICK BUTTON MAPPINGS HERE!!!
		// Driver Stick
		//driverStickYButton.whileHeld(new ClimberOn());

		// Operator Stick
		//operStickLeftBumper.whileHeld(new VacCubeIntake());

		driverStickAButton.whenPressed(new SetArmEncoderPositionCommand(40));
		driverStickBButton.whenPressed(new SetArmEncoderPositionCommand(-40));
		//driverStickYButton.whenPressed(new TurnToAngle(120));
		driverStickXButton.whileHeld(new RaiseArmCommand());


		operStickAButton.whenPressed(new PhasersShotCommand());
		operStickBButton.whenPressed(new PhasersGlitterCommand());
		operStickXButton.whenPressed(new PhasersOceanCommand());
		operStickYButton.whenPressed(new PhasersLavaCommand());
		operStickLeftBumper.whenPressed(new PhasersLarsonScannerCommand());
		operStickRightBumper.whenPressed(new PhasersSetForestCommand());
		operStickStartButton.whenPressed(new PhasersSetPhaserCommand());
		


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

