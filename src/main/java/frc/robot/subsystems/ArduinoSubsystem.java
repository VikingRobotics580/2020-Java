// VikingRobotics 2019 FRC Robotics
// Programming Team: Bhada Yun, Finn Cawley, David Ju, Kate Hirshberg
// I2C Receiver for Arduino
// Lead: Bhada Yun 
// Arduino helper: David Ju

package frc.robot.subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.OI;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ArduinoCommand;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class ArduinoSubsystem extends Subsystem {

	private static I2C Wire = new I2C(Port.kOnboard, 4);//uses the i2c port on the RoboRIO													//uses address 4, must match arduino
	private static final int MAX_BYTES = 32;

	byte[] data = new byte[1];

	public Alliance getAlliance() {
		return DriverStation.getInstance().getAlliance();
	}

	public void write() { //writes to the arduino 
		
		String LEDColor = "0";

		if (getAlliance() == Alliance.Red) {
			LEDColor = "1";
		}
		if (getAlliance() == Alliance.Blue) {
			LEDColor = "2";
		}
		if (getAlliance() == Alliance.Invalid) {
			LEDColor = "4";
		}

		char[] CharArray = LEDColor.toCharArray();//creates a char array from the input string
		byte[] WriteData = new byte[CharArray.length];//creates a byte array from the char array
		for (int i = 0; i < CharArray.length; i++) {//writes each byte to the arduino
			WriteData[i] = (byte)CharArray[i];//adds the char elements to the byte array 
		}
		Wire.writeBulk(WriteData, WriteData.length);
		//Wire.transaction(WriteData, WriteData.length, null, 0);
	}

	public Arduino getArduino(){//reads the data from arduino and saves it
	 	String info[] = read().split("\\|");//everytime a "|" is used it splits the data,
		Arduino arduino = new Arduino();  //creates a new packet to hold the data 
		if(!(info[0].equals("none") || info[0].equals(""))){//checks to make sure there is data 
			arduino.distance = Double.parseDouble(info[0]);
		}
		return arduino;
	}

	public void getData() {
		Arduino receive = getArduino();
		//System.out.println(receive.distance);
		System.out.println("Distance: " + receive.distance);
		SmartDashboard.putNumber("Ultrasonic Distance:", receive.distance);
	}

	private String read(){//function to read the data from arduino
		byte[] data = new byte[MAX_BYTES];//create a byte array to hold the incoming data
		Wire.read(4, MAX_BYTES, data);//use address 4 on i2c and store it in data
		String output = new String(data);//create a string from the byte array
		int pt = output.indexOf((char)255);
		return (String) output.subSequence(0, pt < 0 ? 0 : pt);
	}

	public void initDefaultCommand() {
        setDefaultCommand(new ArduinoCommand());
	}
	
}