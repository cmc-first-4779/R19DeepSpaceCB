/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Misc;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *  The TimerCommand command allows us to use a timer in any Command or Command Group we would like.
 */

public class TimerCommand extends Command {

	Timer timer = new Timer();
	private double m_time;
	
	//  Send in a double for time in seconds(s).
    public TimerCommand(double time) {
    	m_time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();  //Reset the timer.
    	timer.start();  //Start the timer.
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//  If our timer is less than the time we want it to run, keep running the command.
    	if (timer.get() < m_time) {
    		return false;
    	}
    	//  Else once we hit our alloted time, exit out of the command.
    	else
    		return true; 
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();  //Stop the timer
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	timer.stop();  //Stop the timer
    }
}