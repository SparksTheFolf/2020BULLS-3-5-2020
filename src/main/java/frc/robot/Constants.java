/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {

  //DRIVETRAIN MOTOR ID
  public static final int MOTOR_LEFT_FRONT = 1;
  public static final int MOTOR_LEFT_BACK = 2;
  
  public static final int MOTOR_RIGHT_FRONT = 3;
  public static final int MOTOR_RIGHT_BACK = 4;


  //TALON MOTOR ID
  public static final int BALL_INTAKE_MOTOR = 5;
  public static final int HOPPER_MOTOR = 7;
  public static final int WINCH_MOTOR = 10;
  public static final int COLOR_MOTOR = 6;

  
  //DRIVER JOYSTICK ID
  public static final int DRIVER_JOYSTICK_LEFT = 2;
  public static final int DRIVER_JOYSTICK_RIGHT = 3;
  public static final int DRIVER_JOYSTICK_AXIS = 1;


  //OPERATOR CONTROLLER ID
  public static final int OPERATOR_CONTROLLER = 1;
  public static final int OPERATOR_RIGHT_AXIS = 5;
  public static final int OPERATOR_LEFT_AXIS = 1;


  //DRIVER BUTTONS
  public static final int DRIVE_STRAIGHT_BUTTON = 1;


  //OPERATOR BUTTONS
  public static final int BALL_INTAKE_BUTTON = 5;
  public static final int REVERSE_INTAKE_BUTTON = 7;
  public static final int BALL_OUTPUT_BUTTON = 6;
  public static final int REVERSE_HOPPER_BUTTON = 8;
  public static final int CLIMBER_PISTONS_BUTTON = 10;
  public static final int COLOR_PISTON_BUTTON = 9;

  //MOTOR SPEEDS
  public static final double INTAKE_MOTOR_SPEED = 1.0;
  public static final double REVERSE_INTAKE_MOTOR_SPEED = -1.0;
  public static final double HOPPER_MOTOR_SPEED = 1.0;
  public static final double REVERSE_HOPPER_MOTOR_SPEED = -1.0;


  //DRIVE TRAIN PID SETTINGS
  public static final double DRIVE_TRAIN_KP = 0.04;
  public static final double DRIVE_TRAIN_KI = 0.0;
  public static final double DRIVE_TRAINT_KD = 0.3;
  public static final double DRIVE_TRAIN_KIZ = 0.0;
  public static final double DRIVE_TRAIN_KFF = 0.0;


  //AUTO DISTANCE
  public static final double DISTANCE_1 = 25.0;

}
