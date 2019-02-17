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
import frc.robot.commands.Phasers.PhasersSetPhaserCommand;
import frc.robot.commands.Arms.SetArmRocketLowerCargoCommand;
import frc.robot.commands.BlackHole.SetBlackHoleCargoCarryCommand;
import frc.robot.commands.EventHorizon.EventHorizonRaiseArmCommand;
import frc.robot.commands.EventHorizon.EventHorizonStopMotorCommand;


public class PositionForCargoCarryAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public PositionForCargoCarryAutoCommand() {
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
    addParallel(new PhasersSetPhaserCommand(RobotMap.PHASERS_STROBE_RED));
    // Rotate the Blackhole into place to pick up the cargo
    addParallel(new SetBlackHoleCargoCarryCommand());
    //  Make sure the Event Horizon motors are not spinning
    addParallel(new EventHorizonStopMotorCommand());
    // Wait a little bit before lifting the farm..
    addSequential(new TimerCommand(RobotMap.CARGO_LOAD_WAIT_TIME));
    // Riase the Event Horizon Arm to get it out of the way
    addParallel(new EventHorizonRaiseArmCommand());
    addParallel(new EventHorizonStopMotorCommand());
    //  Lift the arm up for transporting the cargo..   Using the Rocket Ship Lower Cargo Height
    addSequential(new TimerCommand(RobotMap.EVENTHORIZON_ARM_WAIT_TIME));
    addSequential(new SetArmRocketLowerCargoCommand());

       
   


  }
}
