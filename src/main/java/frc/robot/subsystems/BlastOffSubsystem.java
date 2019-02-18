/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class BlastOffSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Spark blastOffMotor;
  DoubleSolenoid blastOffSolenoid;

  public BlastOffSubsystem(){
    
    //Init our Spark Motor Controller
    blastOffMotor = new Spark(RobotMap.PWM_PORT_BLASTOFF);
    //Init our Double Solenoid
    blastOffSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT_BLASTOFF_LAUNCH, RobotMap.PCM_PORT_BLASTOFF_LAND);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //
    //  NO DEFAULT COMMAND HERE!!!   WE CAN"T USE BLACKHOLE UNTIL THE VERY END
  }

  //Launches the Robot onto the top habitat platform
  public void launch(){
    //Get the time of the match...
    double matchTime;
    matchTime = Robot.getMatchTime();
    //LAUNCH ON TO THE PLATFORM IF AND ONLY IF, WE ARE IN THE ENDGAME AND READY TO USE THE BIG SOLENOID!!!!
    if (matchTime > RobotMap.BLASTOFF_OK_TIME_TO_LAUNCH){
        blastOffSolenoid.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void land(){
    blastOffSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void forward(){
    blastOffMotor.set(RobotMap.BLASTOFF_FORWARD_SPEED);
  }

  public void reverse(){
    blastOffMotor.set(RobotMap.BLASTOFF_REVERSE_SPEED);
  }

  public void stopMotor(){
    blastOffMotor.stopMotor();
  }


}
