// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Feeder extends SubsystemBase {

  private Victor feederMotor = new Victor(IntakeConstants.kFeederMotorPort);

  /** Creates a new Feeder. */
  public Feeder() {
    // Sets the feeder motor to inverted
    feederMotor.setInverted(false);
  }

  public void rawFeeder(double power) {
    feederMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
