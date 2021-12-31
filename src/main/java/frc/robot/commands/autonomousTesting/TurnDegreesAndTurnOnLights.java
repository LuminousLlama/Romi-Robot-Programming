// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomousTesting;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnDegreesAndTurnOnLights extends ParallelCommandGroup {
  Drivetrain m_drivetrain;
  OnBoardIO m_io;

  double m_speed;
  double m_degrees;
  public TurnDegreesAndTurnOnLights(double speed, double degrees, Drivetrain drivetrain, OnBoardIO io) {
    m_speed = speed;
    m_degrees = degrees;

    m_drivetrain = drivetrain;
    m_io = io;
    
    System.out.println("in turn lights");
    addCommands(
      new TurnDegrees(m_speed, m_degrees, m_drivetrain),
      new InstantCommand(m_io::turnOnLed)  // testing not adding subsystem requirement 
    );
  }
}
