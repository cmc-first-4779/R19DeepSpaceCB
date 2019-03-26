/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.PhaserConstants;
import frc.robot.autoCommands.SetHeightLevel2DriveForwardAutoCommand;
import frc.robot.commands.Misc.TimerCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeReverseCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.WarpDriveHabSlowCommand;
import frc.robot.commands.BlackHole.BlackHoleUnBoomCommand;
import frc.robot.commands.BlastOff.*;
import frc.robot.commands.DinoArms.DinoArmsGrabCommand;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;


public class BlastOffHighHabPlatformAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BlastOffHighHabPlatformAutoCommand() {
     //Kick off the blastoff LEDs
     addParallel(new BlastOffSetOutputRangeCommand(1.0));
     addParallel(new BlastOffResetEncoderCommand());
     addParallel(new NoseConeReverseCommand());
     addParallel(new NoseConeCloseCommand());
     addParallel(new BlackHoleUnBoomCommand());
     addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_GLITTER_PALETTE));
     addParallel(new DinoArmsGrabCommand());
     addSequential(new SetHeightLevel3DriveForwardAutoCommand());
     

     
     //Won't get to next line until we have a way to know that we've finished moving forward. 
     addParallel(new BlastOffWheelsStopCommand());
     addParallel(new BlastOffLandCommand());
     addSequential(new DinoArmsReleaseCommand());
  }
}