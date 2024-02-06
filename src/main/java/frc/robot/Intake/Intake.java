package frc.robot.Intake;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
   
   //Motor Controllers and sensors
    private TalonFX RollerMotor;
    private TalonFX PivotMotor;
    private CANcoder Encoder;

    //Control modes and setpoints
    private VelocityVoltage RollerVelocity = new VelocityVoltage(0);
    private DutyCycleOut RollerPercentOutput = new DutyCycleOut(0);
    private PositionDutyCycle PivotPosition = new PositionDutyCycle(0).withEnableFOC(true);
    private DutyCycleOut PivotPercentOutput = new DutyCycleOut(0);

    // Constructor
    public Intake() {
        // Initialize motor controllers and sensors
        RollerMotor = new TalonFX(IntakeConstants.RollerID, "Carnivor");
        PivotMotor = new TalonFX(IntakeConstants.PivotID, "Carnivor");
        Encoder= new CANcoder(IntakeConstants.CANCODER_ID, "Carnivor");
    }
       public void RollersRun(double velocity) {
        RollerVelocity.Velocity = velocity;
        RollerMotor.setControl(RollerVelocity);
    }

    // Method to set the intake motor output as a percentage
    public void RollerPercentOutput(double percentOutput) {
        RollerPercentOutput.Output = percentOutput;
        RollerMotor.setControl(RollerPercentOutput);
    }

    // Method to set the position of the intake pivot
    public void Pivot(double position) {
        PivotPosition.Position = position;
        PivotMotor.setControl(PivotPosition);
    }

    // Method to set the intake pivot motor output as a percentage
    public void PivotPercentOutput(double percentOutput) {
        PivotPercentOutput.Output = percentOutput;
        PivotMotor.setControl(PivotPercentOutput);
    }

    // Method to reset the intake pivot encoder position
    public void resetPivotEncoder() {
        PivotMotor.setPosition(0);
    }

    // Method to configure the intake pivot motor controller
    public void configPivotMotor() {
        PivotMotor.getConfigurator().apply(new TalonFXConfiguration());
        // TODO: Uncomment when Congfig is done: PivotMotor.getConfigurator().apply(Robot.ctreConfigs.intakePivotFXConfig);
        resetPivotEncoder();
    }

    // Method to configure the intake CANCoder (encoder)
    public void configCANCoder() {
        // Add configuration for CANCoder if needed
    }

    // Getter methods for sensor values
    public double getVelocity() {
        return RollerMotor.getVelocity().getValueAsDouble();
    }

    public double getPivotPosition() {
        return PivotMotor.getPosition().getValueAsDouble();
    }

    public double getPivotRotorPosition() {
        return PivotMotor.getRotorPosition().getValueAsDouble();
    }

    public double getEncoderPosition() {
        return Encoder.getAbsolutePosition().getValueAsDouble();
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Velocity", getVelocity());
        SmartDashboard.putNumber("Intake Pivot Position", getPivotPosition());
        SmartDashboard.putNumber("Intake Encoder Position", getEncoderPosition());
        SmartDashboard.putNumber("Intake Pivot Rotor Position", getPivotRotorPosition());
    }
}