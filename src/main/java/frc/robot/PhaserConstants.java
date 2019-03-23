/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Table for all of the available colors and palettes on the Blinkin' LED Driver.
 *      
 *      We declare the Blinkin' LED as a SPARK Motor controller and then call the
 *      values below as voltages to get the palette or color that we wants...
 * 
 *      Example code:
 *        Spark phasers;
 *        phasers.set(pattern);
 * 
 */
public class PhaserConstants {

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
  public static double PHASERS_DEFAULT = PHASERS_OCEAN_PALETTE;
}
