/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.PhaserConstants;
import frc.robot.RobotMap;
import frc.robot.commands.BlackHole.BlackHoleUnBoomCommand;
import frc.robot.commands.BlastOff.BlastOffResetEncoderCommand;
import frc.robot.commands.BlastOff.BlastOffSetHeightCommand;
import frc.robot.commands.BlastOff.BlastOffSetOutputRangeCommand;
import frc.robot.commands.BlastOffWheels.BlastOffWheelsStopCommand;
import frc.robot.commands.DinoArms.DinoArmsGrabCommand;
import frc.robot.commands.DinoArms.DinoArmsReleaseCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeRetractCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.WarpDriveHabSlowCommand;

public class Level3ClimbAutoCommandGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Level3ClimbAutoCommandGroup() {
     //Kick off the blastoff LEDs
     addParallel(new BlastOffSetOutputRangeCommand(1.0));
     addParallel(new BlastOffResetEncoderCommand());
     addParallel(new NoseConeRetractCommand());
     addParallel(new NoseConeCloseCommand());
     addParallel(new BlackHoleUnBoomCommand());
     addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_GLITTER_PALETTE));
     
     addParallel(new DinoArmsLevel3ClimbAutoCommandGroup());
     addParallel(new BlastOffLevel3ClimbAutoCommandGroup());
     addParallel(new BlastOffWheelsLevel3ClimbAutoCommandGroup());
     addSequential(new WarpDriveLevel3ClimbAutoCommandGroup());
     
     //Won't get to next line until we have a way to know that we've finished moving forward. 
     addParallel(new BlastOffWheelsStopCommand());
    // addParallel(new BlastOffSetHeightCommand(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT + 3));
     addSequential(new DinoArmsReleaseCommand());
  }
}