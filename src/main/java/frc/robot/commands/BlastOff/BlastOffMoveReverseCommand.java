/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlastOff;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BlastOffMoveReverseCommand extends Command {
  public BlastOffMoveReverseCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blastOffSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Set the amount of time for the BlastOff motor to run
    setTimeout(RobotMap.BLASTOFF_TIMEOUT);
    //  Put the BLASTOFF MOTOR MODE into the SmartDashboard
    SmartDashboard.putString("BLASTOFF MOTOR MODE", "Reverse");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.blastOffSubsystem.reverse();
    SmartDashboard.putNumber("Blastoff Encoder", Robot.blastOffSubsystem.encoder.getRaw());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.blastOffSubsystem.stopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.blastOffSubsystem.stopMotor();
  }
}
