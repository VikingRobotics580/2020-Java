/*
==================================================================================
This code is property of 580 gang, fool. Get outta here, city slicker.
Proganger team leaders: Finn Cawley and Bhada Yun
Researcher and coordinator: Kate Hirshberg
Treasurer: David Ju
gamer: The Orb
Queen of Racism: Kamron
==================================================================================
*/

package frc.robot;

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
    TUT: Tutorial
    Val: Value
    PRT: Port
    */

    //Joystick
    public static int SRV_Neg = 3; //Make servo move negatively
    public static int BIT_Pul = 4; //Starts intake
    public static int SRV_Pos = 5; //Make servo move positively
    public static int BIT_Stp = 6; //Stops intake
    public static int WNC_Pul = 7; //Extends winch
    public static int WNC_Stp = 8; //Pulls winch

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

    //Tutorial lines
    public static int TUT = -1; //Tutorial
    public static int TUT_Val = -2; //Prints tutorial number
    public static int TUT_Pos = -3; //Increases tutorial number
    public static int TUT_Neg = -4; //Decreases tutorial number

}