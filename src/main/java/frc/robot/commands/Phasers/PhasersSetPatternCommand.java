/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Phasers;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class PhasersSetPatternCommand extends Command {

  double m_pattern;

  public PhasersSetPatternCommand(double pattern) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.phasersSubsystem);
    m_pattern = pattern;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Set the Phasers Pattern.
    Robot.phasersSubsystem.setPhasers(m_pattern);
    //Put the Phasers Pattern Value to the Dashboard
    SmartDashboard.putNumber("Phasers Pattern", m_pattern);
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
