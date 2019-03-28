/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.DinoArms.DinoArmsGrabCommand;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;

public class DinoArmsLevel3ClimbAutoCommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DinoArmsLevel3ClimbAutoCommandGroup() {
    addSequential(new DinoArmsGrabCommand(), 6);
    addSequential(new DinoArmsReleaseCommand());
  }
}
