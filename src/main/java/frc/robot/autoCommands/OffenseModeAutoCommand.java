/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.LimeLightConstants;
import frc.robot.PhaserConstants;
import frc.robot.commands.BlackHole.BlackHoleUnBoomCommand;
import frc.robot.commands.Limelight.LimeLightSetCameraModeCommand;
import frc.robot.commands.Limelight.LimeLightSetLEDModeOnCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeForwardCommand;
import frc.robot.commands.NoseCone.NoseConeReverseCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;
import frc.robot.commands.WarpDrive.WarpDriveDefenseModeCommand;
import frc.robot.commands.WarpDrive.WarpDriveOffenseModeCommand;

public class OffenseModeAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public OffenseModeAutoCommand() {
    addParallel(new DriveJoystickCommand());
    addParallel(new LimeLightSetCameraModeCommand(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER));
    addParallel(new LimeLightSetLEDModeOnCommand());
    addParallel(new BlackHoleUnBoomCommand());
    addParallel(new NoseConeForwardCommand());
    addParallel(new NoseConeCloseCommand());
    addParallel(new WarpDriveOffenseModeCommand());
    addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_DEFAULT));
  }
}
