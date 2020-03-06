/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommandGroup;
import frc.robot.subsystems.*;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;


public class Robot extends TimedRobot {
  public static RobotContainer m_robotContainer;

  public static DriveTrain driveTrain = new DriveTrain();
  public static BallIntake ballIntake = new BallIntake();
  public static Hopper hopper = new Hopper();
  public static Tailgate tailgate = new Tailgate();
  public static ClimberPistons climberpistons = new ClimberPistons();
  public static Winch winch = new Winch();
  public static ColorPiston colorPistons = new ColorPiston();
  public static ColorDrive colorDrive = new ColorDrive();
  Command m_autonomousCommand;

  

  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void autonomousInit() {
   if (m_autonomousCommand != null) {
     m_autonomousCommand.start();
   }
   
  }
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
   if (m_autonomousCommand != null) {
     m_autonomousCommand.cancel();
    }
  }

  
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void testPeriodic() {
  }

  public static UsbCamera usbCamera1 = null;
  public class CameraThread extends Thread {
    final int CAMERA1 = 0;
    private int currentCamera = CAMERA1;

    VideoSink server;
    
    public void run(){
        System.out.println("CameraThread running");

     }

     public void setResolutionLow(){
        System.out.println("CameraThread rsetResolutionLow running");
        usbCamera1.setResolution(150, 150);

    }

    public void setResolutionHigh(){
        System.out.println("CameraThread rsetResolutionHigh running");
        usbCamera1.setResolution(200, 200);
        usbCamera1.setFPS(10);
    }

    public void setCameraSource(){
        System.out.println("CameraThread setCameraSource running");
        server.setSource(usbCamera1);
        SmartDashboard.putString("My Key", "Hello");
    }

    public void getCameraConfig(){
        System.out.println("CameraThread getPrintCameraConfig running");
        String cameraConfig; 
        cameraConfig = usbCamera1.getConfigJson();
        if (cameraConfig.isEmpty() == false) {
            System.out.println(cameraConfig.toString()); //print to console
        }
    }

    public void setCameraConfig(){
        System.out.println("CameraThread setPrintCameraConfig running");

        
        usbCamera1.setFPS(25);
        usbCamera1.setBrightness(50);  // this works
        usbCamera1.setExposureAuto();  // this works
       
    }
}
public static CameraThread myCameraThread;

 
@Override
public void robotInit() {
    m_robotContainer = new RobotContainer();

  myCameraThread = new CameraThread();
  usbCamera1 = CameraServer.getInstance().startAutomaticCapture(myCameraThread.CAMERA1);
  myCameraThread.server = CameraServer.getInstance().getServer();

  usbCamera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);


  myCameraThread.setCameraConfig();
 
  myCameraThread.start();
  myCameraThread.setResolutionHigh();
  myCameraThread.getCameraConfig();

  m_autonomousCommand = (new AutonomousCommandGroup());
  
}
}
