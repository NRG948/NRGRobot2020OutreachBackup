// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    //PWM ports
    public static final int kLeftDriveMotor1Port = 2;
    public static final int kLeftDriveMotor2Port = 3;
    public static final int kRightDriveMotor1Port = 0;
    public static final int kRightDriveMotor2Port = 1;

    public static final double kSlowModePower = 1.0; //percent
    public static final double kFullSpeedRateLimit = 0.01; //Increase (percentage of 1) per 20ms

    public static final int isUsingXboxController = 0; //CHANGE THIS TO 1 TO USE XBOX CONTROLLER TO DRIVE

    //TODO: slewrate need more tuning
    public static final double kDriveSlewRate = 1000; // x percent increase per second, set to arbitrarily high number to disable
  }

  public static final class ShooterConstants {
    public static final int kSpinMotor1Port = 4;
    public static final int kSpinMotor2Port = 5;
    public static final int kHoodMotorPort = 7;
    public static final int kTurretMotorPort = 6;
    public static final int kSpinEncoderPort = 4;
    public static final int kTurretEncoderAPort = 6; // should be 0
    public static final int kTurretEncoderBPort = 7; // should be 1
    public static final int kHoodAnalogEncoderPort = 0;

    public static final double kShooterMaxPower = 1; //percent
  }

  public static final class IntakeConstants {
    public static final int kIntakeMotorPort = 8;
    public static final int kFeederMotorPort = 9;
  }
}

