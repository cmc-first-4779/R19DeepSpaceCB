/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.NoseCone;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

//Open our Nosecone for handling our Hatchcovers...

public class NoseConeCloseCommand extends Command {
  public NoseConeCloseCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.noseConeSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Close the NOSECONE..
    Robot.noseConeSubsystem.closeNoseCone();
    //Set the Carry Mode to None
    Robot.carryMode = RobotMap.CARRY_MODE_NONE;
    //  Put the NOSECONE Mode into the SmartDashboard
    SmartDashboard.putString("NOSECONE MODE", "Closed");
    //  Put the CarryMode into the Dashboard
    SmartDashboard.putNumber("Carry Mode", Robot.carryMode);
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
