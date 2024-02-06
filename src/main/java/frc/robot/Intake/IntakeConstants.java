package frc.robot.Intake;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

public final class IntakeConstants {
    //ROLLER CONNSTANTS
    
    //RollerID
    public static final int RollerID = 1;

    //Roller Inverts and Netural mode
    public static final InvertedValue InvertedRoller = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue NeutralModeRoller = NeutralModeValue.Coast;
    
    //Roller Limits
    //TODO: Defalt Constants change later
    public static final boolean IntakeLimtterON = true;
    public static final int RollerLimit = 20;
    public static final int RollerThreshold = 30;
    // public static final double FEEDER_SUPPLY_TIME_THRESHOLD = 0.1;


    //Roller Velocities
    //TODO: Defalt Velocities change later
    public static final int RollerMaxSpeed = 1;
    public static final int RollerInvSpeed = -1;

    //Pivot Constants 
    //TODO: Change ID when Id is known
    public static final int PivotID = 1;
    
    //Pivot PID
    public static final double PivotPID = .1;

    //Pivot SetPoints
    public static final double PivotFeed = 0; //TODO: Change when position known
    public static final double PivotIntake = 0;//TODO: Change when position known
    public static final double NeutralMode = 0;//TODO: Change when position known

    //Intake CanCoder ID
    public static final int CANCODER_ID = 2;

    //Intake Cancoder Invert 
    public static final SensorDirectionValue CanCoderInvert = SensorDirectionValue.Clockwise_Positive;
}
