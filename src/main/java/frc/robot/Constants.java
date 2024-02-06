// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;


public final class Constants extends IntakeConfig{

    public static final int INTAKE_ID = 20;


    public static final InvertedValue INTAKE_INVERTED = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue INTAKE_NEUTRAL_MODE = NeutralModeValue.Coast;


    public static final boolean INTAKE_ENABLE_CURRENT_LIMIT = true;
    public static final int INTAKE_SUPPLY_CURRENT_LIMIT = 20;
    public static final int INTAKE_SUPPLY_CURRENT_THRESHOLD = 30;
    public static final double INTAKE_SUPPLY_TIME_THRESHOLD = 0.1;


    public static final double INTAKE_P = 0.01;
    public static final double INTAKE_I = 0;
    public static final double INTAKE_D = 0;
    public static final double INTAKE_V = 0.4;


    public static final double INTAKE_RESET = 0;
    public static final double INTAKE_INTAKE = 70;
    public static final double INTAKE_SHOOT = 0;
    public static final double INTAKE_FEED_SHOOT = -70;
    public static final double INTAKE_AMP = -10;

    public static final int INTAKE_PIVOT_ID = 22;

    public static final InvertedValue INTAKE_PIVOT_INVERTED = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue INTAKE_PIVOT_NEUTRAL_MODE = NeutralModeValue.Brake;


    public static final boolean INTAKE_PIVOT_ENABLE_CURRENT_LIMIT = true;
    public static final int INTAKE_PIVOT_SUPPLY_CURRENT_LIMIT = 30;
    public static final int INTAKE_PIVOT_SUPPLY_CURRENT_THRESHOLD = 30;
    public static final double INTAKE_PIVOT_SUPPLY_TIME_THRESHOLD = 0.1;


    public static final double INTAKE_PIVOT_P = 0.1;
    public static final double INTAKE_PIVOT_I = 0;
    public static final double INTAKE_PIVOT_D = 0;
    public static final double INTAKE_PIVOT_V = 0.01;

    public static final int INTAKE_PIVOT_RESET = 0;
    public static final int INTAKE_PIVOT_INTAKE = 25;
    public static final int INTAKE_PIVOT_CLIMB = 0;
    public static final int INTAKE_PIVOT_FEED = 0;

    public static final int INTAKE_CANCODER_ID = 2;

    public static final SensorDirectionValue INTAKE_CANCODER_INVERT = SensorDirectionValue.Clockwise_Positive;

    public static final double INTAKE_CANCODER_OFFSET = 0;

}
