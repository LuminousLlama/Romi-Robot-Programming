// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.OnBoardIO;

public class ToggleLightsBasedOnGyro extends CommandBase {
  OnBoardIO m_io;
  public ToggleLightsBasedOnGyro(OnBoardIO io) {
    addRequirements(io);
    m_io = io;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double angleZ = m_io.m_Drivetrain.m_gyro.getAngleZ();
    double relativeAngleZ = removeRotation(angleZ);
    
    if(Math.abs(relativeAngleZ) < 10){
      setGreenLight();
    } else {
      setRedLight();
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  private void setGreenLight(){
    m_io.setGreenLed(true);
    m_io.setRedLed(false);
  }

  private void setRedLight(){
    m_io.setGreenLed(false);
    m_io.setRedLed(true);
  }

  //spinning adds degrees to the angle this removes the excess degrees to get the relavite angle
  private double removeRotation(double angle){
    angle = Math.abs(angle);
    int rotations = (int) angle/360;
    System.out.println("rotations: " + rotations);
    angle = angle - rotations*360;
    return angle;
  }
}
