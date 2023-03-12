// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private CommandXboxController mPilot = new CommandXboxController(0);

  private final WPI_TalonFX mBackLeftMotor = new WPI_TalonFX(7);
  private final WPI_TalonFX mFrontLeftMotor = new WPI_TalonFX(6);
  private final WPI_TalonFX mBackRightMotor = new WPI_TalonFX(5);
  private final WPI_TalonFX mFrontRightMotor = new WPI_TalonFX(4);

  private Timer mTimer = new Timer();

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    mFrontRightMotor.setInverted(true);
    mBackRightMotor.setInverted(true);
    mBackRightMotor.follow(mFrontRightMotor);
    mBackLeftMotor.follow(mFrontLeftMotor);

    m_myRobot = new DifferentialDrive(mFrontLeftMotor, mFrontRightMotor);

  }

  @Override
  public void autonomousInit() {
    mTimer.start();
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(-mPilot.getLeftY(), -mPilot.getRightY());
  //  m_myRobot.tankDrive(-m_leftStick.getY(), -m_rightStick.getY());
  }

  @Override
  public void autonomousPeriodic() {
    if (mTimer.get() < 3) {
      System.out.println(mTimer.get());
    m_myRobot.tankDrive(0.4, 0.4);
  } 
    else {
      m_myRobot.tankDrive(0, 0);
    }
  

  }

}
