// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomousTesting;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousDistanceWithLights extends SequentialCommandGroup {
  Drivetrain m_drivetrain;
  OnBoardIO m_io;

  // easier to change a variable than manually changing every command
  double m_speed = 0.5;
  double m_distance = 3;
  double m_degrees = 180; 

  public AutonomousDistanceWithLights(Drivetrain drivetrain, OnBoardIO io) {
    m_drivetrain = drivetrain;
    m_io = io;
    System.out.println("in auto command");
    addCommands(
       new DriveDistanceAndTurnOffLights(m_speed, m_distance, m_drivetrain, m_io),
       new TurnDegreesAndTurnOnLights(m_speed, m_degrees , m_drivetrain, m_io),
       new DriveDistanceAndTurnOffLights(m_speed, m_distance, m_drivetrain, m_io),
       new TurnDegreesAndTurnOnLights(m_speed, m_degrees, m_drivetrain, m_io),
       new InstantCommand(m_io::turnoffLed, m_io)
    );
  }
}
