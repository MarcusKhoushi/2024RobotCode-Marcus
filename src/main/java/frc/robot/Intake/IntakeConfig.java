package frc.robot.Intake;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.google.flatbuffers.Constants;

public final class IntakeConfig{
      public TalonFXConfiguration swerveAngleFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration swerveDriveFXConfig = new TalonFXConfiguration();
    public CANcoderConfiguration swerveCANcoderConfig = new CANcoderConfiguration();
    public TalonFXConfiguration feederFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration shooterFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration shooterPivotFXConfig = new TalonFXConfiguration();
    public CANcoderConfiguration shooterCANcoderConfig = new CANcoderConfiguration();
    public TalonFXConfiguration intakeFXConfig = new TalonFXConfiguration();
    public TalonFXConfiguration intakePivotFXConfig = new TalonFXConfiguration();
    public CANcoderConfiguration intakeCANcoderConfig = new CANcoderConfiguration();
    public TalonFXConfiguration climberFXConfig = new TalonFXConfiguration();
    
    public void CTREConfigs(){
           /*============================
                Intake Motor
        ==============================*/

        /* Intake Output and Neutral Mode */
        var intakeOutput = intakeFXConfig.MotorOutput;
        intakeOutput.Inverted = Constants.INTAKE_INVERTED;
        intakeOutput.NeutralMode = Constants.INTAKE_NEUTRAL_MODE;

        /* Intake Current Limits */
        var intakeCurrentLimits = intakeFXConfig.CurrentLimits;
        intakeCurrentLimits.SupplyCurrentLimitEnable = Constants.INTAKE_ENABLE_CURRENT_LIMIT;
        intakeCurrentLimits.SupplyCurrentLimit = Constants.INTAKE_SUPPLY_CURRENT_LIMIT;
        intakeCurrentLimits.SupplyCurrentThreshold = Constants.INTAKE_SUPPLY_CURRENT_THRESHOLD;
        intakeCurrentLimits.SupplyTimeThreshold = Constants.INTAKE_SUPPLY_TIME_THRESHOLD;

        /* Intake PID Config */
        var intakeSlot0 = intakeFXConfig.Slot0;
        intakeSlot0.kP = Constants.INTAKE_P;
        intakeSlot0.kI = Constants.INTAKE_I;
        intakeSlot0.kD = Constants.INTAKE_D;
        intakeSlot0.kV = Constants.INTAKE_V;

       /*============================
                Intake Pivot
        ==============================*/

        /* Intake Pivot Output and Neutral Mode */
        var intakePivotOutput = intakePivotFXConfig.MotorOutput;
        intakePivotOutput.Inverted = Constants.INTAKE_PIVOT_INVERTED;
        intakePivotOutput.NeutralMode = Constants.INTAKE_PIVOT_NEUTRAL_MODE;

        /* Intake Pivot Current Limits */
        var intakePivotCurrentLimits = intakePivotFXConfig.CurrentLimits;
        intakePivotCurrentLimits.SupplyCurrentLimitEnable = Constants.INTAKE_PIVOT_ENABLE_CURRENT_LIMIT;
        intakePivotCurrentLimits.SupplyCurrentLimit = Constants.INTAKE_PIVOT_SUPPLY_CURRENT_LIMIT;
        intakePivotCurrentLimits.SupplyCurrentThreshold = Constants.INTAKE_PIVOT_SUPPLY_CURRENT_THRESHOLD;
        intakePivotCurrentLimits.SupplyTimeThreshold = Constants.INTAKE_PIVOT_SUPPLY_TIME_THRESHOLD;

        /* Intake Pivot PID Config */
        var intakePivotSlot0 = intakePivotFXConfig.Slot0;
        intakePivotSlot0.kP = Constants.INTAKE_PIVOT_P;
        intakePivotSlot0.kI = Constants.INTAKE_PIVOT_I;
        intakePivotSlot0.kD = Constants.INTAKE_PIVOT_D;
        intakePivotSlot0.kV = Constants.INTAKE_PIVOT_V;
}
}