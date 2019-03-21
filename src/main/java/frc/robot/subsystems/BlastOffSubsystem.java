/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.BlastOff.BlastOffLandCommand;
import frc.robot.commands.BlastOff.BlastOffStopMotorCommand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

import javax.swing.text.StyleContext.SmallAttributeSet;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Add your docs here.
 */
public class BlastOffSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //  Declare the BlastOff Motor
  Spark blastOffLegs;
  Spark blastOffWheels;
  //  Decare the BlastOff Solenoid
  DoubleSolenoid dinoArmsSolenoid;
  //  Declare the Blastoff Wheel Encoder
  public Encoder encoder;

  public BlastOffSubsystem(){
    //Init our Spark Motor Controller for wheels
    blastOffWheels = new Spark(RobotMap.PWM_PORT_BLASTOFF_WHEELS);
    //Init our Spark Motor Controller for Dino Legs
    blastOffLegs = new Spark(RobotMap.PWM_PORT_BLASTOFF_LEGS);
    //Init our Double Solenoid
    dinoArmsSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_DINO_ARMS_GRAB, RobotMap.PCM_PORT_DINO_ARMS_UNGRAB);   
    //Init the encoder
    encoder = new Encoder(RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A, RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B);
    //Set the Encoder Distance per Pulse
    encoder.setDistancePerPulse(RobotMap.BLASTOFF_DISTANCE_PER_PULSE);
  }

  @Override
  public void initDefaultCommand() {
    // Default Command for the Blastoff subsystem is the retract / "land" the pneumatics
    setDefaultCommand(new BlastOffLandCommand());
  }

  //Launches the Robot onto the top habitat platform
  public void launch(){
    //Get the time of the match...
    double matchTime;
    matchTime = Robot.getMatchTime();
    //LAUNCH ON TO THE PLATFORM IF AND ONLY IF, WE ARE IN THE ENDGAME AND READY TO USE THE BIG SOLENOID!!!!
    //  Check to see if we are NOT in Auton...
    //if (!Robot.inAutonmousMode()){
      //   We have have less than or equal to "OK TIME TO LAUNCH" seconds remaining in the match..
     // if (matchTime <= RobotMap.BLASTOFF_OK_TIME_TO_LAUNCH){
        //  If the Proximity Sensor voltage is less than our threshold and we are close to the high hab platform
  //      if (getProximityVoltage() <= RobotMap.BLASTOFF_PROXIMITY_SENSOR_THRESHOLD_VOLTAGE){
          dinoArmsSolenoid.set(DoubleSolenoid.Value.kForward);
          

  //      }  
  //      else{
   //       System.out.println("Too far from the platform.  Voltage:  " + getProximityVoltage());  
   //       SmartDashboard.putNumber("Proximity Sensor", getProximityVoltage());
    //    }
      //} 
      //else {
       // System.out.println("Match time does not equal:  " + RobotMap.BLASTOFF_OK_TIME_TO_LAUNCH);
     // }
    //}
    //else{
     // System.out.println("We are in Auton.  No Blastoff for you!!");
    //}
  }

  //  Move the robot forward with the blastoff wheels onto the high Habitat Platform
  public void wheelsForward(){
    blastOffWheels.set(RobotMap.BLASTOFF_WHEELS_FORWARD_SPEED);
  }

  //  Reverse the motors on the Blastoff Foot
  public void wheelsReverse(){
    blastOffWheels.set(RobotMap.BLASTOFF_WHEELS_REVERSE_SPEED);
  }

  public void wheelsSetMotor(double move){
    blastOffWheels.set(move);
  }

  //  Stop the motors on the Blastoff foot
  public void wheelsStopMotor(){
    blastOffWheels.stopMotor();   
  }

  //  Reset the BlastOff Encoder
  public void resetEncoder() {
    encoder.reset();
  }

  public void dinoArmGrab(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void dinoArmUnGrab(){
    dinoArmsSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void launchLegs(){
    blastOffLegs.set(RobotMap.BLASTOFF_LEGS_UP_SPEED);
    SmartDashboard.putNumber("BlastOff Legs Encoder", encoder.getDistance());
  }

  public void landLegs(){
    blastOffLegs.set(RobotMap.BLASTOFF_LEGS_DOWN_SPEED);
    SmartDashboard.putNumber("BlastOff Legs Encoder", encoder.getDistance());
  }

  public void legsSetMotor(double move){
    blastOffLegs.set(move);
    SmartDashboard.putNumber("BlastOff Legs Encoder", encoder.getDistance());
  }

  public void stopLegs(){
    blastOffLegs.stopMotor();
    SmartDashboard.putNumber("BlastOff Legs Encoder", encoder.getDistance());
  }

}
