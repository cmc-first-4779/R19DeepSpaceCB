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

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.BlackHole.BlackHoleChillCommand;
import frc.robot.commands.BlackHole.SpinBlackHoleCommand;


/**
 * Add your docs here.
 */
public class BlackHoleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declare our Spinmotor controller as a Talon
  WPI_TalonSRX spinMotor;
  //Declare our Plunger as a Double Solenoid
  DoubleSolenoid plunger;

  //Angle the box should be at
  double boxAngle = 0;

  public BlackHoleSubsystem() {
    //Initiate our plunger and our spinMotor
    plunger = new DoubleSolenoid(RobotMap.PCM_PORT_PLUNGER_PLUNGE, RobotMap.PCM_PORT_PLUNGER_RETRACT);
    spinMotor = new WPI_TalonSRX(RobotMap.CAN_ADDRESS_BLACKHOLE);
    //Initialize the Talon settings on the spinMotor
    Robot.initMotorController(spinMotor);
    //Config the encoder on the spinMotor
    spinMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    spinMotor.setSelectedSensorPosition(0, 0, 0);
    //Set our PID values for our spinMotor
    spinMotor.config_kP(0, 0.01, 0);
    spinMotor.config_kI(0, 0, 0);
    spinMotor.config_kD(0, 0, 0);
    spinMotor.config_kF(0, 0, 0);
    spinMotor.setSensorPhase(true);
    spinMotor.configPeakCurrentLimit(10);
    spinMotor.configVoltageCompSaturation(12, 0);
    spinMotor.enableVoltageCompensation(true);
    spinMotor.config_IntegralZone(0, 50);
    spinMotor.configMotionCruiseVelocity(500, 0);
    spinMotor.configMotionAcceleration(500, 0);
    spinMotor.configNominalOutputForward(0, 0);
    spinMotor.configNominalOutputReverse(0, 0);
    spinMotor.configPeakOutputForward(1, 0);
    spinMotor.configPeakOutputReverse(-1, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //Default Command:   BLACK HOLE STAYS WHERE IT IS AT!!
    setDefaultCommand(new BlackHoleChillCommand());
  }

  //Spin the Black Hole Cargo Box around
  public void spin(double rate) {
    // spin the spinner forwards at a set speed
    if (rate > 0.25){
      spinMotor.set(ControlMode.PercentOutput, RobotMap.BLACK_HOLE_SPIN_FORWARD_SPEED);
    } else if (rate < -0.25) {
      spinMotor.set(ControlMode.PercentOutput, RobotMap.BLACK_HOLE_SPIN_REVERSE_SPEED);
    } else {
      spinMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  //Spin the Black Hole to a certain setpoint.
  public void rotateToSetPoint(double angle) {
    // do the math to figure out what the encoder count should be
    // Move arm to set point
    boxAngle = angle;
    spinMotor.set(ControlMode.Position, angle);
    //System.out.println("Encoder count: " + spinMotor.getSelectedSensorPosition());
  }

  //Spin the Black Hole to a certain setpoint.
  public void rotateToSetPoint() {
    // do the math to figure out what the encoder count should be
    // Move arm to set point
  //  spinMotor.set(ControlMode.MotionMagic, boxAngle);
    spinMotor.set(ControlMode.Position, boxAngle);
    //System.out.println("Encoder count: " + spinMotor.getSelectedSensorPosition());
  }


  //Eject the ball using the Plunger..  (Move the Plunger forward)
  public void plunge() {
    plunger.set(DoubleSolenoid.Value.kReverse);
  }

  //Retract the plunger after ejecting the ball...
  public void retractPlunger() {
    plunger.set(DoubleSolenoid.Value.kForward);
  }

  //Stop the motor from spinning!!
  public void stop() {
    spinMotor.stopMotor();
  }

  //Reset the encoder on our Arm Master Talon.
  public void resetEncoder() {
    spinMotor.setSelectedSensorPosition(0);
  }

  public double getEncoderPosition() {
    return spinMotor.getSelectedSensorPosition();
  }

  public void setBoxAngle(double angle) {
    System.out.println("Setting BoxAngle to " + angle);
    boxAngle = angle;
  }


  public double getBoxAngle( ){
    return boxAngle;
  }
}
