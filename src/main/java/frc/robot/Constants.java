// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.util.Color8Bit;

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
    //public static final int kRightDriveMotor1Port = 0;
    public static final int kRightDriveMotor2Port = 1;

    public static final double kSlowModePower = 0.4; //percent
    public static final double kFullSpeedRateLimit = 0.01; //Increase (percentage of 1) per 20ms

    public static final int isUsingXboxController = 0; //CHANGE THIS TO 1 TO USE XBOX CONTROLLER TO DRIVE

    public static final int kRGBPort = 0;

    //TODO: slewrate need more tuning
    public static final double kDriveSlewRate = 1000; // x percent increase per second, set to arbitrarily high number to disable
  }
  public static class RobotConstants {
    /**
     * PMW Ports.
     */
    public static class PWMPort{
      public static final int LED = 0;
      public static final int LightningLED = 2;
    }
   
    /**
     * The number of LEDs on the addressable LED string.
     */
    public static final int LED_COUNT = 48;
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

  public static class ColorConstants {
      public static final Color8Bit BLACK = new Color8Bit(0,0,0);
      public static final Color8Bit WHITE = new Color8Bit(200, 200, 200);
      public static final Color8Bit RED = new Color8Bit(255,0,0);
      public static final Color8Bit ORANGE = new Color8Bit(255,119,0);
      public static final Color8Bit YELLOW = new Color8Bit(255,165,0);
      public static final Color8Bit GREEN = new Color8Bit(0,204,0);
      public static final Color8Bit BLUE = new Color8Bit(0,0,204);
      public static final Color8Bit PURPLE = new Color8Bit(238, 80, 255);
      public static final Color8Bit PINK = new Color8Bit(255,5,100);
      public static final Color8Bit LIGHTBLUE = new Color8Bit(56,197,252);

      public static final Color8Bit COLORS[] = { BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, LIGHTBLUE, PURPLE, PINK, WHITE};

     }
}

