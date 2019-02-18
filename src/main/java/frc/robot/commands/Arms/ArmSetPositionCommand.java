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

public class ArmSetPositionCommand extends Command {

  double m_setPostion;

  public ArmSetPositionCommand(double position) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.armsSubsytem);
    m_setPostion = position;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {    
    Robot.armsSubsytem.setSetPoint(m_setPostion);
    // Put the Arm Subsystem SetPoint into the Dashboard
    SmartDashboard.putNumber("ARM SetPoint", m_setPostion);
    // Put the Arm Control Mode into the Dashboard
    SmartDashboard.putString("ARM Mode", "AUTO");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //System.out.println("Arm Encoder position: " + Robot.armsSubsytem.getEncoderPosition());
    //Put the Arm Encoder Position into the Dashboard
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
