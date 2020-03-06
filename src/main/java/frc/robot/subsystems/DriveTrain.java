/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.TankDriveCommand;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTrain extends Subsystem {
 
  private CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  private CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  private CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  private CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);

  public CANEncoder encoder = new CANEncoder(leftFrontDriveMotor);
  public CANPIDController driveTrainPIDController;
 
  public DriveTrain(){

    double kP = Constants.DRIVE_TRAIN_KP;
    double kI = Constants.DRIVE_TRAIN_KI;
    double kD = Constants.DRIVE_TRAINT_KD;
    double kIz = Constants.DRIVE_TRAIN_KIZ;
    double kFF = Constants.DRIVE_TRAIN_KFF;
    double kMaxOutput = 1;
    double kMinOutput = -1;

    driveTrainPIDController.setP(kP);
    driveTrainPIDController.setI(kI);
    driveTrainPIDController.setD(kD);
    driveTrainPIDController.setIZone(kIz);
    driveTrainPIDController.setFF(kFF);
    driveTrainPIDController.setOutputRange(kMinOutput, kMaxOutput);

    leftFrontDriveMotor.setOpenLoopRampRate(0.8);
    leftBackDriveMotor.setOpenLoopRampRate(0.8);
    rightFrontDriveMotor.setOpenLoopRampRate(0.8);
    rightBackDriveMotor.setOpenLoopRampRate(0.8);

    
  
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand(false));
       
  }

  public void setCoastMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
    rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    rightBackDriveMotor.setIdleMode(IdleMode.kCoast);
  }

  public void setBrakeMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kBrake);
    leftBackDriveMotor.setIdleMode(IdleMode.kBrake);
    rightFrontDriveMotor.setIdleMode(IdleMode.kBrake);
    rightBackDriveMotor.setIdleMode(IdleMode.kBrake);
  }



  public void setDriveTrainPID(double target) {
    driveTrainPIDController.setReference(target, ControlType.kPosition);
  }



  public void tankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(Math.pow(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS),1));
    leftBackDriveMotor.set(Math.pow(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS),1));
  }

  public void tankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(Math.pow(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS),1));
    rightBackDriveMotor.set(Math.pow(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS),1));
  }



  public void Drive(double left, double right) {
    leftFrontDriveMotor.set(left);
    leftBackDriveMotor.set(left);
    rightFrontDriveMotor.set(right);
    rightBackDriveMotor.set(right);
  }

}
