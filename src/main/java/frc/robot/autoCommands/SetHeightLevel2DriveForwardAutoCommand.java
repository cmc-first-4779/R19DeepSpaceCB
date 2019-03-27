/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.BlastOff.BlastOffSetHeightCommand;
import frc.robot.commands.Misc.TimerCommand;

public class SetHeightLevel2DriveForwardAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public SetHeightLevel2DriveForwardAutoCommand() {
    
     addSequential(new TimerCommand(3.0));
     addParallel(new BlastOffSetHeightCommand(10));
     addParallel(new BlastOffSpinBothWheelsAutoCommand());

  }
}
