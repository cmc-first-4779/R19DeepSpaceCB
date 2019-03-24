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
import frc.robot.commands.BlastOffWheels.BlastOffWheelsJoystickCommand;


/**
 * Add your docs here.
 */
public class BlastOffWheelsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Declare our Spark Motor that powers the Wheels on the Legs
  Spark wheelsMotor;

  // PIDController to control moving the wheels
  PIDController wheelsController;

  // Default Constructor
  public BlastOffWheelsSubsystem() {
    // Init our Spark Motor Controller for wheels
    wheelsMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF_WHEELS);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BlastOffWheelsJoystickCommand());
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
