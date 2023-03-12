package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
public class Drive extends SubsystemBase {
    private final WPI_TalonFX backRightMotor;
    private final WPI_TalonFX frontRightMotor;
    private final WPI_TalonFX backLeftMotor;
    private final WPI_TalonFX frontLeftMotor;

    public Drive(int brm, int frm, int blm, int flm){
        backRightMotor = new WPI_TalonFX(brm);
        frontRightMotor = new WPI_TalonFX(frm);
        backLeftMotor = new WPI_TalonFX(blm);
        frontLeftMotor = new WPI_TalonFX(flm);
    }

    public void goForward() {
        backRightMotor.set(ControlMode.PercentOutput, 0.5);
        backLeftMotor.set(ControlMode.PercentOutput,0.5 );
        frontRightMotor.set(ControlMode.PercentOutput, 0.5);
        frontLeftMotor.set(ControlMode.PercentOutput, 0.5);
        }

    }