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

public class EventHorizonLowerArmCommand extends Command {
  public EventHorizonLowerArmCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.eventHorizonSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Put the EVENT HORIZON ARM MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON ARM MODE", "Lowered");
    Robot.blackHoleSubsystem.setBoxAngle(0);  //Set Box Angle to zero before lowering arm.
    
    //  Lower the Event Horizon Arm
    Robot.eventHorizonSubsystem.lowerEventHorizonArm();
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
