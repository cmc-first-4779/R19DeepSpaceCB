/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WarpDrive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.PhaserConstants;

public class DriveJoystickCommand extends Command {
  public DriveJoystickCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.warpDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Set Phasers to Default
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Test message");
    Robot.warpDriveSubsystem.arcadeDrive(Robot.oi.getDriverStick().getY(), Robot.oi.getDriverStick().getX());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Robot.cindyDrive.cindyArcadeDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
