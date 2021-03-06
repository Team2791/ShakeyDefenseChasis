package org.usfirst.frc.team2791.robot;

import org.usfirst.frc.team2791.robot.ShakerJoystick.ShakerDriver;
import org.usfirst.frc.team2791.robot.ShakerJoystick.ShakerOperator;
import org.usfirst.frc.team2791.robot.commands.*;
// import org.usfirst.frc.team2791.robot.commands.pid.DriveStraightVision;
// import org.usfirst.frc.team2791.robot.commands.pid.StationaryVisionTurn;
// import org.usfirst.frc.team2791.robot.commands.safeties.*;
import org.usfirst.frc.team2791.robot.util.CONSTANTS;
import org.usfirst.frc.team2791.robot.util.GTADrive;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * This class does not handle the joysticks driving , which is handled in GTADrive.
 * </br> We are currently using 
 * <a href="http://support.logitech.com/en_us/product/gamepad-f310"> 
 * Logitech Gamepad F310 controllers </a>
 * @see GTADrive
 */
public class OI {
	public static ShakerDriver driver;
	public static ShakerOperator operator;


	protected Button driverA, driverB, driverX, driverY, driverLB, driverRB, driverBack, driverStart, driverLS, driverRS;
	protected Button operatorA, operatorB, operatorX, operatorY, operatorLB, operatorRB, operatorBack, operatorStart, 
	operatorLS, operatorRS; 

	protected Button driverDpadUp, driverDpadUpRight, driverDpadRight, driverDpadDownRight, driverDpadDown,
	driverDpadDownLeft, driverDpadLeft, driverDpadUpLeft;
	protected Button operatorDpadUp, operatorDpadUpRight, operatorDpadRight, operatorDpadDownRight, 
	operatorDpadDown, operatorDpadDownLeft, operatorDpadLeft, operatorDpadUpLeft;

	/**
	 * This is where the joysticks are initialized and buttons are mapped to certain commands 
	 * (driver and operator controls)
	 * </br> We are currently using 
	 *<a href="http://support.logitech.com/en_us/product/gamepad-f310"> 
	 * Logitech Gamepad F310 controllers </a>
	 */
	public OI(){
		driver = new ShakerDriver();
		operator = new ShakerOperator();

		initButtons();
		initDpad();
		
		//note: the triggers are called in GTADrive and in the joystick objects themselves so we do not have to map them here, esp. since they are for default commands

		/********************************** Operator Button Assignments ****************************************/

		// operatorX.whileHeld(new RunWallShot()); 
		// operatorY.whileHeld(new RunLongShot());

		// operatorA.whileHeld(new IntakeOn());
		// operatorB.whileHeld(new ClimberOn());
		
		// operatorRB.whileHeld(new HopperOn());
		// operatorLB.whileHeld(new HopperOnBackwards());
		
		// operatorDpadDown.whenPressed(new GearMechActiveIntake()); //intake gear w/ ir sensor logic
		// operatorDpadUp.whenPressed(new GearMechUp());
		
		// operatorDpadLeft.whileHeld(new AimAndShoot());
		// operatorDpadRight.whenPressed(new StationaryVisionTurn(0.5,1.5));

		// operatorLS.whenPressed(new GearMechDownRunMotors()); //intake gear w/o ir sensor logic
		// operatorRS.whileHeld(new ClimberOnSlow());
		
		// operatorBack.whenPressed(new StopClimberAndDisengage());//safety
		// operatorStart.whenPressed(new ShooterHopperSafety());//safety

		/********************************** Driver Button Assignments ****************************************/

		// driverX.whileHeld(new GearMechScore()); 

		// driverY.whileHeld(new ClimberOn());
		
		// driverA.whileHeld(new GearPoop());
		
		// driverB.whenPressed(new DriveWithVision());// TODO Remove this command from driver and give to operator instead of long shot

		driverLB.whileHeld(new DriveWithJoystick());
		driverRB.whileHeld(new DriveWithJoystick());
		
		// driverDpadLeft.whenPressed(new StationaryVisionTurn(0.5, 1.5));
		// driverDpadRight.whenPressed(new DriveStraightVision(CONSTANTS.DRIVE_VISION_SWEET_SPOT_FEET, .25));
		
		// driverBack.whileHeld(new CalibrateGyro());
		// driverDpadUp.whileHeld(new RunVisionShot());
		
		System.out.println("OI initialized");

	}

	/**
	 * Initializes all Buttons
	 */
	private void initButtons(){
		driverA = new JoystickButton(driver,1);
		driverB = new JoystickButton(driver,2);
		driverX = new JoystickButton(driver,3);
		driverY = new JoystickButton(driver,4);
		driverLB = new JoystickButton(driver,5);
		driverRB = new JoystickButton(driver,6);
		driverBack = new JoystickButton(driver,7);
		driverStart = new JoystickButton(driver,8);
		driverLS = new JoystickButton(driver,9);
		driverRS = new JoystickButton(driver,10);

		operatorA = new JoystickButton(operator, 1);
		operatorB = new JoystickButton(operator, 2);
		operatorX = new JoystickButton(operator, 3);
		operatorY = new JoystickButton(operator, 4);
		operatorLB = new JoystickButton(operator,5);
		operatorRB = new JoystickButton(operator,6);
		operatorBack = new JoystickButton(operator,7);
		operatorStart = new JoystickButton(operator, 8);
		operatorLS = new JoystickButton(operator,9);
		operatorRS = new JoystickButton(operator,10);
	}

	/**
	 * Initializes the Dpad
	 */
	private void initDpad(){
		driverDpadUp = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadUp();
			}
		};

		driverDpadUpRight = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadUpRight();
			}
		};

		driverDpadRight = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadRight();
			}
		};

		driverDpadDownRight = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadDownRight();
			}
		};

		driverDpadDown = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadDown();
			}
		};

		driverDpadDownLeft = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadDownLeft();
			}
		};

		driverDpadLeft = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadLeft();
			}
		};

		driverDpadUpLeft = new Button(){
			@Override
			public boolean get(){
				return driver.getDpadUpLeft();
			}
		};

		operatorDpadUp = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadUp();
			}
		};

		operatorDpadUpRight = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadUpRight();
			}
		};

		operatorDpadRight = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadRight();
			}
		};
		operatorDpadDownRight = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadDownRight();
			}
		};
		operatorDpadDown = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadDown();
			}
		};
		operatorDpadDownLeft = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadDownLeft();
			}
		};
		operatorDpadLeft = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadLeft();
			}
		};
		operatorDpadUpLeft = new Button(){
			@Override
			public boolean get(){
				return operator.getDpadUpLeft();
			}
		};
	}
	
}
