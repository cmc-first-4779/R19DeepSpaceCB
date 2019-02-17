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
/** SETTINGS THAT DEFINE JOYSTICKS, RIO PORTS AND CONTROL MODULES  ***************/
/***(Do NOT Change these unless we have to rewire something on the Robot)*********/
/*********************************************************************************/
/*********************************************************************************/

//***************** JOYSTICK USB PORTS *******************************************/
	//Map out the Joystick #'s in the DriverStation USB Ports
	public static final int DRIVERSTICK_USB_PORT = 0;
	public static final int OPERSTICK_USB_PORT = 1;
  
  //***************** JOYSTICK BUTTONS *******************************************/
	//These are the buttons on the Joysticks as recognized by the Drivers Station. You can call in other subsystems.
	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;
	public static final int Y_BUTTON = 4;
	public static final int LEFT_BUMPER_BUTTON = 5;
	public static final int RIGHT_BUMPER_BUTTON = 6;
	public static final int BACK_BUTTON = 7;
	public static final int START_BUTTON = 8;
	public static final int X_AXIS_STICK = 0;
	public static final int Y_AXIS_STICK = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;


   //***************** CAN ADDRESSES *******************************************/
  public static final int CAN_ADDRESS_LEFT_FRONT_DRIVE = 1;
  public static final int CAN_ADDRESS_LEFT_REAR_DRIVE  = 11;
  public static final int CAN_ADDRESS_RIGHT_FRONT_DRIVE = 2;
  public static final int CAN_ADDRESS_RIGHT_REAR_DRIVE = 12;
  public static final int CAN_ADDRESS_ARM_MASTER = 5;
  public static final int CAN_ADDRESS_ARM_SLAVE = 15;  //Change back to 14 once we have access to the board
  public static final int CAN_ADDRESS_BLACKHOLE = 3;

  //***************** PWM PORTS ON THE ROBORIO **********************************/
  public static final int PWM_PORT_EVENTHORIZON_WHEELS = 0;
  public static final int PWM_PORT_BLASTOFF = 1;
  public static final int PWM_PORT_PHASERS = 2;

  //************** PCM (PNEUMATICS CONTROL MODULE) PORTS *************************/
  public static final int PCM_PORT_EVENTHORIZON_RAISE = 0;  //Placeholder for now..
  public static final int PCM_PORT_EVENTHORIZON_LOWER = 1;  //Placeholder for now..
  public static final int PCM_PORT_PLUNGER_RETRACT = 2;
  public static final int PCM_PORT_PLUNGER_PLUNGE = 3;
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_EXPAND = 4; //Placeholder for now..
  public static final int PCM_PORT_HATCHHANDLER_NOSECONE_RETRACT = 5;  //Placeholder for now..
  public static final int PCM_PORT_BLASTOFF_LAUNCH = 6;
  public static final int PCM_PORT_BLASTOFF_LAND = 7;

  /********************** GYRO SPI PORT **************************************************/
  public static final int SPI_PORT_AHRS = 0;

  
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

  /************************************************************************/
  /***************LIMELIGHT / VISION SETTINGS *****************************/
  /************************************************************************/
  //
  //  LIMELIGHT Camera Modes
  public static final double LIMELIGHT_CAMMODE_VISION = 0; // Vision Processing Mode = 0
  public static final double LIMELIGHT_CAMMODE_DRIVER = 1; // Driver Mode = 1
  //  LIMELIGHT LED Modes
  public static final double LIMELIGHT_LEDMODE_PIPELINE_DEFAULT = 0;  // Uses the Default LED Mode for the Pipeline
  public static final double LIMELIGHT_LEDMODE_OFF = 1; // Force LED Mode Off
  public static final double LIMELIGHT_LEDMODE_BLINK = 2; // Force LED Mode Blink
  public static final double LIMELIGHT_LEDMODE_ON = 3; // Force LED Mode On
  //  LIMELIGHT Vision Pipelines
  public static final double LIMELIGHT_PIPELINE_ROCKET_HATCH = 0; // Use the Rocket Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_ROCKET_CARGO = 1;  //Use the Rocket CARGO Pipeline
  public static final double LIMELINE_PIPELINE_CARGOSHIP_HATCH = 2;  // Use the Cargo Ship Hatch Pipeline
  public static final double LIMELINE_PIPELINE_CARGOSHIP_CARGO = 3;  // Use the Cargo Ship Hatch Pipeline
  public static final double LIMELIGHT_PIPELINE_HATCHCOVER = 4;  // Use the Hatch Cover Pipeline
  public static final double LIMELIGHT_PIPELINE_CARGO_BALL = 5;   //  Use the Cargo Ball Pipeline
  public static final double LIMELIGHT_PIPELINE_VEST = 9; // Use the VEST Pipeline..    We use this for Testing...
  // LIMELIGHT TV Value when there is no target
  public static final double LIMELIGHT_NO_TARGET = 0.0; // TV Value when the Limelight doesn't see its target
  public static final double LIMELIGHT_HAS_TARGET = 1.0;  //TV Value when the Limelight has a target
  //  LIMELIGHT SEEK MODE - How much power do we give the motors when it is turning to scan and driving...
  public static final double LIMELIGHT_SEEK_TURN_POWER = 0.4; // Power when we are turning
  public static final double LIMELIGHT_SEEK_DRIVE_POWER = 0.7; // Power when we are driving toward the target
  // public static double LIMELIGHT_SEEK_AREA = 0.9;
  //  LIMELIGHT Details about where the camera is mounted, and target details...
  public static final double LIMELIGHT_X_PIXEL_COUNT = 320; // pixels
  public static final double LIMELIGHT_Y_PIXEL_COUNT = 240; // pixels
  public static final double LIMELIGHT_X_FOV = 59.6; // degrees
  public static final double LIMELIGHT_Y_FOV = 45.7; // degrees
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
  public static double ARM_RAISE_SPEED =  0.4;
  public static double ARM_LOWER_SPEED = -0.4;
  public static double ARM_RAISE_VOLTAGE = 7.0;  //volts
  public static double ARM_LOWER_VOLTAGE = -3.0;  //volts
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
  public static double BLASTOFF_REVERSE_SPEED = 0.5;  //volts
  public static double BLASTOFF_STOP_SPEED = 0.0;  //volts
  public static double BLASTOFF_TIMEOUT = 1.0;  //seconds
  public static double BLASTOFF_OK_TIME_TO_LAUNCH = 150;  //seconds


   /****************************************************************************/
   /************** BLACKHOLE / CARGO HOLDER SETTINGS ***************************/
   /****************************************************************************/
  public static double BLACK_HOLE_SPIN_FORWARD_SPEED = -0.4; 
  public static double BLACK_HOLE_SPIN_REVERSE_SPEED = 0.4;
  public static double BLACK_HOLE_SPIN_STOP_SPEED = 0.0;
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
  public static double EVENTHORIZON_INTAKE_SPEED = 0.4;  //Power to Spark Controller
  public static double EVENTHORIZON_EJECT_SPEED = -0.4;  //Power to Spark Controller
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


  /**********************************************************************/
  /************** PHASER / LED LIGHT SETTINGS ***************************/
  /**********************************************************************/
  public static double PHASERS_RAINBOW_PALETTE = -0.99;
  public static double PHASERS_PARTY_PALETTE = -0.97;
  public static double PHASERS_OCEAN_PALETTE = -0.95;
  public static double PHASERS_LAVA_PALETTE = -0.93;
  public static double PHASERS_FOREST_PALETTE = -0.91;
  public static double PHASERS_GLITTER_PALETTE = -0.89;
  public static double PHASERS_CONFETTI_PALETTE = -0.87;
  public static double PHASERS_SHOT_RED = -0.85;
  public static double PHASERS_SHOT_BLUE = -0.83;
  public static double PHASERS_SHOT_WHITE = -0.81;
  public static double PHASERS_SINELON_RAINBOW_PALETTE = -0.79;
  public static double PHASERS_SINELON_PARTY_PALETTE = -0.77;
  public static double PHASERS_SINELON_OCEAN_PALETTE = -0.75;
  public static double PHASERS_SINELON_LAVA_PALETTE = -0.73;
  public static double PHASERS_SINELON_FOREST_PALETTE = -0.71;
  public static double PHASERS_BPM_RAINBOW_PALETTE = -0.69;
  public static double PHASERS_BPM_PARTY_PALETTE = -0.67;
  public static double PHASERS_BPM_OCEAN_PALETTE = -0.65;
  public static double PHASERS_BPM_LAVA_PALETTE = -0.63;
  public static double PHASERS_BPM_FOREST_PALETTE = -0.61;
  public static double PHASERS_FIRE_MEDIUM = -0.59;
  public static double PHASERS_FIRE_LARGE = -0.57;
  public static double PHASERS_TWINKLES_RAINBOW_PALETTE = -0.55;
  public static double PHASERS_TWINKLES_PARTY_PALETTE = -0.53;
  public static double PHASERS_TWINKLES_OCEAN_PALETTE = -0.51;
  public static double PHASERS_TWINKLES_LAVA_PALETTE = -0.49;
  public static double PHASERS_TWINKLES_FOREST_PALETTE = -0.47;
  public static double PHASERS_WAVES_RAINBOW_PALETTE = -0.45;
  public static double PHASERS_WAVES_PARTY_PALETTE = -0.43;
  public static double PHASERS_WAVES_OCEAN_PALETTE = -0.41;
  public static double PHASERS_WAVES_LAVA_PALETTE = -0.39;
  public static double PHASERS_WAVES_FOREST_PALETTE = -0.37;
  public static double PHASERS_LARSON_SCANNER_RED = -0.35;
  public static double PHASERS_LARSON_SCANNER_GRAY = -0.33;
  public static double PHASERS_CHASE_RED = -0.31;
  public static double PHASERS_CHASE_BLUE = -0.29;
  public static double PHASERS_CHASE_GRAY = -0.27;
  public static double PHASERS_HEARTBEAT_RED = -0.25;
  public static double PHASERS_HEARTBEAT_BLUE = -0.23;
  public static double PHASERS_HEARTBEAT_WHITE = -0.21;
  public static double PHASERS_HEARTBEAT_GRAY = -0.19;
  public static double PHASERS_BREATH_RED = -0.17;
  public static double PHASERS_BREATH_BLUE = -0.15;
  public static double PHASERS_BREATH_GRAY = -0.13;
  public static double PHASERS_STROBE_RED = -0.11;
  public static double PHASERS_STROBE_BLUE = -0.09;
  public static double PHASERS_STROBE_GOLD = -0.07;
  public static double PHASERS_STROBE_WHITE = -0.05;
  public static double PHASERS_COLOR1_BLEND_TO_BLACK = -0.03;
  public static double PHASERS_COLOR1_LARSON_SCANNER = -0.01;
  public static double PHASERS_COLOR1_LIGHT_CHASE = 0.01;
  public static double PHASERS_COLOR1_HEARTBEAT_SLOW = 0.03;
  public static double PHASERS_COLOR1_HEARTBEAT_MEDIUM = 0.05;
  public static double PHASERS_COLOR1_HEARTBEAT_FAST = 0.07;
  public static double PHASERS_COLOR1_BREATH_SLOW = 0.09;
  public static double PHASERS_COLOR1_BREATH_FAST = 0.11;
  public static double PHASERS_COLOR1_SHOT = 0.13;
  public static double PHASERS_COLOR1_STROBE = 0.15;
  public static double PHASERS_COLOR2_BLEND_TO_BLACK = 0.17;
  public static double PHASERS_COLOR2_LARSON_SCANNER = 0.19;
  public static double PHASERS_COLOR2_LIGHT_CHASE = 0.21;
  public static double PHASERS_COLOR2_HEARTBEAT_SLOW = 0.23;
  public static double PHASERS_COLOR2_HEARTBEAT_MEDIUM = 0.25;
  public static double PHASERS_COLOR2_HEARTBEAT_FAST = 0.27;
  public static double PHASERS_COLOR2_BREATH_SLOW = 0.29;
  public static double PHASERS_COLOR2_BREATH_FAST = 0.31;
  public static double PHASERS_COLOR2_SHOT = 0.33;
  public static double PHASERS_COLOR2_STROBE = 0.35;
  public static double PHASERS_COLOR1_2_SPARKLE = 0.37;
  public static double PHASERS_COLOR2_1_SPARKLE = 0.39;
  public static double PHASERS_COLOR1_2_GRADIENT = 0.41;
  public static double PHASERS_COLOR1_2_BPM = 0.43;
  public static double PHASERS_COLOR1_2_BLEND = 0.45;
  public static double PHASERS_COLOR2_1_BLEND = 0.47;
  public static double PHASERS_COLOR1_2_TWINKLES = 0.51;
  public static double PHASERS_COLOR1_2_WAVES = 0.53;
  public static double PHASERS_COLOR1_2_SINELON = 0.55;
  public static double PHASERS_HOT_PINK = 0.57;
  public static double PHASERS_DARK_RED = 0.59;
  public static double PHASERS_RED = 0.61;
  public static double PHASERS_RED_ORANGE = 0.63;
  public static double PHASERS_ORANGE = 0.65;
  public static double PHASERS_GOLD = 0.67;
  public static double PHASERS_YELLOW = 0.69;
  public static double PHASERS_LAWN_GREEN = 0.71;
  public static double PHASERS_LIME = 0.73;
  public static double PHASERS_DARK_GREEN = 0.75;
  public static double PHASERS_GREEN = 0.77;
  public static double PHASERS_BLUE_GREEN = 0.79;
  public static double PHASERS_AQUA = 0.81;
  public static double PHASERS_SKY_BLUE = 0.83;
  public static double PHASERS_DARK_BLUE = 0.85;
  public static double PHASERS_BLUE = 0.87;
  public static double PHASERS_BLUE_VIOLET = 0.89;
  public static double PHASERS_VIOLET = 0.91;
  public static double PHASERS_GRAY = 0.95;
  public static double PHASERS_DARK_GRAY = 0.97;
  public static double PHASERS_WHITE = 0.93;
  public static double PHASERS_BLACK = 0.99;
  //   Set a DEFAULT Phasers mode here so that way we only have to change it in one place..
  public static double PHASERS_DEFAULT = PHASERS_COLOR1_2_WAVES;
  
}
