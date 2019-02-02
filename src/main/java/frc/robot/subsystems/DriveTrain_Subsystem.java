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
import com.kauailabs.navx.*;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoystick_Command;

/**
 * Add your docs here.
 */
public class DriveTrain_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Spark armMotor = new Spark(0);
  //Test Comment
  
  //DECLARE OUR TALONS
  WPI_TalonSRX leftMaster;
  WPI_TalonSRX rightMaster;
  //DECLARE OUR VICTORS 
  WPI_VictorSPX leftSlave;
  WPI_VictorSPX rightSlave;


  //DECLARE OUR DIFFERENTAL DRIVE
  DifferentialDrive myDrive = new DifferentialDrive(leftMaster, rightMaster);

  	//Declare  our DriveTrain Encoders
	private Encoder dTEncoderLeft;
	private Encoder dTEncoderRight;

  //DECLARE OUR NAV-X GYRO
  public AHRS gyro;

    //Declare the variable we are using to set the forward or backward direction of the robot for Auton Comamnd Groups.
	public int direction; //forward 1 or backward -1
	
	//The current distance we are trying to go.  Used for auton
	public double distance;
	
	//Declare the variable we are using for speed for our Auton Command Groups.
	private double speed;

public DriveTrain_Subsystem(){

  //INITIATE OUR TALONS
  leftMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_LEFT_FRONT_DRIVE);
  rightMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_RIGHT_FRONT_DRIVE);
  leftSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_LEFT_REAR_DRIVE);
  rightSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_RIGHT_REAR_DRIVE);

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

  //INITIATE OUR DRIVETRAIN ROTARY ENCODERS
  dTEncoderLeft = new Encoder (RobotMap.DIO_PORT_DTENCODER_LEFT_CHANNEL_A, RobotMap.DIO_PORT_DTENCODER_LEFT_CHANNEL_B);
  dTEncoderRight = new Encoder(RobotMap.DIO_PORT_DTENCODER_RIGHT_CHANNEL_A, RobotMap.DIO_PORT_DTENCODER_RIGHT_CHANNEL_B);

  //Initiate NAV-X GYRO
      /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
  gyro = new AHRS(SPI.Port.kMXP);



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
  }

  //RETURN THE GYRO OBJECT
  public AHRS getGyro() {
    return gyro;
  }

  public void resetGyro() {
    //This method exists so that our commands can call on the subsystem to reset the Gyro.
    //Usually, we call this each time we initialize a drivetrain command.
    System.out.println("Resetting NAV-X Gyro");
    gyro.reset();
  }

  public void stop() {
    //  If needed, we can stop the driveTrain by sending 0's to arcadeDrive.
    myDrive.arcadeDrive(0,0);
  }

  public void setSpeed (double speed) {
    //Set our Speed for y-axis arcade drive.
    //Gets called above.
       this.speed = speed;
  }
      
  public void setDirection(int dir) {
    //Set our Direction to either "1" for forward or "-1" for reverse.
    //Gets called above.
       this.direction = dir;
  }

  public void setDistance(int dis) {
  
    //Gets called above.
       this.distance = dis;
  }

  public void resetDTEncoders() {
    //Reset both of our rotary encoders.   We call this usually at the start of every drivetrain command.
      System.out.println("Resetting DriveTrain Encoders");
      dTEncoderLeft.reset();
      dTEncoderRight.reset();
  }
      
  public double getAvgEncoderPosition() {
    // We needed to add this to error check just in case one of our encoders is out of service due to
    // a bad connection or sliced wire.  These if/else commands make sure that each encoder is giving 
    // positive values >= 3 before performing an average.    If one of the encoders is < 3, then it will
    // only return a reading from the working encoder.
    if (Math.abs(dTEncoderLeft.getDistance()) < 3) {
      System.out.println("LEFT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return dTEncoderRight.getDistance();
    } 
    else if(Math.abs(dTEncoderRight.getDistance()) < 3) {
      System.out.println("RIGHT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return -dTEncoderLeft.getDistance();
    } 
    else {
    //Average our two rotary encoders together to account for slippage and turning.
    return (-dTEncoderLeft.getDistance() + dTEncoderRight.getDistance()) / 2;
    }
  }
      
  public double getLeftEncoderPosition() {
    //Get the Position of the Left encoder
    return dTEncoderLeft.getDistance();
  }
      
  public double getRightEncoderPosition() {
    //Get the Position of the Right encoder
    return dTEncoderRight.getDistance();
  }

}
