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
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  	//Map out the Joystick #'s in the DriverStation USB Ports
	public static int DRIVERSTICK_USB_PORT = 0;
	public static int OPERSTICK_USB_PORT = 1;
	
	//These are the buttons on the Joysticks as recognized by the Drivers Station. You can call in other subsystems.
	public static int A_BUTTON = 1;
	public static int B_BUTTON = 2;
	public static int X_BUTTON = 3;
	public static int Y_BUTTON = 4;
	public static int LEFT_BUMPER_BUTTON = 5;
	public static int RIGHT_BUMPER_BUTTON = 6;
	public static int BACK_BUTTON = 7;
	public static int START_BUTTON = 8;
	public static int X_AXIS_STICK = 0;
	public static int Y_AXIS_STICK = 1;
	public static int LEFT_TRIGGER = 2;
	public static int RIGHT_TRIGGER = 3;


  //CAN ADDRESSES FOR OUR CAN NETWORK
  public static int CAN_ADDRESS_LEFT_FRONT_DRIVE = 1;
  public static int CAN_ADDRESS_LEFT_REAR_DRIVE  = 11;
  public static int CAN_ADDRESS_RIGHT_FRONT_DRIVE = 2;
  public static int CAN_ADDRESS_RIGHT_REAR_DRIVE = 12;
  public static int CAN_ADDRESS_ARM_MASTER = 3;
  public static int CAN_ADDRESS_ARM_SLAVE = 13;
  public static int CAN_ADDRESS_SPINNER = 4;

  //PWM ADDRESSES FOR OUR ROBORIO
  public static int PWM_PORT_CARGO_INTAKE = 0;
  public static int PWM_PORT_PHASERS = 1;

  //GYRO SPI PORT NUMBER
  public static int SPI_PORT_AHRS = 0;

  //ENCODER DIO CHANNELS
  public static int DIO_PORT_DTENCODER_LEFT_CHANNEL_A = 0;
  public static int DIO_PORT_DTENCODER_LEFT_CHANNEL_B = 1;
  public static int DIO_PORT_DTENCODER_RIGHT_CHANNEL_A = 2;
  public static int DIO_PORT_DTENCODER_RIGHT_CHANNEL_B = 3;

  public static double DRIVETRAIN_AIM_TOLERANCE = 5;  //Tolerance of degrees we want to be on target
  public static double DRIVETRAIN_DISTANCE_TOLERANCE = 1;  //Tolerance of degrees we want to be on target

  //Pneumatics Values
  public static int SOLINOID_DOUBLE_PCM_PORT_A = 1;
  public static int SOLINOID_DOUBLE_PCM_PORT_B = 2;
  public static int SOLINOID_SINGLE_PCM_PORT = 3;


  // limelight constants
  public static double LIMELIGHT_CAMMODE_VISION = 0; // Vision Mode = 0
  public static double LIMELIGHT_CAMMODE_DRIVER = 1; // Driver Mode = 1
  public static double LIMELIGHT_LEDMODE_ON = 3; // Force LED Mode On
  public static double LIMELIGHT_LEDMODE_OFF = 1; // Force LED Mode Off
  public static double LIMELIGHT_LEDMODE_BLINK = 2; // Force LED Mode Blink
  public static double LIMELIGHT_PIPELINE_VEST = 0; // Use the VEST Pipeline
  public static double LIMELIGHT_PIPELINE_CARGO = 1;// Use the Cargo Ball Pipeline
  public static double LIMELIGHT_PIPELINE_ROCKET = 2;
  public static double LIMELIGHT_NO_TARGET = 0.0; // Value when the Limelight doesn't see its target
  public static double LIMELIGHT_SEEK_TURN_POWER = 0.4; // Power when we are turning
  public static double LIMELIGHT_SEEK_DRIVE_POWER = 0.7; // Power when we are driving toward the target
  // public static double LIMELIGHT_SEEK_AREA = 0.9;
  public static double LIMELIGHT_X_PIXEL_COUNT = 320; // pixels
  public static double LIMELIGHT_Y_PIXEL_COUNT = 240; // pixels
  public static double LIMELIGHT_X_FOV = 59.6; // degrees
  public static double LIMELIGHT_Y_FOV = 45.7; // degrees
  public static double LIMELIGHT_CAMERAMOUNT_ANGLE = 0.0; // degrees
  public static double LIMELIGHT_CAMERA_HEIGHT = 26.25; // inches
  public static double LIMELIGHT_DISTANCE_FROM_TARGET = 24.0; // inches
  public static double LIMELIGHT_CARGO_HEIGHT = 5.5; // inches
  public static double LIMELIGHT_HATCHCOVER_HEIGHT = 0.25; // inches

  public static double ARM_RAISE_SPEED = 0.5;
  public static double ARM_LOWER_SPEED = -0.5;

  public static double CARGO_INTAKE_SPEED = 0.8;
  public static double CARGO_EJECT_SPEED = -0.8;

  //phasers
  public static double PHASERS_OCEAN_PALETTE = -0.95;
  public static double PHASERS_FOREST_PALETTE = -0.91;
  public static double PHASERS_GLITTER_PALETTE = -0.89;
  public static double PHASERS_CONFETTI_PALETTE = -0.87;
  public static double PHASERS_SINELON_LAVA_PALETTE = -0.71;
  public static double PHASERS_FIRE_PALETTE = -0.57;
  public static double PHASERS_LARSON_SCANNER = -0.35;
  public static double PHASERS_SHOT = 0.33;
  public static double PHASERS_LAWN_GREEN = 0.71;
  public static double PHASERS_WHITE = 0.93;
  public static double PHASERS_BLACK = 0.99;


}
