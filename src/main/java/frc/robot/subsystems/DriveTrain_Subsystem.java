/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTrain.DriveJoystick_Command;

/**
 * Add your docs here.
 */
public class DriveTrain_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Spark armMotor = new Spark(0);
  //Test Comment
  
  //DECLARE OUR TALONS AS MASTERS
  WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_LEFT_FRONT_DRIVE);
  WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_RIGHT_FRONT_DRIVE);
  //DECLARE OUR VICTORS AS SLAVES
  WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_LEFT_REAR_DRIVE);
  WPI_VictorSPX rightSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_RIGHT_REAR_DRIVE);
  //WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_LEFT_REAR_DRIVE);
  //WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_RIGHT_REAR_DRIVE);

  //DECLARE OUR DIFFERENTAL DRIVE
  DifferentialDrive myDrive = new DifferentialDrive(leftMaster, rightMaster);

public DriveTrain_Subsystem(){

  //SLAVE OUR REAR MOTORS TO OUR FRONT MASTER MOTORS
  leftSlave.follow(leftMaster);
  rightSlave.follow(rightMaster);

  //SET OUR FACTORY DEFAULTS ON ALL TALONS AND VICTORS
  leftMaster.configFactoryDefault();
  leftSlave.configFactoryDefault();
  rightMaster.configFactoryDefault();
  rightSlave.configFactoryDefault();

  //IN CASE WE HAVE TO INVERT ANY MOTORS
  leftMaster.setInverted(false);
  leftSlave.setInverted(false);
  rightMaster.setInverted(false);
  rightSlave.setInverted(false);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  //DEFAULT COMMAND FOR DRIVETRAND IS TO DRIVE THE JOYSTICK.
  setDefaultCommand(new DriveJoystick_Command());
  }

  //Our Arcade drive method  
  public void arcadeDrive(double move, double turn) {
    myDrive.arcadeDrive(-move, turn);
   //leftSlave.set(.8);
  }

}
