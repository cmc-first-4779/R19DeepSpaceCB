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

public class LimelightSetCameraModeVisionCommand extends Command {
  public LimelightSetCameraModeVisionCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limeLightSubsystem);
    requires(Robot.phasersSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
        //   Set the Camera Mode on the Limelight so that the Driver can use it
        Robot.limeLightSubsystem.setCameraMode(RobotMap.LIMELIGHT_CAMMODE_VISION);
        //   Set the LED MODE to ON so that we can see the reflective tape.
        Robot.limeLightSubsystem.setLEDMode(RobotMap.LIMELIGHT_LEDMODE_ON);
        //   Since the Vision Mode is not on, set the Phasers to our Defualt
        Robot.phasersSubsystem.setPhasers(RobotMap.PHASERS_LIME);
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
