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
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.NoseCone.NoseConeReverseCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;

public class DefenseModeAutoCommand extends CommandGroup {
  /**
   *  THIS IS WHERE WE PUT THE ROBOT INTO DEFENSE MODE!!
   */
  public DefenseModeAutoCommand() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    addParallel(new DriveJoystickCommand());
    addParallel(new LimeLightSetCameraModeCommand(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER));
    addParallel(new BlackHoleUnBoomCommand());
    addParallel(new NoseConeReverseCommand());
    addParallel(new NoseConeCloseCommand());
    addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_STROBE_WHITE));



  }
}
