/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Arms.MoveArmWithJoystickCommand;

/**
 * Add your docs here.
 */
public class ArmsSubsytem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declare our two Talons to drive our Arm Motors.
  public WPI_TalonSRX armMaster;
  public WPI_TalonSRX armSlave;


  public ArmsSubsytem() {
    //Initiate the Arm Talon objects
    armMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM_MASTER);
    armSlave = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM_SLAVE);
    //Initiatlize both of the Talons
    Robot.initMotorController(armMaster);
    Robot.initMotorController(armSlave);
    //Slave the armSlave motor to the armMaster
    armSlave.follow(armMaster);
    //Setup our PID values on the encoder
    armMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    armMaster.config_kP(0, .016, 0);
    armMaster.config_kI(0, 0, 0);
    armMaster.config_kD(0, 2.5, 0);
    armMaster.config_kF(0, 0, 0);
    armMaster.setSensorPhase(false);
    armMaster.configPeakCurrentLimit(10);
    armMaster.enableVoltageCompensation(true);
    armMaster.setSelectedSensorPosition(0, 0, 0);
    armMaster.config_IntegralZone(0, 1000);

  }

  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new MoveArmWithJoystickCommand());
  }

  public void moveArm(double move) {
    // Lift the arms up
    // System.out.println("Lifting my arms up!");
    if (move > .25) {
      armMaster.set(ControlMode.PercentOutput, RobotMap.ARM_RAISE_SPEED);
      //System.out.println("Encoder count: " + armMaster.getSelectedSensorPosition());
      //Put the Arm Encoder Position into the Dashboard
      SmartDashboard.putNumber("ARM Position", Robot.armsSubsytem.getEncoderPosition());
    } else if (move < -0.25) {
      armMaster.set(ControlMode.PercentOutput, RobotMap.ARM_LOWER_SPEED);
      //Put the Arm Encoder Position into the Dashboard
      SmartDashboard.putNumber("ARM Position", Robot.armsSubsytem.getEncoderPosition());
    } else {
      armMaster.set(ControlMode.PercentOutput, 0);
      //Put the Arm Encoder Position into the Dashboard
      SmartDashboard.putNumber("ARM Position", Robot.armsSubsytem.getEncoderPosition());
    }
  }

  //Stop the Arm Motors
  public void stop() {
    //System.out.println("I should be stopping now");
    armMaster.stopMotor();
  }

  public void setSetPoint(double height) {
    // do the math to figure out what the encoder count should be
    // Move arm to set point
    armMaster.set(ControlMode.Position, height);
    // Put the Arm Subsystem SetPoint into the Dashboard
    SmartDashboard.putNumber("ARM SetPoint", height);
    //System.out.println("Encoder count: " + armMaster.getSelectedSensorPosition());
    //Put the Arm Encoder Position into the Dashboard
    SmartDashboard.putNumber("ARM Position", getEncoderPosition());
  }

  //Reset the encoder on our Arm Master Talon.
  public void resetEncoder() {
    armMaster.setSelectedSensorPosition(0);
  }

  public double getEncoderPosition() {
    return armMaster.getSelectedSensorPosition();
  }
}
