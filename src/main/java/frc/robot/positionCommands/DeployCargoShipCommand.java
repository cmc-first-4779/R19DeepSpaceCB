/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.positionCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.BlackHole.BlackHolePlungeCommand;
import frc.robot.commands.NoseCone.NoseConeCloseCommand;
import frc.robot.commands.Misc.*;

public class DeployCargoShipCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DeployCargoShipCommand() {
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

    //System.out.println("Is there a ball in the box?:  " + Robot.eventHorizonSubsystem.isBallInBox());

    if (Robot.eventHorizonSubsystem.isBallInBox()){
      //  Do this loop if a cargo ball is in the box....
      addSequential(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_CARGO_SHIP_CARGO));
      addSequential(new TimerCommand(0.5));
      addSequential(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_CARGO_SHIP_CARGO));
      //addSequential(new TimerCommand(RobotMap.CARGO_LOAD_WAIT_TIME));
      //addSequential(new BlackHolePlungeCommand());
      //addSequential(new TimerCommand(RobotMap.DEPLOY_WAIT_TIME_BEFORE_MOVE));
      //addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_FLOOR_CARGO));
      //addSequential(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_CARGO_CARRY));
    }
    else {
      addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_CARGO_SHIP_HATCH));
      addSequential(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_CARGO_SHIP_HATCH));
      //addSequential(new TimerCommand(RobotMap.HATCH_LOAD_WAIT_TIME));
      //addSequential(new NoseConeCloseCommand());
    }

  }
}
