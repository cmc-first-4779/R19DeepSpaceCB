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
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.WarpDrive.DriveJoystickCommand;
//
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.Gains;

/**
 * Add your docs here.
 */
public class WarpDriveSubsystem extends Subsystem implements PIDOutput {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // DECLARE OUR TALONS
  WPI_TalonSRX leftMaster;
  WPI_TalonSRX rightMaster;
  // DECLARE OUR VICTORS
  WPI_VictorSPX leftSlave;
  WPI_VictorSPX rightSlave;

  // DECLARE OUR DIFFERENTAL DRIVE
  DifferentialDrive myDrive;

  // Declare our DriveTrain Encoders
//  private Encoder driveTrainEncoderLeft;
 // private Encoder driveTrainEncoderRight;

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
    leftMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_LEFT_FRONT_DRIVE);
    rightMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_RIGHT_FRONT_DRIVE);
    leftSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_LEFT_REAR_DRIVE);
    rightSlave = new WPI_VictorSPX(RobotMap.CAN_ADDRESS_RIGHT_REAR_DRIVE);

    // Init the talons
    Robot.initMotorController(leftMaster);
    Robot.initMotorController(rightMaster);
    Robot.initMotorController(leftSlave);
    Robot.initMotorController(rightSlave);

    // SLAVE OUR REAR MOTORS TO OUR FRONT MASTER MOTORS
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    // IN CASE WE HAVE TO INVERT ANY MOTORS
    leftMaster.setInverted(false);
    leftSlave.setInverted(false);
    rightMaster.setInverted(false);
    rightSlave.setInverted(false);

    myDrive = new DifferentialDrive(leftMaster, rightMaster);

    // INITIATE OUR DRIVETRAIN ROTARY ENCODERS
    //driveTrainEncoderLeft = new Encoder(RobotMap.DIO_PORT_DTENCODER_LEFT_CHANNEL_A,
      //  RobotMap.DIO_PORT_DTENCODER_LEFT_CHANNEL_B);
    //driveTrainEncoderRight = new Encoder(RobotMap.DIO_PORT_DTENCODER_RIGHT_CHANNEL_A,
      //  RobotMap.DIO_PORT_DTENCODER_RIGHT_CHANNEL_B);

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

  public void setSetPoint(double distance) {
    // do the math to figure out what the encoder count should be
    // Drive Robot to set point
    leftMaster.set(ControlMode.Position, distance);
    rightMaster.set(ControlMode.Position, distance);
    
    //System.out.println("Left DT Encoder count: " + leftMaster.getSelectedSensorPosition());
    //System.out.println("Right DT Encoder count: " + rightMaster.getSelectedSensorPosition());
  }

  //Reset the encoder on our Arm Master Talon.
  public void resetEncoders() {
    leftMaster.setSelectedSensorPosition(0);
    rightMaster.setSelectedSensorPosition(0);
  }

  public double getGyroAngle(){
    return Robot.warpDriveSubsystem.gyro.getAngle();
  }
  
  public double getEncoderPosition() {
    // We needed to add this to error check just in case one of our encoders is out
    // of service due to a bad connection or sliced wire. These if/else commands make sure that each
    // encoder is giving positive values >= 3 before performing an average. If one of the encoders is
    // < 3, then it will only return a reading from the working encoder.
    if (Math.abs(leftMaster.getSelectedSensorPosition()) < 3) {
      System.out.println("LEFT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return rightMaster.getSelectedSensorPosition();
    } else if (Math.abs(rightMaster.getSelectedSensorPosition()) < 3) {
      System.out.println("RIGHT DRIVETRAIN ENCODER IS NOT WORKING!!!");
      return -leftMaster.getSelectedSensorPosition() ;
    } else {
      // Average our two rotary encoders together to account for slippage and turning.
      return (-leftMaster.getSelectedSensorPosition() + rightMaster.getSelectedSensorPosition()) / 2;
    }
  }



  public void set(ControlMode mode, double leftValue, double rightValue) {
    leftMaster.set(mode, leftValue);
    rightMaster.set(mode, rightValue);
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
    Robot.warpDriveSubsystem.leftMaster.set(m_speed);
    Robot.warpDriveSubsystem.rightMaster.set(m_speed);
  }

  public void driveStraight(){
    /**
	 * Using the configSelectedFeedbackCoefficient() function, scale units to 3600 per rotation.
	 * This is nice as it keeps 0.1 degrees of resolution, and is fairly intuitive.
	 */
	  double kTurnTravelUnitsPerRotation = 3600;  //Placeholder
	
	/**
	 * Empirically measure what the difference between encoders per 360'
	 * Drive the robot in clockwise rotations and measure the units per rotation.
	 * Drive the robot in counter clockwise rotations and measure the units per rotation.
	 * Take the average of the two.
	 */
	  int kEncoderUnitsPerRotation = 51711;  //placeholder

	/**
	 * Set to zero to skip waiting for confirmation.
	 * Set to nonzero to wait and report to DS if action fails.
	 */
	  int kTimeoutMs = 30;

	/**
	 * Motor neutral dead-band, set to the minimum 0.1%.
	 */
	  double kNeutralDeadband = 0.001;
	
	/**
	 * PID Gains may have to be adjusted based on the responsiveness of control loop.
     * kF: 1023 represents output value to Talon at 100%, 6800 represents Velocity units at 100% output
     * Not all set of Gains are used in this project and may be removed as desired.
     * 
	 * 	                                 P   kI    kD   kF              Iz    PeakOut */
	  Gains kGains_Distanc = new Gains( 0.1, 0.0,  0.0, 0.0,            100,  0.50 );
	  Gains kGains_Turning = new Gains( 2.0, 0.0,  4.0, 0.0,            200,  1.00 );
	  Gains kGains_Velocit = new Gains( 0.1, 0.0, 20.0, 1023.0/6800.0,  300,  0.50 );
	  Gains kGains_MotProf = new Gains( 1.0, 0.0,  0.0, 1023.0/6800.0,  400,  1.00 );
	
	/** ---- Flat constants, you should not need to change these ---- */
	/* We allow either a 0 or 1 when selecting an ordinal for remote devices [You can have up to 2 devices assigned remotely to a talon/victor] */
	  int REMOTE_0 = 0;
	  int REMOTE_1 = 1;
	/* We allow either a 0 or 1 when selecting a PID Index, where 0 is primary and 1 is auxiliary */
	  int PID_PRIMARY = 0;
	  int PID_TURN = 1;
	/* Firmware currently supports slots [0, 3] and can be used for either PID Set */
	  int SLOT_0 = 0;
	  int SLOT_1 = 1;
	  int SLOT_2 = 2;
	  int SLOT_3 = 3;
	/* ---- Named slots, used to clarify code ---- */
	  int kSlot_Distanc = SLOT_0;
	  int kSlot_Turning = SLOT_1;
	  int kSlot_Velocit = SLOT_2;
    int kSlot_MotProf = SLOT_3;
    
    		/** Closed loop configuration */
		
		/* Configure the drivetrain's left side Feedback Sensor as a Quadrature Encoder */
    /*
    leftMaster.configSelectedFeedbackSensor(	FeedbackDevice.QuadEncoder,			// Local Feedback Source
    PID_PRIMARY,				// PID Slot for Source [0, 1]
    kTimeoutMs);				// Configuration Timeout
    */

/* Configure the left Talon's Selected Sensor to be a remote sensor for the right Talon */
  rightMaster.configRemoteFeedbackFilter(leftMaster.getDeviceID(),					// Device ID of Source
    RemoteSensorSource.TalonSRX_SelectedSensor,	// Remote Feedback Source
    REMOTE_0,							// Source number [0, 1]
    kTimeoutMs);						// Configuration Timeout

/* Setup difference signal to be used for turn when performing Drive Straight with encoders */
  rightMaster.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0, kTimeoutMs);	// Feedback Device of Remote Talon
  rightMaster.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.QuadEncoder, kTimeoutMs);		// Quadrature Encoder of current Talon

/* Difference term calculated by right Talon configured to be selected sensor of turn PID */
  rightMaster.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference, 
    PID_TURN, 
    kTimeoutMs);
    
    		/* Scale the Feedback Sensor using a coefficient */
		/**
		 * Heading units should be scaled to ~4000 per 360 deg, due to the following limitations...
		 * - Target param for aux PID1 is 18bits with a range of [-131072,+131072] units.
		 * - Target for aux PID1 in motion profile is 14bits with a range of [-8192,+8192] units.
		 *  ... so at 3600 units per 360', that ensures 0.1 degree precision in firmware closed-loop
		 *  and motion profile trajectory points can range +-2 rotations.
		 */
		rightMaster.configSelectedFeedbackCoefficient(kTurnTravelUnitsPerRotation / kEncoderUnitsPerRotation,	// Coefficient
    PID_TURN, 														// PID Slot of Source
    kTimeoutMs);														// Configuration Timeout

/* Configure output and sensor direction */
/*
  leftMaster.setInverted(false);
  leftMaster.setSensorPhase(true);
  rightMaster.setInverted(true);
  rightMaster.setSensorPhase(true);
  */

/* Set status frame periods */
  rightMaster.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, kTimeoutMs);
  rightMaster.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, kTimeoutMs);
  leftMaster.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, kTimeoutMs);		//Used remotely by right Talon, speed up

/* Configure neutral deadband */
  rightMaster.configNeutralDeadband(kNeutralDeadband, kTimeoutMs);
  leftMaster.configNeutralDeadband(kNeutralDeadband, kTimeoutMs);

  /* max out the peak output (for all modes).  However you can
		 * limit the output of a given PID object with configClosedLoopPeakOutput().
		 */
		leftMaster.configPeakOutputForward(+1.0, kTimeoutMs);
		leftMaster.configPeakOutputReverse(-1.0, kTimeoutMs);
		rightMaster.configPeakOutputForward(+1.0, kTimeoutMs);
		rightMaster.configPeakOutputReverse(-1.0, kTimeoutMs);

		/* FPID Gains for turn servo */
		rightMaster.config_kP(kSlot_Turning, kGains_Turning.kP, kTimeoutMs);
		rightMaster.config_kI(kSlot_Turning, kGains_Turning.kI, kTimeoutMs);
		rightMaster.config_kD(kSlot_Turning, kGains_Turning.kD, kTimeoutMs);
		rightMaster.config_kF(kSlot_Turning, kGains_Turning.kF, kTimeoutMs);
		rightMaster.config_IntegralZone(kSlot_Turning, kGains_Turning.kIzone, kTimeoutMs);
		rightMaster.configClosedLoopPeakOutput(kSlot_Turning, kGains_Turning.kPeakOutput, kTimeoutMs);
		rightMaster.configAllowableClosedloopError(kSlot_Turning, 0, kTimeoutMs);
			
		/* 1ms per loop.  PID loop can be slowed down if need be.
		 * For example,
		 * - if sensor updates are too slow
		 * - sensor deltas are very small per update, so derivative error never gets large enough to be useful.
		 * - sensor movement is very slow causing the derivative error to be near zero.
		 */
        int closedLoopTimeMs = 1;
        rightMaster.configClosedLoopPeriod(0, closedLoopTimeMs, kTimeoutMs);
        rightMaster.configClosedLoopPeriod(1, closedLoopTimeMs, kTimeoutMs);

		/* configAuxPIDPolarity(boolean invert, int timeoutMs)
		 * false means talon's local output is PID0 + PID1, and other side Talon is PID0 - PID1
		 * true means talon's local output is PID0 - PID1, and other side Talon is PID0 + PID1
		 */
		rightMaster.configAuxPIDPolarity(false, kTimeoutMs);

}

	/* Zero all sensors used */
	void zeroSensors() {
    int kTimeoutMs = 30;
		leftMaster.getSensorCollection().setQuadraturePosition(0, kTimeoutMs);
		rightMaster.getSensorCollection().setQuadraturePosition(0, kTimeoutMs);
		System.out.println("[Quadrature Encoders] All sensors are zeroed.\n");
	}

}
