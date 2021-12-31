// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomousTesting;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.OnBoardIO;


// USELESS using "inline commands" now


public class TurnLedOff extends CommandBase {
  OnBoardIO m_io;
  boolean done;
  public TurnLedOff(OnBoardIO io) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_io = io;
    addRequirements(m_io);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_io.setGreenLed(false);
    m_io.setRedLed(false);  //better way to do this would be putting this in initialize and making isfinished true 
    done = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
