package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterRPM;

public class ManualShooter extends CommandBase {
  ShooterRPM shooterRPM;
  CommandXboxController xboxController;
  /**
   * Creates a new ManualShooter.
   */
  public ManualShooter(ShooterRPM shooterRPM, CommandXboxController xboxController) {
    this.shooterRPM = shooterRPM;
    this.xboxController = xboxController;
    addRequirements(shooterRPM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Logger.commandInit(this);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterRPM.setFlyWheel(-xboxController.getRightTriggerAxis() * ShooterConstants.kShooterMaxPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Logger.commandEnd(this, interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}