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

public class BlastOffLaunchCommand extends Command {

  double leftStickYDeadZone = .25;

  public BlastOffLaunchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blastOffSubsystem);
    setTimeout(60);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        // Move the ARM with the OperStick
        double leftStickYAxis = -Robot.oi.getOperStick().getRawAxis(XBoxJoystickMap.LEFT_STICK_Y_AXIS);
        if (leftStickYAxis > leftStickYDeadZone ) {
        //  System.out.println("Increasing Height");
        Robot.blastOffSubsystem.wheelsSetMotor(leftStickYAxis);
        } else if (leftStickYAxis < -leftStickYDeadZone) {
        //  System.out.println("Decreasing Height");
          Robot.blastOffSubsystem.wheelsSetMotor(leftStickYAxis);
        } else {
          Robot.blastOffSubsystem.wheelsStopMotor();
          // do nothing, leave the arm height where it's at
        }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.blastOffSubsystem.wheelsStopMotor();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
