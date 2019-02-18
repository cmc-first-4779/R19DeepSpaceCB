
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Misc.TimerCommand;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.NoseCone.*;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.EventHorizon.EventHorizonRaiseArmCommand;

public class PositionForHatchIntakeAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public PositionForHatchIntakeAutoCommand() {
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


    // Move the Event Horizon Arm out of the way, just in case...
    addParallel(new EventHorizonRaiseArmCommand());
    // Move the arm to the floor to get the Hatch
    addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_FLOOR_HATCH));
    // Rotate the Blackhole into place to pick up the Hatch
    addParallel(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_HATCH_LOAD));
    //Close the NoseCone
    addParallel(new NoseConeCloseCommand());
    addSequential(new PhasersSetPatternCommand(RobotMap.PHASERS_STROBE_RED));
  }
}
