/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WarpDrive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnToAngle extends Command {
  double angle;
  boolean isFinished = false;
  boolean inErrorZone = false;
  int count = 0;
  int printCount = 0;

  public TurnToAngle(double angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    System.out.println("In Constructor");
    requires(Robot.warpDriveSubsystem);
    this.angle = angle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.warpDriveSubsystem.rotateDegrees(angle);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double error = Robot.warpDriveSubsystem.turnController.getError();
    inErrorZone = Math.abs(error) < 5;
    System.out.println("Count: " + count);
    if(inErrorZone) {
      count++;
      if (count > 5 ){
              isFinished = true;
              count = 0;
      }
    } else {
      count = 0;
    }

  
    if(printCount++ > 0 ) {
      System.out.println("Error: " + error);
      printCount = 0;
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Ending TurnToAngle");
    isFinished = false;
    Robot.warpDriveSubsystem.turnController.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
