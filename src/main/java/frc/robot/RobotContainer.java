// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class RobotContainer {

  private final CommandJoystick leftJoystick = new CommandJoystick(2);
  private final CommandJoystick rightJoystick = new CommandJoystick(3);
  private final CommandXboxController operatorController = new CommandXboxController(1);
  private final CommandXboxController driveController = new CommandXboxController(0);

  //private final RobotController m_robotController;

  private final TankDrive drivetrain = new TankDrive();
  private final Intake intaker = new Intake();
  private final Feeder feeder = new Feeder();
  private final Hood hood = new Hood();
  private final Turret turret = new Turret();
  private final ShooterRPM rpm = new ShooterRPM();

  private Subsystems subsystems = new Subsystems();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    intaker.setDefaultCommand(new ControlIntake(intaker, operatorController));
    feeder.setDefaultCommand(new ControlFeeder(feeder, operatorController));
    hood.setDefaultCommand(new ControlHood(hood, operatorController));
    turret.setDefaultCommand(new ControlTurret(turret, operatorController));
    rpm.setDefaultCommand(new ManualShooter(rpm, operatorController));

    drivetrain.setDefaultCommand(new DefaultDrive(drivetrain,leftJoystick, rightJoystick,driveController));
  }   

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    operatorController.leftTrigger().whileTrue(new SetDriveSpeed(drivetrain));
    operatorController.rightBumper().whileTrue(new RainbowLEDCycle(Subsystems.leds));
    operatorController.leftBumper().onTrue(new FlashingLEDs(Constants.ColorConstants.RED, Constants.ColorConstants.YELLOW, subsystems.leds, 1));
    
    //m_robotController.getUserButton().debounce(0.1).onTrue(new SetDriveMode());
    //fails to build

    //TODO: Add the user button command
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  public Command getAutonomousCommand() {
    //return m_chooser.getSelected();
  }*/
}
