// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  public Intake() {
  }

  private final PWMSparkMax intakeMotor = new PWMSparkMax(IntakeConstants.kIntakeMotorPort);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  private static final double MAX_ACQUIRER_POWER = 1;

  public enum State {
    INTAKING, EJECTING, STATIC;
  }

  public State state;

  public void rawIntake(final double power) {
    double sentPower = MathUtil.clamp(power, -MAX_ACQUIRER_POWER, MAX_ACQUIRER_POWER);
    // Decides if intake is intaking or ejecting
    if (sentPower > 0) {
      state = State.INTAKING;
    } else if (sentPower < 0) {
      state = State.EJECTING;
    } else {
      state = State.STATIC;
    }
    intakeMotor.set(sentPower);
  }

  public void stop() {
    intakeMotor.stopMotor();
  }

  public State getState() {
    return state;
  }
}
