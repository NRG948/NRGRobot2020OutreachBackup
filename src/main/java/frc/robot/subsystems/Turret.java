// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.ShooterConstants;

public class Turret extends SubsystemBase {
  private static final double MIN_ENCODER_VALUE = 0;
  private static final double MAX_ENCODER_VALUE = 170;
  private static final Transform2d TURRET_POSITION_OFFSET = new Transform2d(
    new Translation2d(Units.inchesToMeters(-9.5), Units.inchesToMeters(-8.25)),
    new Rotation2d(0.0));
  private static final double TURRET_ANGLE_OFFSET = 51.0;
  private static final Translation2d POWERPORT_FIELD_POSITION = new Translation2d(0, Units.inchesToMeters(-94.66));
  private double cameraHorizontalCorrection;

  private final Victor turretMotor = new Victor(ShooterConstants.kTurretMotorPort);
  private final static Encoder turretEncoder = new Encoder(ShooterConstants.kTurretEncoderAPort,ShooterConstants.kTurretEncoderBPort);
  private PIDController turredPidController;
  private double maxPower;
  private double lastAngle = 0;
  /** Creates a new Turret. */
  public Turret() {}

  public void rawTurret(double power) {
    double encoderAngle = turretEncoder.getDistance();
    // Prevent the turret from turning past hard stops
    if (encoderAngle >= MAX_ENCODER_VALUE && power > 0 || encoderAngle < MIN_ENCODER_VALUE && power < 0) {
      power = 0;
    }
    turretMotor.set(power);
  }

  public static double getHeading() {
    return turretEncoder.getDistance();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Turret Heading", getHeading());
  }
}
