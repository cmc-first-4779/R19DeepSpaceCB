/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.PhaserConstants;
import frc.robot.Robot;

//  CHecks to see whether the Limelight has its target and flips the LEDs accordingly...

public class LimeLightHasTargetCommand extends Command {

  double m_hasTarget;

  public LimeLightHasTargetCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.limeLightSubsystem);
    requires(Robot.phasersSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_hasTarget = Robot.limeLightSubsystem.getTV();

    if (m_hasTarget == 0){
      // If..  NO TARGET
      Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_RED);
      // Put the Phasers Pattern Value to the Dashboard
      SmartDashboard.putNumber("Phasers Pattern", PhaserConstants.PHASERS_RED);
      //Output to the Dashboard whether the LimeLight has a target
      SmartDashboard.putString("LimeLight Has Target", "NO TARGET");
    }
      // Else it has a target and set the lights to LIME GREEN
    else{
      // Set the Phasers to Green
      Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_LIME);
      // Put the Phasers Pattern Value to the Dashboard
      SmartDashboard.putNumber("Phasers Pattern", PhaserConstants.PHASERS_LIME);
      // Output to the Dashboard whether the LimeLight has a target
      SmartDashboard.putString("LimeLight Has Target", "TARGET ACQUIRED");
    }

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
