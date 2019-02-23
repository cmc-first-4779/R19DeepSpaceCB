/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.commands.EventHorizon.EventHorizonRetractCommand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * THE EVENT HORIZON Subsystem is the CARGO BALL INTAKE. IT IS Driven by one
 * Motor on a SPARK controller
 */
public class EventHorizonSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Declare the SPARK Controller for our Motor
  Spark eventHorizonMotor;

  // Declare our double solenoids
  DoubleSolenoid eventHorizonSolenoid;

  //Declare our limit switch in the box that detects if we have a ball..
  DigitalInput limitSwitch;
  //  Declare our counter for the limit switch
  Counter limitCounter;


  public EventHorizonSubsystem() {

    // Initiate our Spark Controller for the motor
    eventHorizonMotor = new Spark(RobotMap.PWM_PORT_EVENTHORIZON_WHEELS);

    // Initiate our solenoids
    eventHorizonSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_EVENTHORIZON_RAISE,
      RobotMap.PCM_PORT_EVENTHORIZON_LOWER);

    // Initiate our Limit Switch and Limit Counter
    limitSwitch = new DigitalInput(RobotMap.DIO_PORT_BLACKHOLE_LIMITSWITCH);
    limitCounter = new Counter(limitSwitch);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //
    //  DEFAULT COMMAND:  KEEP THE EVENT HORIZON ARMS RAISED UP
     setDefaultCommand(new EventHorizonRetractCommand());
  }

  // Spin the Event Horizon Wheels to suck in a ball into the "BLACK HOLE" cargo
  //     holder.
  public void startWheelMotor() {
    eventHorizonMotor.set(RobotMap.EVENTHORIZON_INTAKE_MOTOR_SPEED);
  }

  // Not sure if we will need this, but it will spin the Event Horizon wheels
  //     backwards
  public void reverseWheelMotor() {
    eventHorizonMotor.set(RobotMap.EVENTHORIZON_REVERSE_MOTOR_SPEED);
  }

  // Stop the Event Horizon Wheels
  public void stopWheelMotor() {
    eventHorizonMotor.stopMotor();
  }

  // Raise Event Horizon Arms using pneumatics
  public void raiseEventHorizonArm() {
    eventHorizonSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  // Lower Event Horizon Arms using pneumatics
  public void lowerEventHorizonArm() {
    eventHorizonSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void suckInCargo()  {
    //  Lower the Event Horizon Arm...
    lowerEventHorizonArm();
     //  Start the wheel motors when lowering the Event Horizon Arm
    startWheelMotor();
  }

  public void retractEventHorizon()  {
    //  Stop the Wheel Motors
    stopWheelMotor();
    //  Raise the Event Horizon Arm
    raiseEventHorizonArm();
  }

  //  Check our limit switch and return whether the switch is set..    
  public boolean isBallInBox() {
    //  If there is a ball in the box, it will return "TRUE"
    return limitCounter.get() > 0;
  }

    //  Reset our Limit Switch Counter to ZERO
  public void initializeCounter() {
    limitCounter.reset();
  }  

}
