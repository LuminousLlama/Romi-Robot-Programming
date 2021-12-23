// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  Drivetrain m_drivetrain;
  Supplier<Double> m_leftPower;
  Supplier<Double> m_rightPower;

  public TankDrive(
    Drivetrain drivetrain,
    Supplier<Double> leftPower,
    Supplier<Double> rightPower){
    m_drivetrain = drivetrain;
    m_leftPower = leftPower;
    m_rightPower = rightPower;
  }

  

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.tankDrive(m_leftPower.get(), m_rightPower.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
