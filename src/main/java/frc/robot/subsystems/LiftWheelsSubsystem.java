/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftWheels.LiftWheelsJoystickCommand;

/**
 * Add your docs here.
 */
public class LiftWheelsSubsystem extends Subsystem implements PIDOutput {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Declare our Spark Motor that powers the Wheels on the Legs
  Spark wheelsMotor;

  // PIDController to control moving the wheels
  PIDController wheelsController;

  // Encoder for wheel
  public static Encoder wheelEncoder;

  // PID Tuning values
  private final double kP = 0.025;
  private final double kI = 0;
  private final double kD = 0;

  // Default Constructor
  public LiftWheelsSubsystem() {

    // Init our Spark Motor Controller for wheels
    wheelsMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF_WHEELS);

    // Instantiate our turn controller
    wheelsController = new PIDController(kP, kI, kD, wheelEncoder, this);
    wheelsController.setInputRange(0, 5000);
    wheelsController.setOutputRange(-1, 1);
    wheelsController.setAbsoluteTolerance(10);

    // Init the encoder
    wheelEncoder = new Encoder(RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A,
        RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B);
    // Set the Encoder Distance per Pulse
    wheelEncoder.setDistancePerPulse(RobotMap.BLASTOFF_DISTANCE_PER_PULSE);
    wheelEncoder.reset();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftWheelsJoystickCommand());
  }

  @Override
  public void pidWrite(double output) {
    System.out.println("In pidWrite output of LiftWheelsSubsystem: " + output);
    wheelsSetMotor(output);
  }

  public void wheelsForward() {
    wheelsMotor.set(RobotMap.BLASTOFF_WHEELS_FORWARD_SPEED);
  }

  // Reverse the motors on the Blastoff Foot
  public void wheelsReverse() {
    wheelsMotor.set(RobotMap.BLASTOFF_WHEELS_REVERSE_SPEED);
  }

  public void wheelsSetMotor(double move) {
    wheelsMotor.set(move);
  }

  // Stop the motors on the Blastoff foot
  public void wheelsStopMotor() {
    wheelsMotor.stopMotor();
  }

}
