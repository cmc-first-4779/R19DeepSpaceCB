/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.BlastOff.BlastOffSetHeightCommand;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;
import frc.robot.commands.Misc.TimerCommand;

public class SetHeightLevel3DriveForwardAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public SetHeightLevel3DriveForwardAutoCommand() {
    addSequential(new TimerCommand(0.25));
    addParallel(new BlastOffSetHeightCommand(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT));
    addParallel(new BlastOffSpinBothWheelsAutoCommand());
  }
}
