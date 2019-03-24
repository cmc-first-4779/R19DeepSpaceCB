/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;

/**
 * Add your docs here.
 */
public class DinoArmsSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //  Declare the BlastOff Solenoid
public DoubleSolenoid dinoArmsSolenoid;

public DinoArmsSubsystem() {
      //Init our Double Solenoid
      dinoArmsSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_DINO_ARMS_GRAB, RobotMap.PCM_PORT_DINO_ARMS_UNGRAB);   
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DinoArmsReleaseCommand());
  }

  public void dinoArmGrab(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void dinoArmRelease(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
