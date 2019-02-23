/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 *   These are values from the Limelight Network API table...
 *     These NEVER change and so we are leaving them in a seperate class so that 
 *     RobotMap is cleaner and only contains values that we would be changing to tune the robot..
 * 
 *   We will leave the changing Limelight values STILL in RobotMap...   
 */
public class LimeLightConstants {
  /************************************************************************/
  /***************LIMELIGHT / VISION CONSTANTS *****************************/
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
   // LIMELIGHT TV Value when there is no target
   public static final double LIMELIGHT_NO_TARGET = 0.0; // TV Value when the Limelight doesn't see its target
   public static final double LIMELIGHT_HAS_TARGET = 1.0;  //TV Value when the Limelight has a target
   //  Camera Pixel Count and Field of View Constants
   public static final double LIMELIGHT_X_PIXEL_COUNT = 320; // pixels
   public static final double LIMELIGHT_Y_PIXEL_COUNT = 240; // pixels
   public static final double LIMELIGHT_X_FOV = 59.6; // degrees
   public static final double LIMELIGHT_Y_FOV = 45.7; // degrees
}
