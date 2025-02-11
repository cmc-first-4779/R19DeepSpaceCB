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
import frc.robot.RobotMap;
import frc.robot.XBoxJoystickMap;

public class ArmsMoveWithJoystickCommand extends Command {

  double leftStickYDeadZone = RobotMap.ARM_LEFTSTICK_Y_DEAD_ZONE;
  double newArmHeight = 0;

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
  // Move the ARM using the Oper Joystick Y-axis
  @Override
  protected void execute() {
    // Frist check to see if the fwd limit switch has been triggered. If it has, we
    // need to reverse the motors.
    if (!Robot.armsSubsytem.isLimitSwitchTriggered()) {
      double leftStickYAxis = -Robot.oi.getOperStick().getRawAxis(XBoxJoystickMap.LEFT_STICK_Y_AXIS);
      if (leftStickYAxis > leftStickYDeadZone) {
        // System.out.println("Increasing Height");
        newArmHeight = Robot.armsSubsytem.getArmHeight() + RobotMap.ARM_HEIGHT_UP_INCREMENT;
        Robot.armsSubsytem.setArmHeight(newArmHeight);
         Robot.blackHoleSubsystem.setBoxAngle((newArmHeight/RobotMap.ARM_MAX_HEIGHT *
         RobotMap.BLACK_HOLE_MAX_NEGATIVE_ANGLE)+15);
      } else if (leftStickYAxis < -leftStickYDeadZone) {
        // System.out.println("Decreasing Height");
        newArmHeight = Robot.armsSubsytem.getArmHeight() - RobotMap.ARM_HEIGHT_DOWN_INCREMENT;
        Robot.armsSubsytem.setArmHeight(newArmHeight);
         Robot.blackHoleSubsystem.setBoxAngle((newArmHeight/RobotMap.ARM_MAX_HEIGHT *
         RobotMap.BLACK_HOLE_MAX_NEGATIVE_ANGLE)+15);
      } else {
        // do nothing, leave the arm height where it's at
      }

      Robot.armsSubsytem.setSetPoint();
      // Put the Arm Encoder Position into the Dashboard
      SmartDashboard.putNumber("ARM Position", Robot.armsSubsytem.getEncoderPosition());
    } else {
      // Limit switch is triggered, so we are going to set a lower setpoint and reverse
      // the motors. If our encoder is lower, then we probably lost the sensor feed
      // and will need to go into defense mode.
      if (Robot.armsSubsytem.getEncoderPosition() > RobotMap.ARM_ENCODER_POSITION_SAFTY_LIMIT) {
        //Assume that we still have good sensor feed.  
      Robot.armsSubsytem.setArmHeight(RobotMap.ARM_FWD_LIMIT_EMERGENCY_POSITION);
      Robot.armsSubsytem.moveArm(RobotMap.ARM_LOWER_SPEED);
      } else {
        //Probably lost sensor feed and need to disable being able to raise arms.
        Robot.armsSubsytem.switchToDefenseMode();
        
      }
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
