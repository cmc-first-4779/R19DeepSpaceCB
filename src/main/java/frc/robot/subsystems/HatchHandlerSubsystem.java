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
import frc.robot.commands.HatchHander.NoseconeCloseCommand;

/**
 * Add your docs here.
 */
public class HatchHandlerSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Solenoid beak = new Solenoid(RobotMap.SOLINOID_SINGLE_PCM_PORT);
  DoubleSolenoid noseCone;

  public HatchHandlerSubsystem(){
    noseCone = new DoubleSolenoid(RobotMap.PCM_HATCHHANDLER_NOSECONE_EXPAND_PORT, RobotMap.PCM_HATCHHANDLER_NOSECONE_RETRACT_PORT);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new NoseconeCloseCommand());
  }

  public void openNoseCone() {
  //  beak.set(true);
    noseCone.set(DoubleSolenoid.Value.kForward);
  }

  public void closeNoseCone() {
  //  beak.set(false);
    noseCone.set(DoubleSolenoid.Value.kReverse);

  }
}
