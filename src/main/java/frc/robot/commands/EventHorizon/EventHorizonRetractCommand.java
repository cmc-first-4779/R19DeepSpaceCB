/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.EventHorizon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class EventHorizonRetractCommand extends Command {
  public EventHorizonRetractCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.eventHorizonSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Retract the Event Horizon System
    Robot.eventHorizonSubsystem.retractEventHorizon();
    //  Put the EVENT HORIZON MOTOR MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON MOTOR MODE", "Stop");
    //  Put the EVENT HORIZON ARM MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON ARM MODE", "Raised");
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
