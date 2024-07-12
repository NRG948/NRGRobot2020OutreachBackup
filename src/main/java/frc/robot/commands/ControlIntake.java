// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;

public class ControlIntake extends CommandBase {
  Intake intaker;
  //final CommandXboxController m_xboxController;
  final JoystickButton m_button1;
  final JoystickButton m_button2;

  final double INTAKE_POWER = 0.8;

  double intakePower = 0;

  /** Creates a new ControlIntake. */
  public ControlIntake(Intake intaker, JoystickButton button1, JoystickButton button2) {
    this.intaker = intaker;
    //m_xboxController = xboxcontroller;
    m_button1 = button1;
    m_button2 = button2;
    addRequirements(intaker);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakePower = m_button1.getAsBoolean() ? -INTAKE_POWER : (m_button2.getAsBoolean() ? INTAKE_POWER : 0.0);
    intaker.rawIntake(intakePower);
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
