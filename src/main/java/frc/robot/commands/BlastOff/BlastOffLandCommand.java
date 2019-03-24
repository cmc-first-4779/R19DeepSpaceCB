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

public class BlastOffLandCommand extends Command {
  public BlastOffLandCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blastOffPIDSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Put the BLASTOFF MODE into the SmartDashboard
    SmartDashboard.putString("BLASTOFF MODE", "LAND");
    //  Make sure the Wheel Motors are STOPPED before moving the Solenoid Foot
    Robot.blastOffPIDSubsystem.land();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Check the the PID loop to see if encoder is on target.
    return Robot.blastOffPIDSubsystem.onTarget();
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
