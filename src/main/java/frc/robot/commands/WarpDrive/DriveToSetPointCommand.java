/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WarpDrive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveToSetPointCommand extends Command {

  private int m_direction;  // 1 = forward, -1 = reverse
  private int m_distance;
  private double m_speed;


  public DriveToSetPointCommand(int distance, int direction, double speed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.warpDriveSubsystem);
    m_distance = distance;
    m_direction = direction;
    m_speed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Reset our Gyro and Encoders
    Robot.warpDriveSubsystem.resetGyro();
    Robot.warpDriveSubsystem.resetEncoders();
    // Set the speed of the robot
    Robot.warpDriveSubsystem.setSpeed(m_speed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //multiple the distance by the direction to determine whether we are moving forward or reverse
    Robot.warpDriveSubsystem.setSetPoint(m_distance*m_direction);
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
