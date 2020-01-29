package frc.robot;

import static frc.robot.OI.*;

//This code is FINN'S baby

public class RobotMap {

    /*
    LEGEND:

    SRV: Servo
    BIT: Ball Intake
    WNC: Winch
    Neg: Move in a negative direction
    Pos: Movie in a positive direction
    Pul: Pull with motor
    Stp: Stop motor
    Spd: Speed at which something moves
    TLN: Talon
    PRT: Port
    */

    //Joystick
    public static boolean SRV_Neg = rightJoystick.getRawButton(3); //Make servo move negatively
    public static boolean BIT_Pul = rightJoystick.getRawButton(4); //Starts intake
    public static boolean SRV_Pos = rightJoystick.getRawButton(5); //Make servo move positively
    public static boolean BIT_Stp = rightJoystick.getRawButton(6); //Stops intake
    public static boolean WNC_Pul = rightJoystick.getRawButton(7); //Extends winch
    public static boolean WNC_Stp = rightJoystick.getRawButton(8); //Pulls winch

    //Speeds
    public static double BIT_Spd = 0.2; //Ball intake speed
    public static double SRV_Spd = 2; //Servo Speed
    public static double WNC_Spd = 0.3; //Winch speed

    //Talon ports
    public static int TLN_0 = 0; //Talon 0
    public static int TLN_1 = 1; //Talon 1
    public static int TLN_2 = 2; //Talon 2
    public static int TLN_3 = 3; //Talon 3
    public static int TLN_BIT = 4; //Ball intake motor
    public static int TLN_WNC_0 = 5; //Winch motor 1
    public static int TLN_WNC_1 = 6; //Winch motor 2

    //Other ports
    public static int SRV_PRT = 0; //Servo port

}