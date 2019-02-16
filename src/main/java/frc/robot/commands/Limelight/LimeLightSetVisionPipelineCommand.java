/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LimeLightSetVisionPipelineCommand extends Command {

  private int m_pipeline;

  public LimeLightSetVisionPipelineCommand(int pipeline) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limeLightSubsystem);
    m_pipeline = pipeline;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Set our pipeline...
    Robot.limeLightSubsystem.setPipeline(m_pipeline);
    //  Set the LED modes to the Pipeline default, just in case we have them forced one way or the other.
    Robot.limeLightSubsystem.setLEDMode(RobotMap.LIMELIGHT_LEDMODE_PIPELINE_DEFAULT);
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
