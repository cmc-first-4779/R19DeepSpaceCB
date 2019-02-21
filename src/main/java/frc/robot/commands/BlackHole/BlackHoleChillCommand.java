/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlackHole;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BlackHoleChillCommand extends Command {
  double rightStickYDeadZone = .25;
  double boxAngleIncrement = 100;


  public BlackHoleChillCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blackHoleSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rightStickYAxis = -Robot.oi.getOperStick().getRawAxis(5);
    System.out.println("Right Stick: " + rightStickYAxis);
    if (rightStickYAxis > rightStickYDeadZone ) {
      System.out.println("Increasing Angle");
      Robot.blackHoleSubsystem.setBoxAngle(Robot.blackHoleSubsystem.getBoxAngle() + boxAngleIncrement);
    } else if (rightStickYAxis < -rightStickYDeadZone) {
      System.out.println("Decreasing Angle");
      Robot.blackHoleSubsystem.setBoxAngle(Robot.blackHoleSubsystem.getBoxAngle() - boxAngleIncrement);
    } else {
      // do nothing, leave the box angle where it's at
    }

    Robot.blackHoleSubsystem.rotateToSetPoint();
//    Robot.blackHoleSubsystem.stop();
    Robot.blackHoleSubsystem.retractPlunger();
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
