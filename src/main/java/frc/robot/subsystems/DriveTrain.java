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


import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
    import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX talonFXEnhanced3;
private WPI_TalonFX talonFXEnhanced4;
private MotorControllerGroup leftMotorGroup;
private WPI_TalonFX talonFXEnhanced1;
private WPI_TalonFX talonFXEnhanced2;
private MotorControllerGroup rightMotorGroup;
private DifferentialDrive differentialDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveTrain() {
        // _BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
talonFXEnhanced3 = new WPI_TalonFX(Constants.DriveConstants.kLeftMotor1Port);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced3.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced3.setInverted(false);
talonFXEnhanced3.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced3.configNominalOutputForward(0, 30);
talonFXEnhanced3.configNominalOutputReverse(0, 30);
talonFXEnhanced3.configPeakOutputForward(1, 30);
talonFXEnhanced3.configPeakOutputReverse(-1, 30);
        


talonFXEnhanced4 = new WPI_TalonFX(Constants.DriveConstants.kLeftMotor2Port);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced4.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced4.setInverted(false);
talonFXEnhanced4.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced4.configNominalOutputForward(0, 30);
talonFXEnhanced4.configNominalOutputReverse(0, 30);
talonFXEnhanced4.configPeakOutputForward(1, 30);
talonFXEnhanced4.configPeakOutputReverse(-1, 30);
        


leftMotorGroup = new MotorControllerGroup(talonFXEnhanced3, talonFXEnhanced4  );
 addChild("leftMotorGroup",leftMotorGroup);
 

talonFXEnhanced1 = new WPI_TalonFX(Constants.DriveConstants.kRightMotor1Port);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced1.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced1.setInverted(true);
talonFXEnhanced1.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced1.configNominalOutputForward(0, 30);
talonFXEnhanced1.configNominalOutputReverse(0, 30);
talonFXEnhanced1.configPeakOutputForward(1, 30);
talonFXEnhanced1.configPeakOutputReverse(-1, 30);
        


talonFXEnhanced2 = new WPI_TalonFX(Constants.DriveConstants.kRightMotor2Port);
 
    /* Factory default hardware to prevent unexpected behavior */
talonFXEnhanced2.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
talonFXEnhanced2.setInverted(true);
talonFXEnhanced2.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
talonFXEnhanced2.configNominalOutputForward(0, 30);
talonFXEnhanced2.configNominalOutputReverse(0, 30);
talonFXEnhanced2.configPeakOutputForward(1, 30);
talonFXEnhanced2.configPeakOutputReverse(-1, 30);
        


rightMotorGroup = new MotorControllerGroup(talonFXEnhanced1, talonFXEnhanced2  );
 addChild("RightMotorGroup",rightMotorGroup);
 

differentialDrive1 = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
 addChild("Differential Drive 1",differentialDrive1);
 differentialDrive1.setSafetyEnabled(true);
differentialDrive1.setExpiration(0.1);
differentialDrive1.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Gyro", 0.0);
        SmartDashboard.putNumber("Left Encoder", talonFXEnhanced3.getSelectedSensorPosition());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void my_DriveArcade(double xSpeed, double zRotation){
        differentialDrive1.arcadeDrive(xSpeed*Constants.drivespeed, zRotation*Constants.driverotatespeed);
    }

    //Add encoder here

}
