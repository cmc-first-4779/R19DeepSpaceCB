/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.LimeLightConstants;
import frc.robot.Robot;

public class LimeLightSetCameraModeCommand extends Command {

  double m_cameraMode;

  public LimeLightSetCameraModeCommand(double cameraMode) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limeLightSubsystem);
    m_cameraMode = cameraMode;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //   Set the Camera Mode on the Limelight so that the Driver can use it
    Robot.limeLightSubsystem.setCameraMode(m_cameraMode);
    //   Set the LED Mode to OFF since the driver is driving...
    if (m_cameraMode == LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER) {
      //Turn the LEDs Off
      Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_OFF);
      //  Put the Camera Mode in the Dashboard
      SmartDashboard.putString("LIMELIGHT CAMERA MODE", "Driver");
      //  Put the LED Mode in the Dashboard
      SmartDashboard.putString("LIMELIGHT LED MODE", "Off");
    }
    else {
      // Turn the LEDs On
      Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
      //  Put the Camera Mode in the Dashboard
      SmartDashboard.putString("LIMELIGHT CAMERA MODE", "Vision");
      //  Put the LED Mode in the Dashboard
      SmartDashboard.putString("LIMELIGHT LED MODE", "On");
    }
    

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
