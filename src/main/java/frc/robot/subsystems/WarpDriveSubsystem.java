/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;
//


/**
 * Add your docs here.
 */
public class WarpDriveSubsystem extends Subsystem implements PIDOutput {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // DECLARE OUR TALONS
  Spark frontLeftDrive;
  Spark frontRightDrive;
  // DECLARE OUR VICTORS
  Spark rearLeftDrive;
  Spark rearRightDrive;

  // DECLARE OUR DIFFERENTAL DRIVE
  DifferentialDrive myDrive;

  // DECLARE OUR NAV-X GYRO
  public AHRS gyro;

  // Declare the variable we are using to set the forward or backward direction of
  // the robot for Auton Comamnd Groups.
  public int direction; // forward 1 or backward -1

  // The current distance we are trying to go. Used for auton
  public double distance;

  // Declare the variable we are using for speed for our Auton Command Groups.
  private double speed;

  // PIDController to handle turning
  public final PIDController turnController;

  // PID Tuning values
  private final double kP = 0.025;
  private final double kI = 0;
  private final double kD = 0;

  /**
   * Default constructor for the DriveTrainSubsytem. We will create our motor
   * controlers and sensors in here and configure them for how they need to be
   * used in this subsystem
   */
  public WarpDriveSubsystem() {

    // INITIATE OUR TALONS
    frontLeftDrive = new Spark(0);
    frontRightDrive = new Spark(1);
    rearLeftDrive = new Spark(2);
    rearRightDrive = new Spark(3);

    // Init the talons
    //Robot.initMotorController(leftMaster);
    //Robot.initMotorController(rightMaster);
    //Robot.initMotorController(leftSlave);
    //Robot.initMotorController(rightSlave);

    // SLAVE OUR REAR MOTORS TO OUR FRONT MASTER MOTORS
    //leftSlave.follow(leftMaster);
    //rightSlave.follow(rightMaster);

    // IN CASE WE HAVE TO INVERT ANY MOTORS
    frontLeftDrive.setInverted(false);
    rearLeftDrive.setInverted(false);
    frontRightDrive.setInverted(false);
    rearRightDrive.setInverted(false);

    SpeedControllerGroup myDriveLeft = new SpeedControllerGroup(frontLeftDrive, rearLeftDrive);
    SpeedControllerGroup myDriveRight = new SpeedControllerGroup(frontRightDrive, rearRightDrive);

    myDrive = new DifferentialDrive(myDriveLeft, myDriveRight);

    // Initiate NAV-X GYRO
    /* Communicate w/navX-MXP via the MXP SPI Bus. */
    /* Alternatively: I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB */
    /*
     * See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for
     * details.
     */
    gyro = new AHRS(SPI.Port.kMXP);

    // Instantiate our turn controller
    turnController = new PIDController(kP, kI, kD, gyro, this);
    turnController.setInputRange(-180.0, 180.0);
    turnController.setOutputRange(-45.0, 45.0);
    turnController.setAbsoluteTolerance(2.0);
    turnController.setContinuous();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // DEFAULT COMMAND FOR DRIVETRAND IS TO DRIVE THE JOYSTICK.
    setDefaultCommand(new DriveJoystickCommand());
  }

  // Our Arcade drive method
  public void arcadeDrive(double move, double turn) {
    // System.out.println("move: " + move + " turn: " + turn);
    myDrive.arcadeDrive(-move, turn);
  }

  // RETURN THE GYRO OBJECT
  public AHRS getGyro() {
    return gyro;
  }

  public void resetGyro() {
    // This method exists so that our commands can call on the subsystem to reset
    // the Gyro.
    // Usually, we call this each time we initialize a drivetrain command.
    System.out.println("Resetting NAV-X Gyro");
    gyro.reset();
  }

  public void stop() {
    // If needed, we can stop the driveTrain by sending 0's to arcadeDrive.
    // myDrive.arcadeDrive(0,0);
  }

  public void setSpeed(double speed) {
    // Set our Speed for y-axis arcade drive.
    // Gets called above.
    this.speed = speed;
  }

  public void setDirection(int dir) {
    // Set our Direction to either "1" for forward or "-1" for reverse.
    // Gets called above.
    this.direction = dir;
  }

  public void setDistance(int dis) {
    // Gets called above.
    this.distance = dis;
  }

  public void moveMotor(int pwmPort) {
    switch (pwmPort) {
      case 0:
      rearRightDrive.set(.50);
      break;
      case 1:
      rearLeftDrive.set(.50);
      break;
      case 2:
      frontRightDrive.set(.50);
      break;
      case 3:
      frontLeftDrive.set(.5);
      
    }
  }

  public void setSetPoint(double distance) {
    // do the math to figure out what the encoder count should be
    // Drive Robot to set point
    //leftMaster.set(ControlMode.Position, distance);
    //rightMaster.set(ControlMode.Position, distance);
    
    //System.out.println("Left DT Encoder count: " + leftMaster.getSelectedSensorPosition());
    //System.out.println("Right DT Encoder count: " + rightMaster.getSelectedSensorPosition());
  }

  //Reset the encoders on our drive Talon.
  public void resetEncoders() {
    //leftMaster.setSelectedSensorPosition(0);
   //rightMaster.setSelectedSensorPosition(0);
  }

  public double getGyroAngle(){
    return Robot.warpDriveSubsystem.gyro.getAngle();
  }
  
  public double getEncoderPosition() {
    // We needed to add this to error check just in case one of our encoders is out
    // of service due to a bad connection or sliced wire. These if/else commands make sure that each
    // encoder is giving positive values >= 3 before performing an average. If one of the encoders is
    // < 3, then it will only return a reading from the working encoder.
    //if (Math.abs(leftMaster.getSelectedSensorPosition()) < 3) {
      /* System.out.println("LEFT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return rightMaster.getSelectedSensorPosition();
    } else if (Math.abs(rightMaster.getSelectedSensorPosition()) < 3) {
      System.out.println("RIGHT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return -leftMaster.getSelectedSensorPosition() ;
    } else {
      // Average our two rotary encoders together to account for slippage and turning.
      return (-leftMaster.getSelectedSensorPosition() + rightMaster.getSelectedSensorPosition()) / 2;
    } */
    double Cindy=0;
    return Cindy;
  }

  public void rotateDegrees(double angle) {
    System.out.println("got in to rotate");
    gyro.reset();
    turnController.reset();
    turnController.setPID(kP, kI, kD);
    System.out.println("Angle: " + angle);
    turnController.setSetpoint(angle);
    turnController.enable();
  }

  @Override
  public void pidWrite(double output) {
    System.out.println("In pidWrite output: " + output);
    // set(ControlMode.PercentOutput, -output, output);
    arcadeDrive(0, output);
  }

  public void setAutoSpeed(double speed){
    double m_speed = speed;
    Robot.warpDriveSubsystem.frontLeftDrive.set(m_speed);
    Robot.warpDriveSubsystem.frontRightDrive.set(m_speed);
  }

	/* Zero all sensors used */
	void zeroSensors() {
    int kTimeoutMs = 30;
	//	leftMaster.getSensorCollection().setQuadraturePosition(0, kTimeoutMs);
	//	rightMaster.getSensorCollection().setQuadraturePosition(0, kTimeoutMs);
		System.out.println("[Quadrature Encoders] All sensors are zeroed.\n");
  }
  
  //  Turn left just a little using the bumper button
  public void adjustLeftTurn(){
    rotateDegrees(-RobotMap.WARPDRIVE_BUMPER_TURN_INCREMENT);
  }

  //  Turn right just a little using the bumper button
  public void adjustRightTurn(){
    rotateDegrees(RobotMap.WARPDRIVE_BUMPER_TURN_INCREMENT);
  }
}
