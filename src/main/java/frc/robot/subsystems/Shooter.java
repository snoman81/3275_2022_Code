// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; import com.ctre.phoenix.motorcontrol.NeutralMode;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Shooter extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX motor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Shooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
motor = new WPI_TalonFX(9);
 
    /* Factory default hardware to prevent unexpected behavior */
motor.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
motor.setInverted(false);
motor.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
motor.configNominalOutputForward(0, 30);
motor.configNominalOutputReverse(0, 30);
motor.configPeakOutputForward(1, 30);
motor.configPeakOutputReverse(-1, 30);
        



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        SmartDashboard.putNumber("Shooter High Speed",.75);
        SmartDashboard.putNumber("Shooter Low Speed",.5);

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
       
        double selSenVel = motor.getSelectedSensorVelocity(0); /* position units per 100ms */
		double vel_RotPerSec = (double) selSenVel / 2048 * 10; /* scale per100ms to perSecond */
		double vel_RotPerMin = vel_RotPerSec * 60.0;
        SmartDashboard.putNumber("Shooter Percent Out", motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Shooter RPM Out", vel_RotPerMin);


    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void my_Shooter_Run(double speed){
        motor.set(speed);
    }
}

