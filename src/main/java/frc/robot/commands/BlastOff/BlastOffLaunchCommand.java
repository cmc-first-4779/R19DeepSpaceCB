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

public class BlastOffLaunchCommand extends Command {
  public BlastOffLaunchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blastOffSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Put the BLASTOFF MODE into the SmartDashboard
    SmartDashboard.putString("BLASTOFF SOLENOID MODE", "LAUNCH!!!");
    //  Make sure the Wheel Motors are STOPPED  before moving the Solenoid Foot
    Robot.blastOffSubsystem.stopMotor();
    //  Configure the Arm so that it can bear the weight of the Robot and keep it balanced..
    Robot.armsSubsytem.configArmForBlastOff();
    //  Launch the Robot..   You must be close to the Platform and in Position!!!!!!!!
    Robot.blastOffSubsystem.launch();
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
