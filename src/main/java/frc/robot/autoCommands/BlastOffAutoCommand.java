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
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.BlastOff.*;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;


public class BlastOffAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public BlastOffAutoCommand() {
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

    //Move the Arm into position
    addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_HIGH_HAB_PlATFORM));

    //Kick off the blastoff LEDs
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_STROBE_GOLD));
    addSequential(new TimerCommand(0.20));
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_YELLOW));
    addSequential(new TimerCommand(0.25));

    //Rotate the Blackhole / Cargo handler around to the right angle
    addParallel(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_HIGH_HAB_PLATFORM));
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_ORANGE));
    addSequential(new TimerCommand(0.30));
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_FIRE_MEDIUM));
    addSequential(new TimerCommand(1.25));

    //LET'S LAUNCH!!!!!!!!!!
    addParallel(new BlastOffLaunchCommand());
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_FIRE_LARGE));
    addSequential(new TimerCommand(2.25));

    //Move the BLASTOFF WHEELS FORWARD
    addParallel(new BlastOffMoveForwardCommand());
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_FIRE_MEDIUM));
    addSequential(new TimerCommand(1.25));

    //Move the ARM back down...
    addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_FLOOR_CARGO));
    // Rotate the BlackHole
    addParallel(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_CARGO_LOAD));
    addSequential(new BlastOffLandCommand());

    //PARTY PHASERS!!!!
    addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_PARTY_PALETTE));



  }
}
