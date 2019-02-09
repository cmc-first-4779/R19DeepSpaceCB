/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchHandlerSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Solenoid beak = new Solenoid(RobotMap.SOLINOID_SINGLE_PCM_PORT);
  DoubleSolenoid beak2 = new DoubleSolenoid(RobotMap.SOLINOID_DOUBLE_PCM_PORT_A, RobotMap.SOLINOID_DOUBLE_PCM_PORT_B);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void TurnOn() {
    beak.set(true);
    beak2.set(DoubleSolenoid.Value.kForward);
  }

  public void TurnOff() {
    beak.set(false);
    beak2.set(DoubleSolenoid.Value.kReverse);
  }
}
