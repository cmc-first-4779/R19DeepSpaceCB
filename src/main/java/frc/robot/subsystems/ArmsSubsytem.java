/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Arms.ArmsMoveWithJoystickCommand;

/**
 *   ARM Subsystem - We use this to move our Robot's Arms up and down..
 */
public class ArmsSubsytem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declare our two Talons to drive our Arm Motors.
  public WPI_TalonSRX armMaster;
  public WPI_TalonSRX armSlave;

  //   Set the starting armHeight to ZERO.
  public double armHeight = 0;

  //Declare our limit switch that determines if the Arm is up too high..
  //DigitalInput limitSwitch;


  public ArmsSubsytem() {
    //Initiate the Arm Talon objects
    armMaster = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM_MASTER);
    armSlave = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_ARM_SLAVE);
    //Initiatlize both of the Talons
    Robot.initMotorController(armMaster);
    Robot.initMotorController(armSlave);
    //Slave the armSlave motor to the armMaster
    armSlave.follow(armMaster);
    //Setup our PID values on the encoder
    armMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    armMaster.config_kP(0, .03, 0);
    armMaster.config_kI(0, 0, 0);
    armMaster.config_kD(0, 2.5, 0);
    armMaster.config_kF(0, 0, 0);
    armMaster.configAllowableClosedloopError(0, 5000, 0);
    
    armMaster.setSensorPhase(false);
    armMaster.enableCurrentLimit(true);
    armMaster.configPeakCurrentLimit(40);
    //Set the normal max voltage so that if you set percent out to .5 you get 6 volts always no matter what level the battery is
    armMaster.configVoltageCompSaturation(12, 0);
    armMaster.enableVoltageCompensation(true);
    //Reset the encoder to 0
    armMaster.setSelectedSensorPosition(0, 0, 0);
    //Setup the Izone so that the accumulated error is ignored unless it's under this number
    armMaster.config_IntegralZone(0, 1000);
    //Setup the cruise and acceleration rates for MotionMagic.
    armMaster.configMotionCruiseVelocity(51000, 0); //Just guessing at theses numbers.  I don't think motor ever spin this quickly with our setup
    armMaster.configMotionAcceleration(50000, 0);
    armMaster.configNominalOutputForward(0, 0); //the minimal amount of voltage the motors output in forward
    armMaster.configNominalOutputReverse(0, 0); //th minimal amount of voltage the motors output in reverse
    armMaster.configPeakOutputForward(1, 0);
    armMaster.configPeakOutputReverse(-1, 0);
    //Configure the soft limits of the arms
    armMaster.configForwardSoftLimitThreshold(RobotMap.ARM_MAX_HEIGHT);
    armMaster.configForwardSoftLimitEnable(true);
  }

  @Override
  public void initDefaultCommand() {
    // Default Command for the armSubystem is to move the Arm with the Joystick
    setDefaultCommand(new ArmsMoveWithJoystickCommand());
  }

  /**
   * Sets the arm to a particular setpoint using motion magic control mode to make the movement smooth.
   * @param height
   */
   public void setSetPoint() {
    //CHECK TO MAKE SURE WE ARE NOT GOING ABOVE OUR MAX HEIGHT!!!
    if (armHeight < RobotMap.ARM_MAX_HEIGHT){
      armMaster.set(ControlMode.MotionMagic, armHeight);
          // Put the Arm Subsystem SetPoint into the Dashboard
      SmartDashboard.putNumber("ARM SetPoint", armHeight);
    }
    else {
      System.out.println("ARM AT MAX HEIGHT!  I REFUSE TO TIP THIS ROBOT!!");
    }

    //Put the Arm Encoder Position into the Dashboard
    SmartDashboard.putNumber("ARM Position", getEncoderPosition());
  }

  //Reset the encoder on our Arm Master Talon.
  public void resetEncoder() {
    armMaster.setSelectedSensorPosition(0);
  }

  //  Get the ARM Encoder position
  public double getEncoderPosition() {
    return armMaster.getSelectedSensorPosition();
  }

  //   Set the ARM Height
  public void setArmHeight(double height) {
    if (height >= 0 && height <= RobotMap.ARM_MAX_HEIGHT) {
      this.armHeight = height;
    }
  }

  //  Return the ARM height..
  public double getArmHeight() {
    return armHeight;
  }

  //Set Talon target to 0
  public void zeroSetPoint(){
    armMaster.set(ControlMode.MotionMagic, 0);
    armMaster.set(ControlMode.PercentOutput, 0 );
    System.out.println("Trying to zero arm Talon");
    System.out.println("Arm Motor setpoint should be 0: " + armMaster.getSelectedSensorPosition());
  }

  //   We call this method when we Launch so that the arms get more power to balance out the robot.
  public void configArmForBlastOff(){
    //  Adjust kP on the ARM for Blastoff...
    armMaster.config_kP(0, .06, 0);
    //  Change the Talon Control Mode from Motion Magic to PercentOutput and change the value output..
    armMaster.set(ControlMode.PercentOutput, 0.5);
  }

}
