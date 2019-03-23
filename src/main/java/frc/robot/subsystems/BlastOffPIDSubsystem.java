/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class BlastOffPIDSubsystem extends PIDSubsystem {

//  Declare our Spark Motor that powers the LEGS
Spark legsMotorLeft;

Spark legsMotorRight; 
//  Declare our Spark Motor that powers the Wheels on the Legs
Spark wheelsMotor;


	
//  Declare and initiate our Lift encoder.
private static Encoder legsEncoder;

//  Declare the BlastOff Solenoid
public DoubleSolenoid dinoArmsSolenoid;

  public BlastOffPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("BlastOffPIDSubsystem", RobotMap.BLASTOFF_LEGS_kP, RobotMap.BLASTOFF_LEGS_kI, RobotMap.BLASTOFF_LEGS_kD);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.

    //Init our Spark Motor Controller for wheels
    wheelsMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF_WHEELS);
    //Init our Spark Motor Controller for Dino Legs
    legsMotorLeft = new Spark(RobotMap.PWM_PORT_BLASTOFF_LEGS_LEFT);
    legsMotorRight = new Spark(RobotMap.PWM_PORT_BLASTOFF_LEGS_RIGHT);
    //Init our Double Solenoid
    dinoArmsSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_DINO_ARMS_GRAB, RobotMap.PCM_PORT_DINO_ARMS_UNGRAB);   
    //Init the encoder
    legsEncoder = new Encoder(RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A, RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B);
    //Set the Encoder Distance per Pulse
    legsEncoder.setDistancePerPulse(RobotMap.BLASTOFF_DISTANCE_PER_PULSE);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
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
    legsMove(output);	
  }
  
  public void legsMotorsMove(double speed){
    legsMotorLeft.set(speed);
    legsMotorRight.set(speed);
  }

  public void legsUp() {
    //  Move the Lift up.
       legsMotorsMove(RobotMap.BLASTOFF_LEGS_UP_SPEED);	
       //SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
  }
  
  public void legs(double yValue) {
    //  Move the Lift.	
    
    //Send the distance and power to the Smart Dashboard.
    //SmartDashboard.putNumber("Lift Power:" , yValue);
    //SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
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
  public void legsDown() {
    //  Move the Lift Down.
    //if (getDistance() <= 15)  {
      //liftMotor.set(RobotMap.liftThrottleDown);
    //}else {
      legsMotorsMove(RobotMap.BLASTOFF_LEGS_DOWN_SPEED);
     // SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
  } 

  public void legsOff() {
    //  Power the Lift Off.
    legsMotorsMove(RobotMap.BLASTOFF_LEGS_STOP_SPEED);	
    //SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
  }
  
  public void legsMove(double power) {
    //  PID method used to move the lift up/down
    //SmartDashboard.putNumber("Lift Encoder Position: ", Robot.lift.getDistance());
    //SmartDashboard.putNumber("Lift Power", power);
    
    //  This if/else-if/else is used to throttle the lift's speed to not jam it and damage it or
    //   torque it on top of the robot and make it tipsy.
    
     if (Robot.blastOffPIDSubsystem.getSetpoint() < Robot.blastOffPIDSubsystem.getDistance()) {
      legsMotorsMove(power);
    }	
   }
  
  public void log() {
  }

  public static double getDistance() {
  return legsEncoder.getDistance();
  }

  public void resetLiftEncoder()  {
  legsEncoder.reset();
  }

  public void wheelsForward(){
    wheelsMotor.set(RobotMap.BLASTOFF_WHEELS_FORWARD_SPEED);
  }

  //  Reverse the motors on the Blastoff Foot
  public void wheelsReverse(){
    wheelsMotor.set(RobotMap.BLASTOFF_WHEELS_REVERSE_SPEED);
  }

  public void wheelsSetMotor(double move){
    wheelsMotor.set(move);
  }

  //  Stop the motors on the Blastoff foot
  public void wheelsStopMotor(){
    wheelsMotor.stopMotor();   
  }

  public void dinoArmGrab(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void dinoArmUnGrab(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

}
