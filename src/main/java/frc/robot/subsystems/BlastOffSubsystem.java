/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class BlastOffSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark blastOffMotor;
  DoubleSolenoid blastOffSolenoid;

  public BlastOffSubsystem(){
    
    //Init our Spark Motor Controller
    blastOffMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF);
    //Init our Double Solenoid
    blastOffSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_BLASTOFF_LAND, RobotMap.PCM_PORT_BLASTOFF_LAND);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void launch(){
    blastOffSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void land(){
    blastOffSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void forward(){
    blastOffMotor.set(RobotMap.BLASTOFF_FORWARD_SPEED);
  }

  public void reverse(){
    blastOffMotor.set(RobotMap.BLASTOFF_REVERSE_SPEED);
  }


}
