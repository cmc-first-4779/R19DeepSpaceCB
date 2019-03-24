/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlastOffWheels;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.XBoxJoystickMap;

public class BlastOffWheelsJoystickCommand extends Command {
  public BlastOffWheelsJoystickCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.liftWheelsSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Move the Blastoff wheels using the Operstick Left Stick Y-Axis
    Robot.liftWheelsSubsystem.wheelsSetMotor(Robot.oi.getOperStick().getRawAxis(XBoxJoystickMap.LEFT_STICK_Y_AXIS));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.liftWheelsSubsystem.wheelsStopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.liftWheelsSubsystem.wheelsStopMotor();
  }
}
