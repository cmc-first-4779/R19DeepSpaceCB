/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.BlastOff.BlastOffLegsJoystickCommand;


public class BlastOffPIDSubsystem extends PIDSubsystem {

//  Declare our Spark Motor that powers the LEGS
Spark legsMotorMain;
Spark legsMotorSecondary; 

	
//  Declare and initiate our Lift encoder.
private static Encoder legsEncoder;


  public BlastOffPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("BlastOffPIDSubsystem", RobotMap.BLASTOFF_LEGS_kP, RobotMap.BLASTOFF_LEGS_kI, RobotMap.BLASTOFF_LEGS_kD);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.

    //Init our Spark Motor Controller for Dino Legs
    legsMotorMain = new Spark(RobotMap.PWM_PORT_BLASTOFF_LEGS_MAIN);
    legsMotorSecondary = new Spark(RobotMap.PWM_PORT_BLASTOFF_LEGS_SECONDARY);
    //legsMotorRight.setInverted(true);  //Invert the right motor
    

    //Init the encoder
    legsEncoder = new Encoder(RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A, RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B);
    //Set the Encoder Distance per Pulse
    legsEncoder.setDistancePerPulse(RobotMap.BLASTOFF_DISTANCE_PER_PULSE);
    legsEncoder.reset();

    //Set the tolerance of the PID loop
    setAbsoluteTolerance(RobotMap.BLASTOFF_PID_TOLERANCE);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BlastOffLegsJoystickCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return legsEncoder.getDistance();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    legsMotorsMove(output);	
  }
  
  public void legsMotorsMove(double speed){
    legsMotorMain.set(speed);
    legsMotorSecondary.set(speed);  
    }

  public void legsUp() {
    //  Move the Lift up.
       legsMotorsMove(RobotMap.BLASTOFF_LEGS_UP_SPEED);	
       //SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
  }
  
/*   public void legs(double yValue) {
    //  Move the Lift.	  
    //Stop the lift if we are within a quarter of an inch.
    if (yValue < .25 && yValue > -.25) {
         legsMotorsMove(RobotMap.BLASTOFF_LEGS_STOP_SPEED);
       }
       else if (yValue <-.25) {
         legsMotorsMove(RobotMap.BLASTOFF_LEGS_UP_SPEED);
       }
       else if (yValue >.25) {
         legsMotorsMove(RobotMap.BLASTOFF_LEGS_DOWN_SPEED);
       }
  }
 */
  public void legsDown() {
      legsMotorsMove(RobotMap.BLASTOFF_LEGS_DOWN_SPEED);
  } 

  public void legsOff() {
    //  Power the Lift Off.
    legsMotorsMove(RobotMap.BLASTOFF_LEGS_STOP_SPEED);	
  }
  
  public void legsMove(double power) {
    //  PID method used to move the lift up/down
     //if (Robot.blastOffPIDSubsystem.getSetpoint() < Robot.blastOffPIDSubsystem.getDistance()) {
      legsMotorsMove(power);
    //}	
   }
  
  public void log() {
  }

  public static double getDistance() {
    return legsEncoder.getDistance();
  }

  public void resetLiftEncoder()  {
    legsEncoder.reset();
  }

  public void legsMidHabPlatform(){
    setSetpoint(RobotMap.BLASTOFF_MEDIUM_HAB_HEIGHT);
    enable();
  }

  public void legsHighHabPlatform(){
    setSetpoint(RobotMap.BLASTOFF_HIGH_HAB_HEIGHT);
    enable();
  }

  public void land(){
    setSetpoint(RobotMap.BLASTOFF_LAND_HEIGHT);
    enable();
  }


}
