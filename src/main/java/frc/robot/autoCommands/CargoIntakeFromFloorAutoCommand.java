/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.BlackHole.SetBlackHoleCargoLoadCommand;
import frc.robot.commands.BlackHole.SetBlackHoleCargoCarryCommand;
import frc.robot.commands.Arms.SetArmFloorCargoCommand;
import frc.robot.commands.EventHorizon.*;
import frc.robot.commands.Phasers.PhasersSetPhaserCommand;
import frc.robot.commands.Misc.TimerCommand;

public class CargoIntakeFromFloorAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CargoIntakeFromFloorAutoCommand() {
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
    addParallel(new SetArmFloorCargoCommand());
    // Rotate the Blackhole into place to pick up the cargo
    addParallel(new SetBlackHoleCargoLoadCommand());
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_STROBE_RED));
    addSequential(new TimerCommand(0.5));

    // Lower the Event Horizon Arm to take in the cargo
    addSequential(new EventHorizonLowerArmCommand());
    // Spin the Event Horizon wheels to suck in the Cargo into the BlackHole
    addSequential(new EventHorizonIntakeCargoCommand());
    addSequential(new TimerCommand(1.0));
    //  Stop the Event Horizon wheels....
    addParallel(new EventHorizonStopMotorCommand());
    // Raise the Event Horizon Arms
    addSequential(new EventHorizonRaiseArmCommand());
    //  Rotate the Black Hole into the Carry Position
    addSequential(new SetBlackHoleCargoCarryCommand());

  }
}
