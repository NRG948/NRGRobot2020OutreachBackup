// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.ShooterConstants;

public class Hood extends SubsystemBase {
  private static final double HOOD_BACK_VOLTAGE_PRACTICE = 4.12;
  private static final double HOOD_VOLTAGE_RANGE_PRACTICE = 2.49;

  private static final double HOOD_BACK_VOLTAGE_COMPETITION = 3.99;
  private static final double HOOD_VOLTAGE_RANGE_COMPETITION = 2.49;

  private static final int MAX_LIMIT = 100;
  private static final int LOWER_HARD_STOP = 100;
  private static final int UPPER_HARD_STOP = 128;

  private static final double INITIATION_SHOOT_DISTANCE = 160; // inches
  private static final double TRENCH_FAR_SHOOT_DISTANCE = 330; // inches
  private static final double TOLERANCE = 0.1;

  private final Victor hoodMotor = new Victor(ShooterConstants.kHoodMotorPort);
  private final AnalogInput encoderInput = new AnalogInput(ShooterConstants.kHoodAnalogEncoderPort);
  private final AnalogEncoder hoodEncoder = new AnalogEncoder(encoderInput);

  /** Creates a new Hood. */
  public Hood() {
  }

  public void rawHood(double power) {
    power = MathUtil.clamp(power, -.8, .8);
    double hoodPosition = getPosition();
    // Prevent the turret from moving past hard stops
    if (hoodPosition >= UPPER_HARD_STOP && power > 0 || hoodPosition < LOWER_HARD_STOP && power < 0) {
      //power = 0;
      //TODO: return
    }
    hoodMotor.set(power);
  }

  private double getPosition() {
    double volts = hoodEncoder.get();
    return MAX_LIMIT * (HOOD_BACK_VOLTAGE_COMPETITION - volts) / (HOOD_VOLTAGE_RANGE_COMPETITION);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Hood Position", getPosition());
  }

public static Sendable getHeading() {
    return null;
}
}
