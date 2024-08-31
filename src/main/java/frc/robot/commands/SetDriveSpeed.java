// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// RUNS WHILE THE FULL SPEED BUTTON IS PRESSED

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.DriveConstants;

public class SetDriveSpeed extends CommandBase {
  private final TankDrive m_drive;
  private static double fullSpeed = DriveConstants.kSlowModePower;

  public SetDriveSpeed(TankDrive drive) {
    m_drive = drive;
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Slow Mode?", false);
    fullSpeed = fullSpeed + DriveConstants.kFullSpeedRateLimit;
    m_drive.setMaxOutput(fullSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Slow Mode?", true);
    m_drive.setMaxOutput(DriveConstants.kSlowModePower); // button is unpressed, so back to slow mode we go
    fullSpeed = DriveConstants.kSlowModePower;
  }
}
