package frc.robot.Shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController;

public class ShooterConfig {
public enum PivotState {
        
        kScoreLow(Units.degreesToRadians(60)),
        // kHumanPlayer(Conversions.degreesToRadians(135)),
        kShootSpeaker(Units.degreesToRadians(60));

        
        /**
         * Creates a PivotState with a target in radians
         *
         * @param target angle in radians
         */
        PivotState(double target) {
            this.target = target;
        }
        public final double target;
    }
    public class ShooterProfile {
        public ShooterProfile(int stallLimit, int freeLimit, double nominalSpeed, String name) {
            kStallCurrentLimit = stallLimit;
            kFreeCurrentLimit = freeLimit;
            kNominalOutput = nominalSpeed;
            kName = name;
        }

        @Override
        public String toString() {
            return kName;
        }

        final int kStallCurrentLimit;
        final int kFreeCurrentLimit;
        final double kNominalOutput;
        private final String kName;
    }

 //motor IDs have to be changed
    public static final int kLeftShooterSparkID = 26;
    public static final int kRightShooterSparkID = 27;
    public static final int kPivotSparkID = 28;
    public static final int kIndexTalonID = 29;

    public static final boolean kPivotMotorInverted = false;
    public static final boolean kShooterMotorInverted = false;
    public static final boolean kIndexerMotorInverted = false;

    public static final CANSparkMax.IdleMode kPivotIdleMode = CANSparkMax.IdleMode.kBrake;
    public static final CANSparkMax.IdleMode kRollerIdleMode = CANSparkMax.IdleMode.kCoast;

    // Intake Profiles
    // public static ShooterProfile kOuttake = new ShooterProfile(60, 60, -1, "OutTake");
    // public static ShooterProfile kShoot = new ShooterProfile(60, 60, -.8, "ShootCube");
    // public static ShooterProfile kHandoff = new ShooterProfile(40, 40, 0.5, "Handoff");
    // public static ShooterProfile kDefaultProfile = new ShooterProfile(40, 40, 1, "Default");

    public static final int shooterCurrentLimit = 35;
    public static final int shooterCurrentThreshold = 60;
    public static final double shooterCurrentThresholdTime = 0.1;
    public static final boolean shooterEnableCurrentLimit = true;

     public static final int kHOLimitSwitch = 53;
     public static final int kIndexerBeamBreak = 54;

     // Pivot PID constants
    public static final double kVelP = 0.1;
    public static final double kVelI = 0.0;
    public static final double kVelD = 0.0;

    // Pivot Feedforward Constants (reca.lc)
    public static final double kG = 0.23;
    public static final double kS = 0.0;
    public static final double kV = 2.92;
    public static final double kA = 0.01;

    // Motion Profile Parameters
    public static final double kMaxAngularAcceleration = 4.5;
    public static final double kMaxAngularVelocity = 3.0;

    // Sensor Parameters
    public static final boolean kPivotEncoderInverted = true;
    public static final double kPivotZeroOffset = 0.95;

    // Tensioning constants
    public static final int kDefaultContinuousCurrentLimit = 35;
    public static final int kDefaultPeakCurrentLimit = 60;

    public static final double LeftToRightDiff = 0.9;
 
}
