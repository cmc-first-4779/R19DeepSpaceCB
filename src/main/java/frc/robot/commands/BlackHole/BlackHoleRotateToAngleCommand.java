/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlackHole;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BlackHoleRotateToAngleCommand extends Command {

  private double angle;

  public BlackHoleRotateToAngleCommand(double angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.angle = angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Put the BLACKHOLE Control Mode into the Dashboard
    SmartDashboard.putString("BLACKHOLE Control Mode", "BlackHoleRotateToAngle");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.blackHoleSubsystem.setBoxAngle(angle);
    // Put the BLACKHOLE Encoder Position into the Dashboard
    SmartDashboard.putNumber("BLACKHOLE Encoder Position", Robot.blackHoleSubsystem.getEncoderPosition());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
