/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.BlastOffWheels.BlastOffWheelsForwardCommand;
import frc.robot.commands.Misc.TimerCommand;

public class BlastOffWheelsLevel3ClimbAutoCommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BlastOffWheelsLevel3ClimbAutoCommandGroup() {
    addSequential(new TimerCommand(2));
    addSequential(new BlastOffWheelsForwardCommand(), 8);
  }
}
