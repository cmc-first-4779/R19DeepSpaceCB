/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.BlastOff.BlastOffLandCommand;
import frc.robot.commands.BlastOff.BlastOffSetHeightCommand;
import frc.robot.commands.Misc.TimerCommand;

public class BlastOffLevel3ClimbAutoCommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BlastOffLevel3ClimbAutoCommandGroup() {
    //addSequential(new TimerCommand(.25));
    addSequential(new BlastOffSetHeightCommand(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT), 8);
//    addSequential(new BlastOffSetHeightCommand(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT + 2));
    addSequential(new BlastOffLandCommand());
 }
}
