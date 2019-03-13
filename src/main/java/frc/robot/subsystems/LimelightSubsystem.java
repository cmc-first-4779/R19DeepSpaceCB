package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.LimeLightConstants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.commands.Limelight.LimeLightSetCameraModeCommand;
import frc.robot.commands.Limelight.LimeLightSetDriverLEDModeOnCommand;

/**
 *
 */
public class LimelightSubsystem extends Subsystem {

	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");

	//read values periodically
	double x = tx.getDouble(0.0);
	double y = ty.getDouble(0.0);
	double area = ta.getDouble(0.0);

	//post to smart dashboard periodically
//	SmartDashboard.putNumber("LimelightX", x);
//	SmartDashboard.putNumber("LimelightY", y);
//	SmartDashboard.putNumber("LimelightArea", area);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		//
		//By Default, put the Camera Mode into Driver Mode and turn the LEDs on
		setDefaultCommand(new LimeLightSetDriverLEDModeOnCommand());
    }
    
	//SET THE LIMELIGHT CAMERA MODE
	//  0 = Limelight Vision.  VISION PROCESSING
	//  1 = Driver Camera (Increases exposure, disables vision processing)
    public void setCameraMode(double camMode) {
    	NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(camMode);
    }
    
	//  TURN THE LIMELIGHT LED LIGHTS ON AND OFF
	//  0 = use the LED Mode set in the current pipeline
	//  1 = Force the LEDs OFF
	//  2 = Force the LEDs to BLINK
	//  3 = Force the LEDs ON
    public void setLEDMode(double ledMode) {
    	NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(ledMode);
    }
	
	//  SET WHICH VISION PIPELINE WE WANT TO USE..
	//    Pipelines:   0 - 9
	//    Each pipeline can be configured for a specific vision target
    public void setPipeline(double pipeline) {
    	NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipeline);
    } 
	
	//  Return TX, which is the Horizontal Offset From Crosshair To Target (-27 degrees to 27 degrees)
	public double getTX() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
	}
	
	//  Returns TY, which is the Vertical Offset From Crosshair To Target (-20.5 degrees to 20.5 degrees)
	public double getTY() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
	}
	
	//  Returns TV, which is whether the limelight has any valid targets 
	//   0 = NO TARGET
	//   1 = TARGET
	public double getTV() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
	}
	
	//  Returns TA, which is the Target Area (0% of image to 100% of image)
	public double getTA() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
	}
	

	//  Returns TS, which is the Skew or rotation (-90 degrees to 0 degrees)
	public double getTS() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
	}
		
	public double getNX()  {
		double NX = (1/(LimeLightConstants.LIMELIGHT_X_PIXEL_COUNT/2))*(getTX() - ((LimeLightConstants.LIMELIGHT_X_PIXEL_COUNT/2)+0.5));
		return NX;
	}
	
	public double getNY()  {
		double NY = (1/(LimeLightConstants.LIMELIGHT_Y_PIXEL_COUNT/2))*(((LimeLightConstants.LIMELIGHT_Y_PIXEL_COUNT/2)+0.5)- getTY());
		return NY;
	}
	
	public double getViewPlaneWidth()  {
		double ViewPlaneWidth = 2.0 * Math.tan(LimeLightConstants.LIMELIGHT_X_PIXEL_COUNT/2);
		return ViewPlaneWidth;
	}
	
	public double getViewPlaneHeight()  {
		double ViewPlaneHeight = 2.0 * Math.tan(LimeLightConstants.LIMELIGHT_Y_PIXEL_COUNT/2);
		return ViewPlaneHeight;
	}
	
	public double getX()  {
		double x = getViewPlaneWidth() / 2 * getNX();
		return x;
	}
	
	public double getY()  {
		double y = getViewPlaneHeight() / 2 * getNY();
		return y;
	}
	
    public double getAX()  {
    	double AX = Math.atan2(RobotMap.LIMELIGHT_DISTANCE_FROM_TARGET, getX());
    	return AX;
    }	
    
    public double getAY()  {
    	double AY = Math.atan2(RobotMap.LIMELIGHT_DISTANCE_FROM_TARGET, getY());
    	return AY;
    }	
	
	//  Returns the approximate distance to the target..  
	//  NOTE:  AS PER LIMELIGHT, THIS IS NOT THE MOST OPTIMAL WAY TO ACQUIRE A TARGET.
    public double getDistance()  {
    	//double distance = (RobotMap.LIMELIGHT_CARGO_HEIGHT - RobotMap.LIMELIGHT_CAMERA_HEIGHT) / Math.tan(getAY() - RobotMap.LIMELIGHT_CAMERAMOUNT_ANGLE);
    	double distance =  4*Math.sqrt(getTA());
    	return distance;
	}
	
	//  Returns whether or not the Limelight has a target...
	public boolean hasTarget() {
		double tv = getTV();
		if (tv == LimeLightConstants.LIMELIGHT_NO_TARGET) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void setStreamingMode(double streamingMode){
		double m_streaming_mode = streamingMode;
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setNumber(m_streaming_mode);
		setLEDMode(LimeLightConstants.LIMELIGHT_LEDMODE_ON);
	}
    
}



