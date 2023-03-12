// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutodriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive mDrive;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  Timer mTimer;
  double mTimeout;
  public AutodriveCommand(Drive drive, double timeout) {
    mDrive = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    mTimer = new Timer();
    mTimeout = timeout;
    addRequirements(drive);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  //  Drive.goForward();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mTimer.stop();
    mTimer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return mTimer.get() > mTimeout;
  }
}
