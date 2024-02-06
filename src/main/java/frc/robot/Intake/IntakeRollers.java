package frc.robot.Intake;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRollers extends SubsystemBase {
    //Motor Controller
    private TalonFX RollerMotor;

    //Control Modes and Setpoints
    private final VelocityDutyCycle RollerVelocity = new VelocityDutyCycle(0).withEnableFOC(true);
    private final DutyCycleOut RollerPercentOutput = new DutyCycleOut(0);

    public void Rollers() {
         // Initialize motor controller and configure
        RollerMotor = new TalonFX(IntakeConstants.RollerID, "Carnivor");
        resetEncoder();
        configRoller();
    }
    public void feederRun(double velocity) {
        RollerVelocity.Velocity = velocity;
        RollerMotor.setControl(RollerVelocity);
    }
        // Method to run the feeder with a specified percentage output
    public void RollerRunPercentOutput(double percentOutput) {
        RollerPercentOutput.Output = percentOutput;
        RollerMotor.setControl(RollerPercentOutput);
    }

    // Method to reset the feeder encoder position
    public void resetEncoder() {
        RollerMotor.setPosition(0);
    }

    // Method to configure the feeder motor controller
    public void configRoller() {
   // TODO: FINISH CONFIG AND UNCOMMENT CODE:RollerMotor.getConfigurator().apply(Robot.ctreConfigs.feederFXConfig);
    }

    // Getter methods for sensor values
    public double getRollerEncoder() {
        return RollerMotor.getPosition().getValueAsDouble();
    }

    public double getRollerVelocity() {
        return RollerMotor.getVelocity().getValueAsDouble();
    }
    public enum RollerState {
        Intake(IntakeConstants.RollerMaxSpeed),
        Invert(IntakeConstants.RollerInvSpeed);

        public double RollerVelocity;

        private RollerState(double velocity) {
            RollerVelocity = velocity;
        }
    }
        // Periodic method to update SmartDashboard values
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Roller velocity", getRollerVelocity());
        SmartDashboard.putNumber("Roller Encoder", getRollerEncoder());
    }


}
