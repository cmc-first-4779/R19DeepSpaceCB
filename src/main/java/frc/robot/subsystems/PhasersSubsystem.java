/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.PhaserConstants;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;


/**
 * Add your docs here.
 */
public class PhasersSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declare our Blinkin LED Driver 'phasers' as a SPARK!
  Spark phasers;
  
 public PhasersSubsystem(){
   //Initiate the phasers object
    phasers = new Spark(RobotMap.PWM_PORT_PHASERS);
 }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // Because we like the phasers looking like "Glitter"..  
    setDefaultCommand(new PhasersSetPatternCommand(PhaserConstants.PHASERS_DEFAULT));
  }

  //Set the Phasers to a certain pattern
  public void setPhasers(double pattern){
    phasers.set(pattern);

  }

}
