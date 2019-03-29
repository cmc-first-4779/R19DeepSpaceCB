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

public class BlastOffRetractLegsCommand extends Command {
  public BlastOffRetractLegsCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    setTimeout(1);
    requires(Robot.blastOffPIDSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Put the BLASTOFF MODE into the SmartDashboard
    SmartDashboard.putString("BLASTOFF MODE", "Retract");
    //  Make sure the Wheel Motors are STOPPED before moving the Solenoid Foot
    Robot.blastOffPIDSubsystem.enable();
    Robot.blastOffPIDSubsystem.setSetpoint(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT + 15);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Check the the PID loop to see if encoder is on target.
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.blastOffPIDSubsystem.disable();
    Robot.blastOffPIDSubsystem.legsOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
