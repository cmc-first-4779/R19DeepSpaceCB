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
import frc.robot.XBoxJoystickMap;

public class BlastOffJoystickCommand extends Command {
  public BlastOffJoystickCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blastOffPIDSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.blastOffPIDSubsystem.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Move the legs up and down using the OperStick Right Joystick Y axis
    System.out.println("BlastOffEncoder: " + Robot.blastOffPIDSubsystem.getDistance());
    Robot.blastOffPIDSubsystem.legsMotorsMove(Robot.oi.getOperStick().getRawAxis(XBoxJoystickMap.RIGHT_STICK_Y_AXIS));
    SmartDashboard.putNumber("BlastOff Encoder", Robot.blastOffPIDSubsystem.getDistance());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.blastOffWheelsSubsystem.wheelsStopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.blastOffWheelsSubsystem.wheelsStopMotor();
  }
}
