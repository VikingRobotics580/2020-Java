// VikingRobotics 2019 FRC Robotics
// Programming Team: Bhada Yun, Finn Cawley, Kate Hirshberg
// I2C Receiver for Arduino
// Lead: Bhada Yun 

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

	//String status = "";

	public Alliance getAlliance() {
		return DriverStation.getInstance().getAlliance();
	}

	public void write(String input){//writes to the arduino 
		
		String LEDColor = "none";

		if (getAlliance() == Alliance.Red) {
			LEDColor = "red";
		}
		if (getAlliance() == Alliance.Blue) {
			LEDColor = "blue";
		}
		if (getAlliance() == Alliance.Invalid) {
			LEDColor = "none";
		}

		char[] CharArray = LEDColor.toCharArray();//creates a char array from the input string
		byte[] WriteData = new byte[CharArray.length];//creates a byte array from the char array
		for (int i = 0; i < CharArray.length; i++) {//writes each byte to the arduino
			WriteData[i] = (byte)CharArray[i];//adds the char elements to the byte array 
		}
		Wire.transaction(WriteData, WriteData.length, null, 0);//sends each byte to arduino
	}

	public Arduino getArduino(){//reads the data from arduino and saves it
		String info[] = read().split("\\|");//everytime a "|" is used it splits the data,
		Arduino arduino = new Arduino();  //creates a new packet to hold the data 
		if(info[0].equals("none") || info[0].equals("")){//checks to make sure there is data 
			arduino.x = -1;//the x val will never be -1 so we can text later in code to make sure 
			arduino.y = -1;
			arduino.area = -1;
			if (info.length >= 2) {
				arduino.distance = Double.parseDouble(info[1]);
			}
		}else if(info.length >= 3){//if there is an x, y, and area value the length equals 3
			arduino.x = Double.parseDouble(info[0]);//set x
			arduino.y = Double.parseDouble(info[1]);//set y
			arduino.area = Double.parseDouble(info[2]);//set area
			arduino.distance = Double.parseDouble(info[3]);
		}
		return arduino;
	}

	public void getData() {
		Arduino receive = getArduino();
		//System.out.println(receive.distance);
		if (OI.leftJoystick.getRawButtonPressed(12)) {
			System.out.println("Test:" + receive.x + " | " + receive.y + " | " + receive.area);
			System.out.println("Distance: " + receive.distance);
		}
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