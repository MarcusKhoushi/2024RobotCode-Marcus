// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Drivetrain.Drivetrain;
import frc.robot.Drivetrain.DrivetrainCommands.TeleopDrive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  /* Joysticks */
  private final Joystick driver = new Joystick(0);

  /* Driver Controls */
  //TODO: UNCOMMENT THE PS5 CODE IF THAT IS THE DRIVE CONTROLLER
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;

  private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
  private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kY.value);

  //PS5 Code:
  // private final int translationAxis = PS5Controller.Axis.kLeftY.value;
  // private final int strafeAxis = PS5Controller.Axis.kLeftX.value;
  // private final int rotationAxis = PS5Controller.Axis.kRightX.value;

  // private final JoystickButton zeroGyro = new JoystickButton(driver, PS5Controller.Button.kTriangle.value);
  // private final JoystickButton robotCentric = new JoystickButton(driver, PS5Controller.Button.kCross.value);


  /* Subsystems */
  private final Drivetrain mSwerveDrivetrain = new Drivetrain();
  public RobotContainer() {
    //TODO: May need to change the - sign in front of "driver.getRawAxis()"
    mSwerveDrivetrain.setDefaultCommand(
            new TeleopDrive(
                mSwerveDrivetrain, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );


    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    zeroGyro.onTrue(new InstantCommand(() -> mSwerveDrivetrain.zeroHeading()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}