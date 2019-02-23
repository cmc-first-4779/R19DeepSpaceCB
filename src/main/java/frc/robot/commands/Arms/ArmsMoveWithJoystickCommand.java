/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Arms;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class ArmsMoveWithJoystickCommand extends Command {
  double leftStickYDeadZone = .25;
  double armHeightIncrement = 50;

  public ArmsMoveWithJoystickCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.armsSubsytem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Put the Arm Control Mode into the Dashboard
    SmartDashboard.putString("ARM Mode", "JOYSTICK");
  }

  // Called repeatedly when this Command is scheduled to run
  //Move the ARM using the Oper Joystick Y-axis
  @Override
  protected void execute() {
    // Move the ARM with the OperStick
    double leftStickYAxis = -Robot.oi.getOperStick().getRawAxis(1);
    if (leftStickYAxis > armHeightIncrement ) {
      System.out.println("Increasing Height");
      Robot.armsSubsytem.setArmHeight(Robot.armsSubsytem.getArmHeight() + armHeightIncrement);
    } else if (leftStickYAxis < -leftStickYDeadZone) {
      System.out.println("Decreasing Height");
      Robot.armsSubsytem.setArmHeight(Robot.armsSubsytem.getArmHeight() - armHeightIncrement);
    } else {
      // do nothing, leave the arm height where it's at
    }

    Robot.armsSubsytem.setSetPoint();
    // Put the Arm Encoder Position into the Dashboard
    SmartDashboard.putNumber("ARM Position", Robot.armsSubsytem.getEncoderPosition());
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
