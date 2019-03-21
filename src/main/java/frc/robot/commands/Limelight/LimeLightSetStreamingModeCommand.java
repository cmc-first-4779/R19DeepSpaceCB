/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.LimeLightConstants;
import frc.robot.Robot;

public class LimeLightSetStreamingModeCommand extends Command {
  public LimeLightSetStreamingModeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limeLightSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    double streamingMode;
    streamingMode = NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").getDouble(0);
    if (streamingMode == 0){
      Robot.limeLightSubsystem.setStreamingMode(1);
      Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
      Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
    }
    else if (streamingMode == 1) {
      Robot.limeLightSubsystem.setStreamingMode(2);
      Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
      Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
    }
    else {
      Robot.limeLightSubsystem.setStreamingMode(0);
      Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
      Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
    }
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
