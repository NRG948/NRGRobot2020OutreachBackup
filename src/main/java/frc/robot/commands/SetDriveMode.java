// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.DriveConstants;

public class SetDriveMode extends CommandBase {
  //public static int DriveControllerMode = 1;
  public static int DriveControllerMode = DriveConstants.isUsingXboxController; // temporary, eventually this should not be a constant and instead settable in SmartDashboard

  public SetDriveMode() {
    
  }

  @Override
  public void execute() {
    DriveControllerMode += 1;
    if (DriveControllerMode == 1) {
      SmartDashboard.putString("Drive Control Mode", "1 - Xbox Controller");
    } else if (DriveControllerMode == 2){
      SmartDashboard.putString("Drive Control Mode", "2 - Both");
    } else {
      DriveControllerMode = 0;
      SmartDashboard.putString("Drive Control Mode", "0 - Joysticks");
    }
  }

  @Override
  public void end(boolean interrupted) {
  }
}
