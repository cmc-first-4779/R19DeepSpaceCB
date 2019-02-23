/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.EventHorizon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.EventHorizonSubsystem;

public class EventHorizonCaptureCargoCommand extends Command {
  public EventHorizonCaptureCargoCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.eventHorizonSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //  Reset the Limit switch Counter
    Robot.eventHorizonSubsystem.initializeCounter();
    //   Put the Ball in the Box Boolean in the Smart Dashboard
    SmartDashboard.putBoolean("Do we have Cargo? ", Robot.eventHorizonSubsystem.isBallInBox());
    //  Put the EVENT HORIZON ARM MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON ARM MODE", "Lowered");
    //  Lower the Event Horizon Arm...
    Robot.eventHorizonSubsystem.lowerEventHorizonArm();    
    //  Put the EVENT HORIZON MOTOR MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON MOTOR MODE", "Started");
    //  Start our Event Horizon wheel motors
    Robot.eventHorizonSubsystem.startWheelMotor();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //   Put the Ball in the Box Boolean in the Smart Dashboard
    SmartDashboard.putBoolean("Do we have Cargo? ", Robot.eventHorizonSubsystem.isBallInBox());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //   The Command is finished when there is a ball in the box...  
    //      Detected by the Limit Switch in the Black Hole
    SmartDashboard.putBoolean("Do we have Cargo? ", Robot.eventHorizonSubsystem.isBallInBox());
    return Robot.eventHorizonSubsystem.isBallInBox();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Stop the Motor
    Robot.eventHorizonSubsystem.stopWheelMotor();
    //  Put the EVENT HORIZON MOTOR MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON MOTOR MODE", "Stop");
    //Set the Carry Mode to CARGO
    Robot.carryMode = RobotMap.CARRY_MODE_CARGO;
    //  Put the CarryMode into the Dashboard
    SmartDashboard.putNumber("Carry Mode", Robot.carryMode);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    // Stop the Motor
    Robot.eventHorizonSubsystem.stopWheelMotor();
    //  Put the EVENT HORIZON MOTOR MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON MOTOR MODE", "Stop");
    //  Raise the Event Horizon Arm and get it out of the way if there is an INTERRUPT!
    Robot.eventHorizonSubsystem.raiseEventHorizonArm();
    //  Put the EVENT HORIZON ARM MODE into the SmartDashboard
    SmartDashboard.putString("EVENT HORIZON ARM MODE", "Raised");

  }
}
