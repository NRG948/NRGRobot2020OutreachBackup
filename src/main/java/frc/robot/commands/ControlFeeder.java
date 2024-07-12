// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Feeder;

public class ControlFeeder extends CommandBase {
  Feeder feeder;
  // final GenericHID joystick;
  final JoystickButton m_button4;
  final JoystickButton m_button5;

  final double INDEXER_POWER = 0.5;

  double indexerPower;

  /** Creates a new ControlFeeder. */
  public ControlFeeder(Feeder feeder, JoystickButton m_button4, JoystickButton m_button5) {
    this.feeder = feeder;
    this.m_button4 = m_button4;
    this.m_button5 = m_button5;
    addRequirements(feeder);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    indexerPower = m_button4.getAsBoolean() ? INDEXER_POWER : (m_button5.getAsBoolean() ? -INDEXER_POWER : 0.0);
    feeder.rawFeeder(indexerPower);
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
