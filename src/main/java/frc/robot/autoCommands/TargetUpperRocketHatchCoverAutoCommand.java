/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.LimeLightConstants;
import frc.robot.commands.Limelight.*;
import frc.robot.commands.WarpDrive.*;
import frc.robot.commands.Arms.ArmSetPositionCommand;
import frc.robot.commands.BlackHole.BlackHoleRotateToAngleCommand;
import frc.robot.commands.NoseCone.*;
import frc.robot.PhaserConstants;
import frc.robot.commands.Phasers.PhasersSetPatternCommand;
import frc.robot.commands.Misc.TimerCommand;

public class TargetUpperRocketHatchCoverAutoCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public TargetUpperRocketHatchCoverAutoCommand() {
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
            addSequential(new LimeLightSetCameraModeCommand(LimeLightConstants.LIMELIGHT_CAMMODE_VISION));
            //   Set the Vision Pipeline to the Rocket Hatch
            addSequential(new LimeLightSetVisionPipelineCommand(RobotMap.LIMELIGHT_PIPELINE_ROCKET_HATCH));
            //   Change the LEDS to LIME GREEN if the LIMELIGHT has a Target, RED if it doesn't
            addSequential(new LimeLightHasTargetCommand());
            //  Position the ARM up to the Upper Rocket Hatch Height
            addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_ROCKET_UPPER_HATCH));
            //  Position the BlackHole / Cargo Handler to the right angle to be square on the Hatch
            addSequential(new BlackHoleRotateToAngleCommand(RobotMap.BLACK_HOLE_ENCODER_POSITION_ROCKET_UPPER_HATCH));
            addSequential(new LimeLightSeekAndFollowCommand(RobotMap.LIMELIGHT_PIPELINE_ROCKET_HATCH));
            //
            //  Not sure how far to drive forward YET!!!
            //
            //  Close the Nosecone to release the Hatch Cover
            addSequential(new NoseConeCloseCommand());
            //  Wait for some time..
            addSequential(new TimerCommand(RobotMap.DEPLOY_WAIT_TIME_BEFORE_MOVE));
            //   Back up the robot
            addSequential(new DriveToSetPointCommand(RobotMap.WARPDRIVE_BACKUP_DISTANCE, RobotMap.WARPDRIVE_DIRECTION_REVERSE,
                RobotMap.WARPDRIVE_SPEED));
            //  Turn the Camera back to Driver Mode
            addParallel(new LimeLightSetCameraModeCommand(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER));
            //  Bring the arm back down
            addParallel(new ArmSetPositionCommand(RobotMap.ARM_ENCODER_POSITION_FLOOR_HATCH));
            //  Flip the LEDs back to DEFAULT
            addSequential(new PhasersSetPatternCommand(PhaserConstants.PHASERS_DEFAULT));
  }
}
