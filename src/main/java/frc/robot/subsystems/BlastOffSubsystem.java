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
  Spark blastOffMotor;
  //  Decare the BlastOff Solenoid
  DoubleSolenoid blastOffSolenoid;
  DoubleSolenoid blastoffFrontSolenoid;
  //  Declare the Blastoff Wheel Encoder
  public Encoder encoder;
  //  Declare the Proximity Sensor as an Analog Sensor
  AnalogInput proximitySensor;

  public BlastOffSubsystem(){
    //Init our Spark Motor Controller
    blastOffMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF);
    //Init our Double Solenoid
    blastOffSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_BLASTOFF_LAUNCH, RobotMap.PCM_PORT_BLASTOFF_LAND);
    blastoffFrontSolenoid = new DoubleSolenoid(4, 5);
    //Init the encoder
    encoder = new Encoder(RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_A, RobotMap.DIO_PORT_BLASTOFF_ENCODER_CHANNEL_B);
    //Set the Encoder Distance per Pulse
    encoder.setDistancePerPulse(RobotMap.BLASTOFF_DISTANCE_PER_PULSE);
    //  Init the Proximity Sensor
    proximitySensor = new AnalogInput(RobotMap.ANALOG_PORT_BLASTOFF_PROXIMITY_SENSOR);
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
          blastOffSolenoid.set(DoubleSolenoid.Value.kForward);
          blastoffFrontSolenoid.set(DoubleSolenoid.Value.kForward);
          
          SmartDashboard.putNumber("Proximity Sensor", getProximityVoltage());

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


  //   Pull the pneumatic back up
  public void land(){
    blastOffSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

    //Pull the front pneumatics back up..
  public void landFront(){
    blastoffFrontSolenoid.set(DoubleSolenoid.Value.kReverse);
    blastOffSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  //  Move the robot forward with the blastoff wheels onto the high Habitat Platform
  public void forward(){
    blastOffMotor.set(RobotMap.BLASTOFF_FORWARD_SPEED);
    SmartDashboard.putNumber("BlastOff Encoder", encoder.getDistance());
  }

  //  Reverse the motors on the Blastoff Foot
  public void reverse(){
    blastOffMotor.set(RobotMap.BLASTOFF_REVERSE_SPEED);
    SmartDashboard.putNumber("BlastOff Encoder", encoder.getDistance() );
  }

  public void setMotor(double move){
    blastOffMotor.set(move);
  }

  //  Stop the motors on the Blastoff foot
  public void stopMotor(){
    blastOffMotor.stopMotor();
    SmartDashboard.putNumber("BlastOff Encoder", encoder.getDistance() );
  }

  //  Return the voltage off of the Proximity Sensor
  public double getProximityVoltage() {
    SmartDashboard.putNumber("Proximity Sensor Voltage", proximitySensor.getVoltage());
    return proximitySensor.getVoltage();
  }

  //  Reset the BlastOff Encoder
  public void resetEncoder() {
    encoder.reset();
  }

public void launchFront() {
  blastoffFrontSolenoid.set(DoubleSolenoid.Value.kForward);
}

}
