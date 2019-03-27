/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.PhaserConstants;
import frc.robot.commands.BlackHole.BlackHoleUnBoomCommand;
import frc.robot.commands.NoseCone.NoseConeForwardCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;
import frc.robot.commands.WarpDrive.WarpDriveOffenseModeCommand;

public class OffenseModeAutoCommand extends CommandGroup {
  /**
   * This command puts the robot in a mode where it can play offense and try to
   * score.
   */
  public OffenseModeAutoCommand() {
    addParallel(new DriveJoystickCommand());
    addParallel(new BlackHoleUnBoomCommand());
    addParallel(new NoseConeForwardCommand());
    addParallel(new WarpDriveOffenseModeCommand());
    addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_DEFAULT));
  }
}
