/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import java.util.concurrent.Phaser;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.WarpDriveSubsystem;
import frc.robot.subsystems.BlackHoleSubsystem;
import frc.robot.subsystems.BlastOffPIDSubsystem;
import frc.robot.subsystems.NoseConeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.PhasersSubsystem;
import frc.robot.PhaserConstants;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Declare our Subsystems
  public static WarpDriveSubsystem warpDriveSubsystem;
  public static LimelightSubsystem limeLightSubsystem;
  public static NoseConeSubsystem noseConeSubsystem;
  public static PhasersSubsystem phasersSubsystem;
  public static BlackHoleSubsystem blackHoleSubsystem;
  //public static BlastOffSubsystem blastOffSubsystem;
  public static BlastOffPIDSubsystem blastOffPIDSubsystem;

  //CARRY MODE is a variable that we will use to determine what the Robot is carrying in
  //   its BlackHole Cargo Container..
  //   Whenever we intake a Cargo Ball (EventHorizonIntakeCommand) -> carryMode = CARGO
  //   Whenever we use the plunger (BlackHolePlungeCommand) -> carryMode = NONE
  //   Whenever we open the NoseCone (NoseconeOpenCommand) -> carryMode = HATCH
  //   Whenever we close the NoseCone (NoseconeCloseCommand) -> carryMode = NONE
  //
  //   We will need this later when we are determining how to position the BlackHole Cargo Carrier when we 
  //     are moving the Arm.
  public static int carryMode;

  public static OI oi;


  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  SendableChooser<Double> phaserChooser = new SendableChooser<>();
  SendableChooser<Integer> carryChooser = new SendableChooser<>();
  SendableChooser<Integer> habitatChooser = new SendableChooser<>();


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */

  @Override
  public void robotInit() {
    //Initiate our subystems
    System.out.println("Initiating the Warp Drive Subsystem.");
    warpDriveSubsystem = new WarpDriveSubsystem();
    System.out.println("Initiating the Limelight Subsystem.");
    limeLightSubsystem = new LimelightSubsystem();
    System.out.println("Initiating the NoseCone Subsystem.");
    noseConeSubsystem = new NoseConeSubsystem();
    System.out.println("Initiating the BlackHole Subsystem.");
    blackHoleSubsystem = new BlackHoleSubsystem();
    System.out.println("Initiating the Phasers Subsystem.");
    phasersSubsystem = new PhasersSubsystem();
    System.out.println("Initiating the BlastOff Subsystem.");
    //blastOffSubsystem = new BlastOffSubsystem();
    blastOffPIDSubsystem = new BlastOffPIDSubsystem();
    

    //Initiate the OI LAST!!!!
    System.out.println("Initiating the OI Subsystem.");
    oi = new OI();

    //RESET OUR GYRO 
    System.out.println("Resetting the Gyro.");
    Robot.warpDriveSubsystem.resetGyro();
    //RESET OUR DRIVETRAIN ROTARY ENCODERS
    System.out.println("Resetting Warp Drive Encoders.");
    Robot.warpDriveSubsystem.resetEncoders(); 

    //Turn on the Camera Server for the Dashboard
		System.out.println("Starting the camera server.");
		CameraServer.getInstance().startAutomaticCapture();
    System.out.println("Camera Server started.");
    
    //Set up the Limelight Camera to Camera Mode with LED's on..
   // System.out.println("Configuring Limelight...");
    //Robot.limeLightSubsystem.setCameraMode(LimeLightConstants.LIMELIGHT_CAMMODE_DRIVER);
    //Robot.limeLightSubsystem.setStreamingMode(LimeLightConstants.LIMELIGHT_STREAMING_STANDARD_MODE);
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_PIPELINE_DEFAULT);


    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

      //   Put the Phaser Choosers colors into the Subsystem
    phaserChooser.setDefaultOption("Default", PhaserConstants.PHASERS_DEFAULT);
    phaserChooser.addOption("Glitter", PhaserConstants.PHASERS_GLITTER_PALETTE);
    phaserChooser.addOption("Ocean", PhaserConstants.PHASERS_OCEAN_PALETTE);
    phaserChooser.addOption("Hot Pink!!!!!", PhaserConstants.PHASERS_HOT_PINK);
    phaserChooser.addOption("Fire Large", PhaserConstants.PHASERS_FIRE_LARGE);
    phaserChooser.addOption("Red", PhaserConstants.PHASERS_CHASE_RED);
    phaserChooser.addOption("Blue", PhaserConstants.PHASERS_CHASE_BLUE);
    
    //starting position of NoseCone
    carryChooser.setDefaultOption("Hatch", 0);
    carryChooser.addOption("Cargo", 1);

    //habitat we are starting from
    habitatChooser.setDefaultOption("Low", 0);
    habitatChooser.addOption("Medium", 1);
    
    //  Put all of the Subsystem Objects into the Smart Dashboard
    SmartDashboard.putData(warpDriveSubsystem);
    SmartDashboard.putData(blackHoleSubsystem);
    SmartDashboard.putData(blastOffPIDSubsystem);
    SmartDashboard.putData(noseConeSubsystem);
    SmartDashboard.putData(Robot.warpDriveSubsystem.gyro);

    //Initial Robot positions on power up..
    Robot.noseConeSubsystem.reverseTheAlex();
    Robot.noseConeSubsystem.openNoseCone();
    Robot.blackHoleSubsystem.unBoom();

    }

  
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  
   }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
     /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }


      Robot.noseConeSubsystem.openNoseCone();
      Robot.noseConeSubsystem.forwardTheAlex();
    
    //  Turning Limelight LEDs on
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_PIPELINE_DEFAULT);

    //  Zero out and reset all of our encoders...
    Robot.blastOffPIDSubsystem.resetLiftEncoder(); 

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    //Turning Limelight LEDs on.
    Robot.limeLightSubsystem.setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_PIPELINE_DEFAULT);

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
  
//Initialize a TalonSRX Motor controller and set our default settings.
  public static void initMotorController(WPI_TalonSRX talon) {
    System.out.println("Initializing Talon SRX: " + talon);
    talon.configFactoryDefault();
    talon.setNeutralMode(NeutralMode.Coast);  //Neutral Mode is Coast
    talon.neutralOutput();
    talon.setSensorPhase(false);
    talon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    talon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    talon.configNominalOutputForward(0.0, 0);
    talon.configNominalOutputReverse(0.0, 0);
    talon.configClosedloopRamp(0.5, 0);
  }

  //Initialize a VictorSPX Motor controller and set our default settings.
  public static void initMotorController (WPI_VictorSPX victor) {
    System.out.println("Initializing Victor SPX: " + victor);
    victor.configFactoryDefault();
    victor.setNeutralMode(NeutralMode.Coast);  //Neutral Mode is Coast
    victor.neutralOutput();
    victor.setSensorPhase(false);
    victor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    victor.configNominalOutputForward(0.0, 0);
    victor.configNominalOutputReverse(0.0, 0);
    victor.configClosedloopRamp(0.1, 0);    
  }

  //Get the amount of time left in the Match from the DriverStation.
  //NOTE:  The time is a double and is in seconds.
  //       An entire match is 180 seconds
  //       Auton would be:  0 - 15 seconds
  //       TeleOp would be:  15 seconds - 149 seconds
  //       EndGame would be:  150 - 180 seconds
  public static double getMatchTime(){
    return DriverStation.getInstance().getMatchTime();
  }

  //  Returns the mode of the match we are in..    
  //    *   Auto, Telop, etc.
  public static boolean inAutonmousMode(){
    return DriverStation.getInstance().isAutonomous();
  }

 
  // Get our Alliance color from the DriverStation..   We may use this later to determine our LED Colors..
  public static Alliance getAllianceColor(){
    DriverStation.Alliance color;
    color = DriverStation.getInstance().getAlliance();
    System.out.println("Our Alliance Color is:  " + color);
    return color;
  }

  //  If we want to use this..   Set our LED Color to our Alliance color..
  public void setPhaserColorToAllianceColor(){
    if (getAllianceColor() == DriverStation.Alliance.Blue){
      System.out.println("Phasers set to:  BLUE");
      Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_CHASE_BLUE);
    }
    else{
      System.out.println("Phasers set to:  RED");
      Robot.phasersSubsystem.setPhasers(PhaserConstants.PHASERS_CHASE_RED);
    }
  }

}
