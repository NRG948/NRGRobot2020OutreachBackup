// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Turret;

public class ControlTurret extends Command {
  final CommandXboxController xboxController;
  final Turret turret;
  private double power;


  /** Creates a new ControlTurret. */
  public ControlTurret(Turret turret, CommandXboxController xboxController) {
    this.turret = turret;
    this.xboxController = xboxController;
    addRequirements(turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    power = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(xboxController.getHID().getPOV() == 90){
      power = -0.2; // Negative TURRET_MOTOR_POWER in NRGPreferences.java
    }
    else if(xboxController.getHID().getPOV() == 270){
      power = 0.2; // TURRET_MOTOR_POWER in NRGPreferences.java
    } else {
      power = 0;
    }
    turret.rawTurret(power);
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
