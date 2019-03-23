/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlackHole;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class BlackHoleBoomCommand extends Command {
  public BlackHoleBoomCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blackHoleSubsystem);
    setTimeout(RobotMap.BLACKHOLE_BOOM_TIMER);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  // Put the BLACKHOLE BOOMSTICK STATUS into the Dashboard
  SmartDashboard.putString("BLACKHOLE BOOMSTICK Status", "BOOM");
  //  Activate the BOOMSTICK to tip the BlackHole!!
  Robot.blackHoleSubsystem.boom();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  //  UNBOOM after time is up
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.blackHoleSubsystem.unBoom();    //UN-BOOM 
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.blackHoleSubsystem.unBoom();    //UN-BOOM 
  }
}
