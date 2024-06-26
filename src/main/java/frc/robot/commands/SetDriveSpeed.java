// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.DriveConstants;

public class SetDriveSpeed extends CommandBase {
  private final TankDrive m_drive;
  private static double fullSpeed = DriveConstants.kSlowModePower;

  public SetDriveSpeed(TankDrive drive) {
    m_drive = drive;
  }

  @Override
  public void initialize() {
    m_drive.setMaxOutput(DriveConstants.kActualSlowPower);
  }
  @Override
  public void execute() {
    // fullSpeed = fullSpeed + DriveConstants.kFullSpeedRateLimit;
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.setMaxOutput(DriveConstants.kSlowModePower);
    fullSpeed = DriveConstants.kSlowModePower;
  }
}
