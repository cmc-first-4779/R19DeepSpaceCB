/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.Phasers.PhasersGlitterCommand;

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
    setDefaultCommand(new PhasersGlitterCommand());
  }

  //Set the Phasers to a certain pattern
  public void setPhasers(double pattern){
    phasers.set(pattern);
  }

  //Change the phasers to white
  public void setPhasersWhite(){
    phasers.set(RobotMap.PHASERS_WHITE);
  }

  //Change the phasers to Lawn Green
  public void setPhasersLawnGreen(){
    phasers.set(RobotMap.PHASERS_LAWN_GREEN);
  }

  //Set the Phasers to black..   IE..  OFF!!!
  public void setPhasersBlack(){
    phasers.set(RobotMap.PHASERS_BLACK);
  }

  //Set the Phasers to the Ocean Pallette
  public void setPhasersOcean(){
    phasers.set(RobotMap.PHASERS_OCEAN_PALETTE);
  }
  
  //Set the Phasers to the Forest Pallette
  public void setPhasersForest(){
    phasers.set(RobotMap.PHASERS_FOREST_PALETTE);
  }

  //WE LIKE GLITTER!!!!
  public void setPhasersGlitter(){
    phasers.set(RobotMap.PHASERS_GLITTER_PALETTE);
  }

  //Set the phasers to Confetti
  public void setPhasersConfetti(){
    phasers.set(RobotMap.PHASERS_CONFETTI_PALETTE);
  }

  //Change the phasers to Lava
  public void setPhasersLava(){
    phasers.set(RobotMap.PHASERS_LAVA_PALETTE);
  }

  //Set the Phasers to Fire
  public void setPhasersFire(){
    phasers.set(RobotMap.PHASERS_FIRE_LARGE);
  }

  //Set the Phasers to Larson Scanner
  public void setPhasersLarsonScanner(){
    phasers.set(RobotMap.PHASERS_LARSON_SCANNER_RED);
  }

  //Set the phasers to Shot
  public void setPhasersShot(){
    phasers.set(RobotMap.PHASERS_COLOR2_SHOT);
   // DriverStation.getInstance().getMatchTime()
  }
}
