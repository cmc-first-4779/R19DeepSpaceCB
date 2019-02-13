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
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * Add your docs here.
 */
public class PhasersSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark phasers;
  


 
  

 public PhasersSubsystem(){
    phasers = new Spark(RobotMap.PWM_PORT_PHASERS);
 }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setPhasers(double pattern){
    phasers.set(pattern);
  }

  public void setPhasersWhite(){
    phasers.set(RobotMap.PHASERS_WHITE);
  }

  public void setPhasersLawnGreen(){
    phasers.set(RobotMap.PHASERS_LAWN_GREEN);
  }

  public void setPhasersBlack(){
    phasers.set(RobotMap.PHASERS_BLACK);
  }

  public void setPhasersOcean(){
    phasers.set(RobotMap.PHASERS_OCEAN_PALETTE);
  }
  
  public void setPhasersForest(){
    phasers.set(RobotMap.PHASERS_FOREST_PALETTE);
  }

  public void setPhasersGlitter(){
    phasers.set(RobotMap.PHASERS_GLITTER_PALETTE);
  }

  public void setPhasersConfetti(){
    phasers.set(RobotMap.PHASERS_CONFETTI_PALETTE);
  }

  public void setPhasersLava(){
    phasers.set(RobotMap.PHASERS_SINELON_LAVA_PALETTE);
  }

  public void setPhasersFire(){
    phasers.set(RobotMap.PHASERS_FIRE_PALETTE);
  }

  public void setPhasersLarsonScanner(){
    phasers.set(RobotMap.PHASERS_LARSON_SCANNER);
  }

  public void setPhasersShot(){
    phasers.set(RobotMap.PHASERS_SHOT);
  }
}
