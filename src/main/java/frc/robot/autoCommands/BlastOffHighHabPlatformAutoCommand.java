/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.PhaserConstants;
import frc.robot.commands.Misc.TimerCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeReverseCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.WarpDriveHabSlowCommand;
import frc.robot.commands.BlackHole.BlackHoleUnBoomCommand;
import frc.robot.commands.BlastOff.*;


public class BlastOffHighHabPlatformAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BlastOffHighHabPlatformAutoCommand() {
    //Kick off the blastoff LEDs
    addParallel(new NoseConeReverseCommand());
    addParallel(new NoseConeCloseCommand());
    addParallel(new BlackHoleUnBoomCommand());
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_GLITTER_PALETTE));
    addSequential(new BlastOffDinoArmsGrabCommand());
    addSequential(new TimerCommand(0.5));
    addSequential(new BlastOffHighHabPlatformCommand());
    addSequential(new TimerCommand(1.0));
    addParallel(new WarpDriveHabSlowCommand());
    addSequential(new BlastOffWheelsForwardCommand());
    addSequential(new TimerCommand(4.5));
    addParallel(new BlastOffWheelsStopCommand());
    addSequential(new BlastOffLegsSetPositionZeroCommand());
    addSequential(new BlastOffDInoArmsUnGrabCommand());
  }
}