/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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

  public WPI_TalonSRX armMaster; 
 public WPI_VictorSPX armSlave;

  public ArmsSubsytem() {
    armMaster =  new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM_MASTER);
    //armSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_ARM_SLAVE);
    Robot.initMotorController(armMaster);
    //Robot.initMotorController(armSlave);    
    //armSlave.follow(armMaster);
    armMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    armMaster.config_kP(0,.5, 0);
    armMaster.config_kI(0, 0.0005, 0);
    armMaster.config_kD(0, 0, 0);
    armMaster.config_kF(0, 0, 0);
    armMaster.setSensorPhase(true);
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void raiseArm() {
    // Lift the arms up
    //System.out.println("Lifting my arms up!");

    armMaster.set(ControlMode.PercentOutput, RobotMap.ARM_RAISE_SPEED);
    System.out.println("Encoder count: " + armMaster.getSelectedSensorPosition());
  }

  public void lowerArm() {
    // Lower the robot arm
    armMaster.set(RobotMap.ARM_LOWER_SPEED);
  }
  
  public void stop() {
    System.out.println("I should be stopping now");
    armMaster.stopMotor();
  }
  public void setSetPoint(double setPoint){
    // Move arm to set point
    armMaster.setSelectedSensorPosition(0, 0, 0);
    armMaster.set(ControlMode.Position, setPoint);
    System.out.println("Encoder count: " + armMaster.getSelectedSensorPosition());
  }

  public void resetEncoder() {
    armMaster.setSelectedSensorPosition(0);
  }
}
