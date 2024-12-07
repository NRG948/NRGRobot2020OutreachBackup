// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Feeder;

public class ControlFeeder extends Command {
  Feeder feeder;
  final CommandXboxController m_XboxController;

  /** Creates a new ControlFeeder. */
  public ControlFeeder(Feeder feeder, final CommandXboxController XboxController) {
    this.feeder = feeder;
    this.m_XboxController = XboxController;
    addRequirements(feeder);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.rawFeeder(m_XboxController.getLeftY() * 0.5);
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
