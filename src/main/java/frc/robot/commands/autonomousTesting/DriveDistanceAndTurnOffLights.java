// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomousTesting;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveDistanceAndTurnOffLights extends ParallelCommandGroup {
  Drivetrain m_drivetrain;
  OnBoardIO m_io;

  double m_speed;
  double m_distance;
  public DriveDistanceAndTurnOffLights(double speed, double distance, Drivetrain drivetrain, OnBoardIO io) {
    m_drivetrain = drivetrain;
    m_io = io;

    m_speed = speed;
    m_distance = distance;
   
    addCommands(
      new DriveDistance(m_speed, m_distance , m_drivetrain),
      new InstantCommand(() -> { 
        m_io.setGreenLed(true);
        m_io.setRedLed(true);
      })
    );
  }
}
