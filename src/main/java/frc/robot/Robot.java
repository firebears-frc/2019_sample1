/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick joystick;
  private Solenoid puncher;
  private DoubleSolenoid grabber;

  @Override
  public void robotInit() {
    m_myRobot = new DifferentialDrive(new DMC60(0), new DMC60(1));
    joystick = new Joystick(0);
    puncher = new Solenoid(2);
    grabber = new DoubleSolenoid(0, 1);
  }

  @Override
  public void teleopPeriodic() {

    double speed = joystick.getY();
    double rotation = joystick.getX();
    m_myRobot.arcadeDrive(speed, rotation);

    if (joystick.getRawButton(5)) {
      puncher.set(true);
    } else if (joystick.getRawButton(6)) {
      puncher.set(false);
    }

    if (joystick.getRawButton(3)) {
      grabber.set(DoubleSolenoid.Value.kForward);
    } else if (joystick.getRawButton(4)) {
      grabber.set(DoubleSolenoid.Value.kReverse);
    }

  }
}
