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
    BS: Ball Shooter
    Neg: Move in a negative direction
    Pos: Movie in a positive direction
    Pul: Pull with motor
    Stp: Stop motor
    Shot: Shoot
    Spd: Speed at which something moves
    TLN: Talon
    TUT: Tutorial
    Val: Value
    EMG: Emergency
    PRT: Port
    */

    //Joystick
    public static int SRV_Neg = 6; //Make servo move negatively
    public static int BIT = 2; //Starts intake
    public static int SRV_Pos = 5; //Make servo move positively
    public static int WNC_Pul = 1; //Extends winch
    public static int WNC_Stp = 4; //Pulls winch
    public static int BS_Slow = 7; //Shoots balls
    public static int BS_Shot = 8; //Shoots balls
    public static int EMG_Stp = 2; //Shoots balls


    //Speeds
    public static double BIT_Spd = 0.8; //Ball intake speed
    public static double SRV_Spd = 6; //Servo Speed
    public static double WNC_Spd = 0.7; //Winch speed
    public static double BS_Spd = 1.0; //Ball shooter speed
    public static double BS_Slw = 0.1; //Ball shooter slower speed

    //Talon ports
    public static int TLN_0 = 0; //Talon 0
    public static int TLN_1 = 1; //Talon 1
    public static int TLN_2 = 2; //Talon 2
    public static int TLN_3 = 3; //Talon 3
    public static int TLN_BIT_0 = 8; //Ball intake motor 1
    public static int TLN_BIT_1 = 9; //Ball intake motor 2
    public static int TLN_WNC_0 = 6; //Winch motor 1
    public static int TLN_WNC_1 = 7; //Winch motor 2
    public static int TLN_BS_0 = 4; //Ball shooter 1
    public static int TLN_BS_1 = 5; //Ball shooter 2

    //Other ports
    public static int SRV_PRT_0 = 0; //Servo port 1
    public static int SRV_PRT_1 = 1; //Servo port 2

    public static String yes = "1";

}

//When someone insults my baby boy, RobotMap: https://i.imgur.com/EjJLRHP.jpg