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
import frc.robot.commands.NoseCone.*;

/**
 *   NOSE CONE Subsytem - This is what carries the Hatch..
 */
public class NoseConeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //
  //Declare our noseCone as a Double Solenoid
  DoubleSolenoid noseCone;
  DoubleSolenoid theAlex;

  public NoseConeSubsystem(){
    //Initiate the noseCone.
    noseCone = new DoubleSolenoid(RobotMap.PCM_PORT_HATCHHANDLER_NOSECONE_EXPAND, RobotMap.PCM_PORT_HATCHHANDLER_NOSECONE_RETRACT);
    theAlex = new DoubleSolenoid(RobotMap.PCM_PORT_HATCHHANDLER_THE_ALEX_FORWARD, RobotMap.PCM_PORT_HATCHHANDLER_THE_ALEX_REVERSE);
  }

  @Override
  public void initDefaultCommand() {
  }

  //Open the noseCone
  public void openNoseCone() {
    noseCone.set(DoubleSolenoid.Value.kReverse);
  }

  //Close the noseCone
  public void closeNoseCone() {
    noseCone.set(DoubleSolenoid.Value.kForward);

  }

  //Forward the platform 
  public void forwardTheAlex() {
    theAlex.set(DoubleSolenoid.Value.kForward);
  }

  //Reverse the platform..
  public void reverseTheAlex() {
    theAlex.set(DoubleSolenoid.Value.kReverse);
  }

}
