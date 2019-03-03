/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.BlackHole;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.XBoxJoystickMap;

public class BlackHoleRotateWithJoystickCommand extends Command {
  double rightStickYDeadZone = .25;
  double boxAngleIncrement = RobotMap.BLACK_HOLE_ANGLE_INCREMENT;


  public BlackHoleRotateWithJoystickCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.blackHoleSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //   Retract the plunger when the BlackHole Chill Command is initialized..
    Robot.blackHoleSubsystem.retractPlunger();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rightStickYAxis = -Robot.oi.getOperStick().getRawAxis(XBoxJoystickMap.RIGHT_STICK_Y_AXIS);
    if (rightStickYAxis > rightStickYDeadZone ) {
      System.out.println("Increasing Angle");
      Robot.blackHoleSubsystem.setBoxAngle(Robot.blackHoleSubsystem.getBoxAngle() + boxAngleIncrement);
      //SmartDashboard.putNumber("BlackHole Setpoint", Robot.blackHoleSubsystem.spinMotor.getSelectedSensorPosition());
    } else if (rightStickYAxis < -rightStickYDeadZone) {
      System.out.println("Decreasing Angle");
      Robot.blackHoleSubsystem.setBoxAngle(Robot.blackHoleSubsystem.getBoxAngle() - boxAngleIncrement);
    } else {
      // do nothing, leave the box angle where it's at
    }

    Robot.blackHoleSubsystem.rotateToSetPoint();
//    Robot.blackHoleSubsystem.stop();

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
