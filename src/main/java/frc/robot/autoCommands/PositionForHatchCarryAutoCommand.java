/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.HatchHander.NoseconeOpenCommand;
import frc.robot.commands.Misc.TimerCommand;


/*******   THIS IS THE AUTO COMMAND WE USE AFTER WE ACQUIRE A HATCH COVER.   *************************/
/*******   It will reposition, the ARM, NoseCone and BlackHole into the correct positions for transport.   *****/

public class PositionForHatchCarryAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public PositionForHatchCarryAutoCommand() {
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

        // Set our Phasers...
        addParallel(new PhasersSetPatternCommand(RobotMap.PHASERS_STROBE_RED));
        // Rotate the Blackhole into place to pick up the hatchcover
        addParallel(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_HATCH_LOAD));
        addParallel(new NoseconeOpenCommand());
        // Wait a little bit before lifting the arm..
        addSequential(new TimerCommand(RobotMap.CARGO_LOAD_WAIT_TIME));
        //  Lift the arm up for transporting the hatchcover..   Using the Rocket Ship Lower Hatch Height
        addSequential(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_CARGO_SHIP_HATCH));
  }
}
