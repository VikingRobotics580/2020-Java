package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.*;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.networktables.*;

import frc.robot.commands.LimelightCommand;

public class LimelightSubsystem extends Subsystem {
    
    final double vertIterations = 0;
    NetworkTable table;
    NetworkTableEntry tx; // Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
    NetworkTableEntry ty; // Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
    NetworkTableEntry tv; // Whether limight has any valid targets (0 or 1)
    NetworkTableEntry ts; // Skew or rotation (-90 degrees to 0 degrees)
    NetworkTableEntry tl; // The pipeline’s latency contribution (ms) Add at least 11ms for image capture latency.
    NetworkTableEntry ta;
    NetworkTableEntry tvert; // Vertical sidelength of the rough bounding box (0 - 320 pixels)
    NetworkTableEntry camtran; // Results of a 3D position solution, 6 numbers: Translation (x,y,y) Rotation(pitch,yaw,roll)
    NetworkTableEntry lightState;
    NetworkTableEntry pipeline; 
    final double mountAngle = 19;
    final double targetHeight = 89.75;
    final double mountHeight = 35;

    boolean limelightHasValidTarget = false;

    double yAngle = 0;
    double xAngle = 0;
    double verticalHeigth; 
    double currentTvert = 0;
    ArrayList<Double> averageTVert = new ArrayList<Double>();
    
    public LimelightSubsystem() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        tv = table.getEntry("tv");
        ts = table.getEntry("ts");
        tl = table.getEntry("tl");
        ta = table.getEntry("ta");
        pipeline = table.getEntry("pipeline");
        lightState = table.getEntry("ledMode");
        tvert = table.getEntry("tvert");
    }

    public double getSign(double number){
        if( number > 0 ) {
            return 1; 
        }
        return -1;
    }

    public double tx(){
        return this.xAngle;
    }

    public double ty(){
        return this.yAngle;
    }

    /**
     * Make sure we are constantly updating our network table values
     */
    public void update() {
        double hasTarget = tv.getDouble(0.0);
        if (hasTarget == 1) {
            yAngle = ty.getDouble(0.0);
            xAngle = tx.getDouble(0.0);
            currentTvert = tvert.getDouble(0.0);    
            if(currentTvert>0){updateTVert(currentTvert);}
            SmartDashboard.putNumber("tx", xAngle);
            SmartDashboard.putNumber("Distance", calcXDist());
            SmartDashboard.putNumber("ty", yAngle);
            SmartDashboard.putNumber("ta", ta.getDouble(0.0));
            
        }
        SmartDashboard.putBoolean("Has Target", hasTarget());
    }

    /**
     * @return whether the limelight sees a target or not
     */
    public boolean hasTarget(){
        return(tv.getDouble(0.0)==1);
    }

    public void rightPipeline(){
        pipeline.setValue(2);
    }
    public void leftPipeline(){
        pipeline.setValue(1);
    }

    public void center(){
        pipeline.setValue(0);
    }

    /**
     * @return y distance
     */
    public double calcYDist() {
        double distance = (targetHeight - mountHeight)/Math.tan(Math.toRadians(ty()));
        return distance;
    }

    /**
     * @return x distance
     */
    public double calcXDist(){
        double distance = (targetHeight - mountHeight)/Math.tan(Math.toRadians(ty() + mountAngle));
        return distance;
    }

    /**
     * @return x angle
     */
    public double calcAngle() {
        return xAngle;
    }

    /**
     * @param inches the number of inches to convert to feet
     * @return feet
     */
    public double toFeet(double inches){
        return inches/12;
    }

    public double getTV() {
        return tv.getDouble(0.0);
    }

    public double getTA() {
        return ta.getDouble(0.0);
    }

    public void updateTVert(double current){
        averageTVert.add(current);
        if(averageTVert.size()>vertIterations){
            averageTVert.remove(0);
        }
    }

    public double tvertAverage(){
        double average = 0;
        if(averageTVert.size()>0){
            for(int i =0; i < averageTVert.size();i++){
                average += averageTVert.get(i);
            }
        }
        return average/averageTVert.size();
    }

    public void blink(){
       lightState.setValue(2);
    }

    public void off(){
        lightState.setValue(1);
    }

    public void solid(){
        lightState.setValue(3);
    }
    
    public void defaultValue(){
        lightState.setValue(4);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LimelightCommand());
    }
		
}
