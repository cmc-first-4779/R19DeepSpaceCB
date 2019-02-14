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

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.BlackHoleChillCommand;

/**
 * Add your docs here.
 */
public class BlackHoleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX spinMotor;
  DoubleSolenoid plunger;

  public BlackHoleSubsystem() {
    plunger = new DoubleSolenoid(RobotMap.PCM_PLUNGER_PLUNGE_PORT, RobotMap.PCM_PLUNGER_RETRACT_PORT);
    spinMotor = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_BLACKHOLE);
    Robot.initMotorController(spinMotor);
    spinMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    spinMotor.config_kP(0, 0, 0);
    spinMotor.config_kI(0, 0, 0);
    spinMotor.config_kD(0, 0, 0);
    spinMotor.config_kF(0, 0, 0);
    spinMotor.setSensorPhase(true);
    spinMotor.configPeakCurrentLimit(10);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new BlackHoleChillCommand());
  }

  public void spin(double rate) {
    // spin the spinner forwards at a set speed
    spinMotor.set(.5);
    if (rate > 0.25){
      spinMotor.set(ControlMode.PercentOutput, RobotMap.ARM_RAISE_SPEED);
    } else if (rate < -0.25) {
      spinMotor.set(ControlMode.PercentOutput, RobotMap.ARM_LOWER_SPEED);
    } else {
      spinMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  public void setSetPoint(double angle) {
    // do the math to figure out what the encoder count should be
    // Move arm to set point
    spinMotor.set(ControlMode.Position, angle);
    System.out.println("Encoder count: " + spinMotor.getSelectedSensorPosition());
  }

  public void plunge() {
    plunger.set(DoubleSolenoid.Value.kForward);
  }

  public void retractPlunger() {
    plunger.set(DoubleSolenoid.Value.kReverse);
  }

  public void stop() {
    spinMotor.stopMotor();
  }

}
