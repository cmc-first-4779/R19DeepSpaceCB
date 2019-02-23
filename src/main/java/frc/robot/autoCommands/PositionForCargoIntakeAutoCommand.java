/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.Misc.TimerCommand;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRetractPlungerCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.EventHorizon.EventHorizonCaptureCargoCommand;
import frc.robot.PhaserConstants;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.Misc.SetCarryModeCommand;

public class PositionForCargoIntakeAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public PositionForCargoIntakeAutoCommand() {
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

       // Move the arm to the floor to get the Cargo
       addParallel(new PhasersSetPatternCommand(PhaserConstants.PHASERS_STROBE_RED));
       //Retract the plunger just in case...
       addParallel(new BlackHoleRetractPlungerCommand());
       //  Put the arm on the floor in the right position
       addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_FLOOR_CARGO));
       // Rotate the Blackhole into place to pick up the cargo
       addParallel(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_CARGO_LOAD));
       // Wait for a little before swinging down the Event Horizon arm
       addSequential(new TimerCommand(RobotMap.EVENTHORIZON_ARM_WAIT_TIME)); 
       // Lower the Event Horizon Arm to take in the cargo
       addSequential(new EventHorizonCaptureCargoCommand());
       //  Set Carry Mode to Cargo 
       addSequential(new SetCarryModeCommand(RobotMap.CARRY_MODE_CARGO));
  }
}
