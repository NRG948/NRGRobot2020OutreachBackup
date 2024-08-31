package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.TankDrive;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.SetDriveMode;

public class DefaultDrive extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TankDrive m_drive;
    final CommandXboxController m_XboxController;
    final CommandJoystick m_leftJoystick;
    final CommandJoystick m_rightJoystick;
    
    public DefaultDrive(TankDrive subsystem, CommandJoystick lJoy, CommandJoystick rJoy, CommandXboxController xboxcontroller) {
      m_drive = subsystem;
      m_XboxController = xboxcontroller;
      m_leftJoystick = lJoy;
      m_rightJoystick = rJoy;
      addRequirements(subsystem);
    }
    
    public void initialize() {
      m_drive.setMaxOutput(DriveConstants.kSlowModePower);
    }

    public void execute() {
      if(SetDriveMode.DriveControllerMode == 1){
        m_drive.diffDrive(m_XboxController.getLeftY(),m_XboxController.getRightY());
      } else if (SetDriveMode.DriveControllerMode == 0) {
        m_drive.diffDrive(m_leftJoystick.getY(),m_rightJoystick.getY());
      } else if (SetDriveMode.DriveControllerMode == 2) { //should never reach this point FOR NOW
        if (m_XboxController.getLeftY() == 0 && m_XboxController.getRightY() == 0) {
          m_drive.diffDrive(m_leftJoystick.getY(),m_rightJoystick.getY());
        } else {
          m_drive.diffDrive(m_XboxController.getLeftY(),m_XboxController.getRightY());
        }
      } else {
        m_drive.diffDrive(0, 0);
        System.out.print("No Drive Controller Mode!");
      }
    }
}