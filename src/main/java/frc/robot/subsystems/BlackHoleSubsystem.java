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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BlackHoleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Declare our BoomStick as a Double Solenoid
  DoubleSolenoid boomStick;

  // Angle the box should be at
  double boxAngle = 0;

  public BlackHoleSubsystem() {
    // Initiate our boomStick
    boomStick = new DoubleSolenoid(RobotMap.PCM_PORT_BOOMSTICK_BOOM, RobotMap.PCM_PORT_BOOMSTICK_UNBOOM);
  
  }

  @Override
  public void initDefaultCommand() {

  }

  // Make the BoomStick Boom
  public void boom() {
    boomStick.set(DoubleSolenoid.Value.kReverse);
  }

  // Retract the BoomStick after booming...
  public void unBoom() {
    boomStick.set(DoubleSolenoid.Value.kForward);
  }
}
