/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WarpDrive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.LimeLightConstants;
import frc.robot.PhaserConstants;
import frc.robot.Robot;
import frc.robot.XBoxJoystickMap;

public class DriveLimeLightCommand extends Command {

  public DriveLimeLightCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.warpDriveSubsystem);
    requires(Robot.limeLightSubsystem);
  }

  double tx;  // Declare TX

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limeLightSubsystem.setPipeline(0);
    Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_VISION);
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
    Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_LIME);
    tx = Robot.limeLightSubsystem.getTX();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    tx = Robot.limeLightSubsystem.getTX();
    Robot.warpDriveSubsystem.arcadeDrive(Robot.oi.getDriverStick().getRawAxis(XBoxJoystickMap.LEFT_STICK_Y_AXIS), tx);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_OFF);
    Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_DEFAULT);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_OFF);
    Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_DEFAULT);
  }
}
