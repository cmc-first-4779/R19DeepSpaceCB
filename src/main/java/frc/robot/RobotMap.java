/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

/*********************************************************************************/
/*********************************************************************************/
/** SETTINGS THAT DEFINE PCM, PWM, DIO PORTS AND CONTROL MODULES  ***************/
/***(Do NOT Change these unless we have to rewire something on the Robot)*********/
/*********************************************************************************/
/*********************************************************************************/

   //***************** CAN ADDRESSES *******************************************/
  public static final int CAN_ADDRESS_LEFT_FRONT_DRIVE = 1;  // Front Left Drive Motor  (TALON)
  public static final int CAN_ADDRESS_LEFT_REAR_DRIVE  = 11;  //  Rear Left Drive Motor  (VICTOR)
  public static final int CAN_ADDRESS_RIGHT_FRONT_DRIVE = 2;  /// Front Right Drive Motor  (TALON)
  public static final int CAN_ADDRESS_RIGHT_REAR_DRIVE = 12;  //  Rear Right Drive Motor  (VICTOR)

  //***************** PWM PORTS ON THE ROBORIO **********************************/
  public static final int PWM_PORT_BLASTOFF_LEGS_MAIN = 0;  // PWM for Cargo Intake Wheel Motor (SPARK)
  public static final int PWM_PORT_BLASTOFF_LEGS_SECONDARY = 1;
  public static final int PWM_PORT_BLASTOFF_WHEELS = 2;  //  PWM for BLASTOFF Motor Wheels (SPARK)
  public static final int PWM_PORT_PHASERS = 3;  //  PWM for BLINKIN LED Driver (Looks like a SPARK, but not)

  //************** PCM (PNEUMATICS CONTROL MODULE) PORTS *************************/
  public static final int PCM_PORT_DINO_ARMS_UNGRAB = 7;   //Green Pneumatic Tubing
  public static final int PCM_PORT_DINO_ARMS_GRAB = 6;    //Green Pneumatic Tubing
  public static final int PCM_PORT_BOOMSTICK_UNBOOM = 0;  //Dark Blue Pneumatic Tubing
  public static final int PCM_PORT_BOOMSTICK_BOOM = 1;   //Dark Blue Pneumatic Tubing
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_EXPAND = 3;
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_RETRACT = 2;
  public static final int PCM_PORT_HATCHHANDLER_THE_ALEX_FORWARD = 4;
  public static final int PCM_PORT_HATCHHANDLER_THE_ALEX_REVERSE = 5;




  /********************** GYRO SPI PORT **************************************************/
  public static final int SPI_PORT_AHRS = 0;  //Using Nav-X GYRO THIS YEAR

  /************************* DIO PORTS ************************************************* */
  public static final int DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A = 0;  //Blastoff Spark Motor Encoder Channel A
  public static final int DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B = 1;  //Blastoff Spark Motor Encoder Channel B


/*********************************************************************************/
/*********************************************************************************/
/*************** SETTINGS WE CAN CHANGE TO TUNE THE ROBOT  ***********************/
/*********************************************************************************/
/*********************************************************************************/

/******************************************************************************* */
/****************   WARP DRIVE / DRIVE TRAIN SETTINGS  ***************************/
/******************************************************************************* */
public static int WARPDRIVE_DIRECTION_FORWARD = 1;
public static int WARPDRIVE_DIRECTION_REVERSE = -1;
public static int WARPDRIVE_BACKUP_DISTANCE = 3000;  // placeholder, we need to adjust
public static double WARPDRIVE_SPEED = 0.8;
public static double WARPDRIVE_LOW_HAB_SPEED = 0.8; //placeholder
public static double WARPDRIVE_HAB_SPEED = 0.4; //placeholder
public static int WARPDRIVE_DISTANCE_MEDIUM_HAB = 600; //placeholder
public static int WARPDRIVE_DISTANCE_LOW_HAB = 400; //placeholder
public static double WARPDRIVE_BUMPER_TURN_INCREMENT = 10;  //degrees.. placeholder.  Used to do minor turn corrections via the bumpers.
public static final double WARPDRIVE_TURN_TOLERANCE = 1;  //number of degrees we can be off when turning a set number of degrees

  /************************************************************************/
  /***************LIMELIGHT / VISION SETTINGS *****************************/
  /**********These variables can change to be tuned..******************** */
  /********** Non-tunable variables are in LimelightConstants.java  ***** */
  /************************************************************************/
  //
  public static final double LIMELIGHT_PIPELINE_ROCKET_HATCH = 0; // Use the Rocket Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_ROCKET_CARGO = 1;  //Use the Rocket CARGO Pipeline
  public static final double LIMELIGHT_PIPELINE_CARGOSHIP_HATCH = 2;  // Use the Cargo Ship Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_CARGOSHIP_CARGO = 3;  // Use the Cargo Ship Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_HATCHCOVER = 4;  // Use the Hatch Cover Pipeline
  public static final double LIMELIGHT_PIPELINE_CARGO_BALL = 5;   //  Use the Cargo Ball Pipeline
  public static final double LIMELIGHT_PIPELINE_VEST = 9; // Use the VEST Pipeline..    We use this for Testing...
   //  LIMELIGHT SEEK MODE - How much power do we give the motors when it is turning to scan and driving...
  public static final double LIMELIGHT_SEEK_TURN_POWER = 0.4; // Power when we are turning
  public static final double LIMELIGHT_SEEK_DRIVE_POWER = 0.7; // Power when we are driving toward the target
  // public static double LIMELIGHT_SEEK_AREA = 0.9;
  //  LIMELIGHT Details about where the camera is mounted, and target details...
  public static final double LIMELIGHT_CAMERAMOUNT_ANGLE = 0.0; // degrees
  public static final double LIMELIGHT_CAMERA_HEIGHT = 26.25; // inches
  public static final double LIMELIGHT_DISTANCE_FROM_TARGET = 24.0; // inches
  public static final double LIMELIGHT_CARGO_HEIGHT = 5.5; // inches
  public static final double LIMELIGHT_HATCHCOVER_HEIGHT = 0.25; // inches
  public static final double LIMELIGHT_DRIVETRAIN_AIM_TOLERANCE = 5;  //Tolerance of degrees we want to be on target
  public static final double LIMELIGHT_DRIVETRAIN_DISTANCE_TOLERANCE = 1;  //Tolerance of degrees we want to be on target
  public static final double LIMELIGHT_SKEW_CLOCKWISE_MAX = 62.5; // degrees
  public static final double LIMELIGHT_SKEW_CLOCKWISE_MIN = -90.0; // degrees
  public static final double LIMELIGHT_SKEW_COUNTERCLOCKWISE_MAX = -0.01; //degrees
  public static final double LIMELIGHT_SKEW_COUNTERCLOCKWISE_MIN = 32.5; //degrees



  /**********************************************************************/
  /************** BLASTOFF / CLIMBER SETTINGS ***************************/
  /**********************************************************************/
  public static double BLASTOFF_LEGS_kP = 0.8;
  public static double BLASTOFF_LEGS_kI = 0.0;
  public static double BLASTOFF_LEGS_kD = 0.0;
  public static double BLASTOFF_LEGS_UP_SPEED = 1.0;  //volts
  public static double BLASTOFF_LEGS_DOWN_SPEED = -1.0; //volts
  public static double BLASTOFF_LEGS_STOP_SPEED = 0.0;  //volts
  public static double BLASTOFF_WHEELS_FORWARD_SPEED = 1.0;  //volts
  public static double BLASTOFF_WHEELS_REVERSE_SPEED = -1.0;  //volts
  public static double BLASTOFF_WHEELS_STOP_SPEED = 0.0;  //volts
  public static double BLASTOFF_TIMEOUT = 4.0;  //seconds
  public static double BLASTOFF_OK_TIME_TO_LAUNCH = 29;  //seconds remaining in the game 
  public static double BLASTOFF_ENCODER_PULSES_PER_REVOLUTION = 1024;
  //  Distance per axle revolution.    2" diameter wheels =>  2 *pi = Circumference = 6.28"  
  //     Motor is geared on a 10:1 ratio, so we should be seeing 6.28" / 10 distance each rotation
 // public static double BLASTOFF_DISTANCE_PER_REVOLUTION = 0.628; // inches..   
  public static double BLASTOFF_DISTANCE_PER_REVOLUTION = 4; // inches..   
  public static double BLASTOFF_DISTANCE_PER_PULSE = BLASTOFF_DISTANCE_PER_REVOLUTION / BLASTOFF_ENCODER_PULSES_PER_REVOLUTION;
  public static double BLASTOFF_MEDIUM_HAB_HEIGHT = 7.0; //inches 
  public static double BLASTOFF_HIGH_HAB_HEIGHT = 14.0; //inches 


  //BlackHole Settings
  public static double BLACKHOLE_BOOM_TIMER = 0.75; //seconds   Time to boom before we un-boom
  
}
