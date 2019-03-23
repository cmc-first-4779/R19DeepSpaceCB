/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.PhaserConstants;

public class LimeLightSeekAndFollowCommand extends Command {
  double pAim = .025;
  double pDistance = .05;
  double minimalAimCommand = .15; // This is the minimal amount that it would take to start turning the bot
  double minimalMoveCommand = .25; // This is the minimal amount that it would take to start turning the bot

  boolean aimAndMove = false;
  double turn = 0;
  double move = 0;

  double m_pipeline;

  public LimeLightSeekAndFollowCommand(double pipeline) {
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
      requires(Robot.warpDriveSubsystem);
      requires(Robot.limeLightSubsystem);
      m_pipeline = pipeline;
    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
      // need to set the limelight pipeline
      Robot.limeLightSubsystem.setPipeline(m_pipeline);
      //  Put the LIMELIGHT PIPELINE VALUE ON THE DASHBOARD
      SmartDashboard.putNumber("LIMELIGHT PIPELINE", m_pipeline);
      //Set Phasers to Lime green to tell the driver that the Limelight is driving.
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      /*
       * First check to see if there is a target, if not turn Then make sure we are on
       * target Then make sure we are the proper distance from target
       */
  
      boolean hasTarget = Robot.limeLightSubsystem.hasTarget();
  
      if (hasTarget) {
        // Output to the Dashboard whether the LimeLight has a target
        SmartDashboard.putString("LimeLight Has Target", "TARGET ACQUIRED");
        turn = calculateTurn();
        if (aimAndMove) {
          move = calculateMove();
        } else { // only want to move if we are on target already
          if (turn == 0) {
            move = calculateMove();
          }
        }
      } 
      else {
        //Output to the Dashboard whether the LimeLight has a target
        SmartDashboard.putString("LimeLight Has Target", "NO TARGET");        
        move = 0;
        turn = RobotMap.LIMELIGHT_SEEK_TURN_POWER;
      }
  
      Robot.warpDriveSubsystem.arcadeDrive(move, turn);
      }
  
    /**
     * Calculates how much to turn. Get's how far off in the x-axis we are from limelight.  If we are within acceptable range, then it
     * returns 0.
     * @return the amount to turn
     */
    private double calculateTurn() {
      double aim_error = Robot.limeLightSubsystem.getTX();
      if (aim_error > RobotMap.LIMELIGHT_DRIVETRAIN_AIM_TOLERANCE) {
        turn = (pAim * aim_error) + minimalAimCommand;
      } else if (aim_error < -RobotMap.LIMELIGHT_DRIVETRAIN_AIM_TOLERANCE) {
        turn = (pAim * aim_error) - minimalAimCommand;
      } else {
        turn = 0;
      }
      return turn;
    }
  
    /**
     * Calculates the amount to drive.  Get's how far away we are from target based on x-axis from limelight.  If we are within acceptable range, 
     * then it returns 0
     * @return
     */
    private double calculateMove() {
        double distance_error = Robot.limeLightSubsystem.getTY();
      if (distance_error > RobotMap.LIMELIGHT_DRIVETRAIN_DISTANCE_TOLERANCE) {
        move = (pDistance * distance_error) + minimalMoveCommand;
      } else if (distance_error < -RobotMap.LIMELIGHT_DRIVETRAIN_DISTANCE_TOLERANCE) {
        move = (pDistance * distance_error) - minimalMoveCommand;
      } else {
        move = 0;
      }
      return move;
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