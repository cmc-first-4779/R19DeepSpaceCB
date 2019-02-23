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
  public static final int CAN_ADDRESS_ARM_MASTER = 5;  //  ARM Master Motor (TALON)
  public static final int CAN_ADDRESS_ARM_SLAVE = 15;  //  ARM Slave Motor (TALON)
  public static final int CAN_ADDRESS_BLACKHOLE = 3;  //  BLACKHOLE Spin Motor (Talon)

  //***************** PWM PORTS ON THE ROBORIO **********************************/
  public static final int PWM_PORT_EVENTHORIZON_WHEELS = 0;  // PWM for Cargo Intake Wheel Motor (SPARK)
  public static final int PWM_PORT_BLASTOFF = 1;  //  PWM for BLASTOFF Motor Wheels (SPARK)
  public static final int PWM_PORT_PHASERS = 2;  //  PWM for BLINKIN LED Driver (Looks like a SPARK, but not)

  //************** PCM (PNEUMATICS CONTROL MODULE) PORTS *************************/
  public static final int PCM_PORT_EVENTHORIZON_RAISE = 0;   //Green Pneumatic Tubing
  public static final int PCM_PORT_EVENTHORIZON_LOWER = 1;    //Green Pneumatic Tubing
  public static final int PCM_PORT_PLUNGER_RETRACT = 2;  //Dark Blue Pneumatic Tubing
  public static final int PCM_PORT_PLUNGER_PLUNGE = 3;   //Dark Blue Pneumatic Tubing
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_EXPAND = 4;   //White Pneumatic tubing
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_RETRACT = 5;   // White Pneumatic tubing
  public static final int PCM_PORT_BLASTOFF_LAND = 6;      //  RED Pneumatic Tubing
  public static final int PCM_PORT_BLASTOFF_LAUNCH = 7;   //   RED Pneumatic Tubing
 

  /********************** GYRO SPI PORT **************************************************/
  public static final int SPI_PORT_AHRS = 0;  //Using Nav-X GYRO THIS YEAR

  /*************************DIO PORTS ************************************************* */
  public static final int DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A = 0;  //Blastoff Spark Motor Encoder Channel A
  public static final int DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B = 1;  //Blastoff Spark Motor Encoder Channel B
  public static final int DIO_PORT_EVENTHORIZON_LIMITSWITCH = 2;  // Limit Switch for detecting if a ball is in the box

  
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
public static double WARPDRIVE_MEDIUM_HAB_SPEED = 0.4; //placeholder
public static int WARPDRIVE_DISTANCE_MEDIUM_HAB = 600; //placeholder
public static int WARPDRIVE_DISTANCE_LOW_HAB = 400; //placeholder


  /************************************************************************/
  /***************LIMELIGHT / VISION SETTINGS *****************************/
  /**********These variables can change to be tuned..******************** */
  /********** Non-tunable variables are in LimelightConstants.java  ***** */
  /************************************************************************/
  //
  public static final double LIMELIGHT_PIPELINE_ROCKET_HATCH = 0; // Use the Rocket Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_ROCKET_CARGO = 1;  //Use the Rocket CARGO Pipeline
  public static final double LIMELINE_PIPELINE_CARGOSHIP_HATCH = 2;  // Use the Cargo Ship Hatch Pipeline
  public static final double LIMELINE_PIPELINE_CARGOSHIP_CARGO = 3;  // Use the Cargo Ship Hatch Pipeline
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


  /*********************************************************************/
  /*************** ARM SETTINGS ****************************************/
  /*********************************************************************/
  public static double ARM_RAISE_SPEED =  0.6;
  public static double ARM_LOWER_SPEED = -0.6;
  public static double ARM_RAISE_VOLTAGE = 7.0;  //volts
  public static double ARM_LOWER_VOLTAGE = -3.0;  //volts
  public static double ARM_MAX_HEIGHT = 2929292;   //placeholder..   Need to fix..
  public static double ARM_ENCODER_POSITION_ROCKET_UPPER_HATCH = 300000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_ROCKET_MIDDLE_HATCH = 200000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_ROCKET_LOWER_HATCH = 100000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_ROCKET_UPPER_CARGO = 300000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_ROCKET_MIDDLE_CARGO = 200000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_ROCKET_LOWER_CARGO = 100000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_CARGO_SHIP_HATCH = 100000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_CARGO_SHIP_CARGO = 200000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_FLOOR_CARGO = 75000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_FLOOR_HATCH = 75000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_HUMAN_CARGO = 80000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_HUMAN_HATCH = 80000;  //placeholder..  Need to fix
  public static double ARM_ENCODER_POSITION_HIGH_HAB_PlATFORM = 250000;  //placeholder..  Need to fix

  /**********************************************************************/
  /************** BLASTOFF / CLIMBER SETTINGS ***************************/
  /**********************************************************************/
  public static double BLASTOFF_FORWARD_SPEED = 0.7;  //volts
  public static double BLASTOFF_REVERSE_SPEED = -0.5;  //volts
  public static double BLASTOFF_STOP_SPEED = 0.0;  //volts
  public static double BLASTOFF_TIMEOUT = 1.0;  //seconds
  public static double BLASTOFF_OK_TIME_TO_LAUNCH = 150;  //seconds


   /****************************************************************************/
   /************** BLACKHOLE / CARGO HOLDER SETTINGS ***************************/
   /****************************************************************************/
  public static double BLACK_HOLE_SPIN_FORWARD_SPEED = -0.4; 
  public static double BLACK_HOLE_SPIN_REVERSE_SPEED = 0.4;
  public static double BLACK_HOLE_SPIN_STOP_SPEED = 0.0;
  public static double BLACK_HOLE_MAX_POSITIVE_ANGLE = 100;  //degrees   Need to test
  public static double BLACK_HOLE_MAX_NEGATIVE_ANGLE = -60;  //degrees   Need to test
  public static double BLACK_HOLE_ENCODER_POSITION_HATCH_LOAD = 180;  //degrees placeholder..  Need to fix
  public static double BLACK_HOLE_ENCODER_POSITION_CARGO_LOAD = 270;  //degrees placeholder..  Need to fix
  public static double BLACK_HOLE_ENCODER_POSITION_CARGO_CARRY = 0;  //degrees placeholder..  Need to fix
  public static double BLACK_HOLE_ENCODER_POSITION_CARGO_EJECT = 30;   //degrees placeholder..  Need to fix
  public static double BLACK_HOLE_ENCODER_POSITION_HIGH_HAB_PLATFORM = 240;   //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_LOWER_HATCH = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_MIDDLE_HATCH = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_UPPER_HATCH = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_LOWER_CARGO = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_MIDDLE_CARGO = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_ROCKET_UPPER_CARGO = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_CARGO_SHIP_HATCH = 200;  //degrees placeholder..  Need to fix 
  public static double BLACK_HOLE_ENCODER_POSITION_CARGO_SHIP_CARGO = 200;  //degrees placeholder..  Need to fix 


   /************************************************************************************/
   /************** EVENT HORIZON / CARGO INTAKE ARM SETTINGS ***************************/
   /************************************************************************************/
  public static double EVENTHORIZON_INTAKE_MOTOR_SPEED = 0.4;  //Power to Spark Controller
  public static double EVENTHORIZON_REVERSE_MOTOR_SPEED = -0.4;  //Power to Spark Controller
  public static double EVENTHORIZON_ARM_WAIT_TIME = 0.5; //seconds to wait for the Arm mechanism before moving the Event Horizon Arm


   /************************************************************************************/
   /******************** MISC SETTINGS *************************************************/
   /********************************************************************************** */
  public static double CARGO_LOAD_WAIT_TIME = 0.5;  // seconds.  Time to wait for the Cargo to settle before moving
  public static double DEPLOY_WAIT_TIME_BEFORE_MOVE = 0.5; //seoncds..  Time to wait after ejecting cargo or a hatch cover.
  //  Carry Mode - So that we can tell the robot what it is carrying.   This helps with Black Hole Orientation as the Arm moves.
  public static int CARRY_MODE_NONE = 0;   // You carry NOTHING!!   You LOSE!!
  public static int CARRY_MODE_CARGO = 1;   //  Robot carries a cargo ball..
  public static int CARRY_MODE_HATCH = 2;   //  Robot carries a hatch cover..

  
}
