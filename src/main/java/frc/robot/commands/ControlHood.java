// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Hood;

public class ControlHood extends Command {
  private final Hood hood;
  private final CommandXboxController m_XboxController;
  private double power = 0;

  /** Creates a new ControlHood. */
  public ControlHood(Hood hood, CommandXboxController xboxController) {
    this.hood = hood;
    this.m_XboxController = xboxController;
    addRequirements(hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_XboxController.getHID().getPOV() == 0) {
      power = 0.2; // no longer HOOD_MANUAL_MOTOR_POWER from the 2020 NRGPreferences.java
    } else if (m_XboxController.getHID().getPOV() == 180) {
      power = -0.2; // no longer HOOD_MANUAL_MOTOR_POWER from the 2020 NRGPreferences.java
    } else {
      power = 0;
    }
    hood.rawHood(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
