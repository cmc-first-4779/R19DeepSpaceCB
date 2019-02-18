/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.RobotMap;
import frc.robot.commands.Limelight.*;
import frc.robot.commands.WarpDrive.*;
import frc.robot.commands.Arms.SetArmCargoShipCargoCommand;
import frc.robot.commands.BlackHole.BlackHolePlungeCommand;
import frc.robot.commands.BlackHole.BlackHoleRetractPlungerCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.Misc.TimerCommand;

public class TargetCargoShipCargoAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public TargetCargoShipCargoAutoCommand() {
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

        //  Set the Camera Mode to Vision
        addSequential(new LimelightSetCameraModeVisionCommand());
        //   Set the Vision Pipeline to the Rocket Hatch
        addSequential(new LimeLightSetVisionPipelineCommand(RobotMap.LIMELIGHT_PIPELINE_ROCKET_CARGO));
        //   Change the LEDS to LIME GREEN if the LIMELIGHT has a Target, RED if it doesn't
        addSequential(new LimeLightHasTargetCommand());
        //  Position the ARM up to the Lower Rocket Hatch Height
        addParallel(new SetArmCargoShipCargoCommand());
        //  Position the BlackHole / Cargo Handler to the right angle to be square on the Hatch
        addSequential(new BlackHoleRotateToAngleCommand(RobotMap.ARM_ENCODER_POSITION_CARGO_SHIP_CARGO));
        addSequential(new LimeLightSeekAndFollowCommand(RobotMap.LIMELIGHT_PIPELINE_ROCKET_CARGO));
        //
        //  Not sure how far to drive forward YET!!!
        //
     
        //   Eject the ball with the plunger...
        addSequential(new BlackHolePlungeCommand());        
        //  Wait for some time..
        addSequential(new TimerCommand(RobotMap.DEPLOY_WAIT_TIME_BEFORE_MOVE));
        //   Back up the robot
        addSequential(new DriveToSetPointCommand(RobotMap.WARPDRIVE_BACKUP_DISTANCE, RobotMap.WARPDRIVE_DIRECTION_REVERSE));
        //  Turn the Camera back to Driver Mode
        addParallel(new LimelightSetCameraModeDriverCommand());
        //  Flip the LEDs back to DEFAULT
        addParallel(new PhasersSetPatternCommand(RobotMap.PHASERS_DEFAULT));
        //  Retract the Plunger
        addParallel(new BlackHoleRetractPlungerCommand());    
  }
}
