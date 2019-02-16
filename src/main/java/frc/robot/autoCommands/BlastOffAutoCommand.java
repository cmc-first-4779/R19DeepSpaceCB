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
import frc.robot.commands.Phasers.*;
import frc.robot.commands.BlastOff.*;
import frc.robot.commands.Arms.SetArmHighHabitatPlatformCommand;
import frc.robot.commands.Arms.SetArmFloorCargoCommand;
import frc.robot.commands.BlackHole.SetBlackHoleHighHabitatPlatformCommand;
import frc.robot.commands.BlackHole.SetBlackHoleCargoLoadCommand;


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
    addParallel(new SetArmHighHabitatPlatformCommand());

    //Kick off the blastoff LEDs
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_STROBE_GOLD));
    addSequential(new TimerCommand(0.20));
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_YELLOW));
    addSequential(new TimerCommand(0.25));

    //Rotate the Blackhole / Cargo handler around to the right angle
    addParallel(new SetBlackHoleHighHabitatPlatformCommand());
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_ORANGE));
    addSequential(new TimerCommand(0.30));
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_FIRE_MEDIUM));
    addSequential(new TimerCommand(1.25));

    //LET'S LAUNCH!!!!!!!!!!
    addParallel(new LaunchCommand());
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_FIRE_LARGE));
    addSequential(new TimerCommand(2.25));

    //Move the BLASTOFF WHEELS FORWARD
    addParallel(new MoveForwardCommand());
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_FIRE_MEDIUM));
    addSequential(new TimerCommand(1.25));

    addParallel(new SetArmFloorCargoCommand());
    addParallel(new SetBlackHoleCargoLoadCommand());

    //PARTY PHASERS!!!!
    addSequential(new PhasersSetPhaserCommand(RobotMap.PHASERS_PARTY_PALETTE));



  }
}
