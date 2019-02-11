/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class ArmsSubsytem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX armMotor; 
 
  public ArmsSubsytem() {
    armMotor =  new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM);
    Robot.initMotorController(armMotor);    
    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void raiseArm() {
    // Lift the arms up
    armMotor.set(RobotMap.ARM_RAISE_SPEED);
  }

  public void lowerArm() {
    // Lower the robot arm
    armMotor.set(RobotMap.ARM_LOWER_SPEED);
  }
}
