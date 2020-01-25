package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import org.firstfrc.team5895.robot.lib.NavX; //Need to fix. NavX is a sensor for angles. 

public class Limelight {

	// make sure to use the new library that doesn't have "wpilibj" in the path
	private NetworkTable table;

	// input
	private boolean hasTarget;
	private double horizontalOffset; // -27 to 27 degrees
	private double verticalOffset; // -20.5 to 20.5 degrees
	private double area; // % of image
	private double rotation; // -90 to 0 degrees
	private double latency; // ms (Add at least 11ms for image capture latency)

	// output
	private LedMode led = LedMode.ON;
	private CamMode cam = CamMode.VISION_PROCESSING; // operation mode
	private double pipeline = 0; // current pipeline
	private VideoMode videoMode;
	/**
	 * Sets enum types of LED mode: ON, OFF, BLINKING
	 * 
	 */
	public enum LedMode {
		ON(0),OFF(1),BLINKING(2);

		private double value;

		LedMode(double value){
			this.value = value;
		}

		public double getValue() {
			return value;
		}
	}

	/**
	 * Sets enum types of Camera mode: VISION_PROCESSING (Vision mode), DRIVER_CAMERA (Raw Image)
	 *
	 */
	public enum CamMode {
		VISION_PROCESSING(0),DRIVER_CAMERA(1);

		private double value;

		CamMode(double value){
			this.value = value;
		}

		public double getValue() {
			return value;
		}
	}
	
	/**
	 * Start NetworkTable
	 * Initialize NetworkTable of Limelight
	 * Run UsbCamera
	 */
	public Limelight() {
		NetworkTableInstance.getDefault().startClient(); //
		table = NetworkTableInstance.getDefault().getTable("limelight");
		
		// usb camera
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		//camera.setResolution(640, 360); //only works for 640 x 360
		videoMode = new VideoMode(PixelFormat.kYUYV, 800, 448, 30);
		//set DriverStation resolution to:
		//320 x 240 for ~15 fps
		//160 x 120 for ~20 fps
		camera.setFPS(30);
		camera.setVideoMode(videoMode);
		//usable width/height values: 
		//176 x 144
		//320 x 180
		//640 x 360 
		//640 x 480 
		//800 x 448 
		//1024 x 576 
		//1280 x 720
	}

	public static double posX, posY; // feet
	public static double lastDistance = 0d; // distance traveled the last time update() was called
	public double getDistanceTraveled() {
		return (leftEncoder.getDistance()+rightEncoder.getDistance())/2;
		//we're not using an encoder
	}
	public double getAngle() {
		return navX.getAngle(); // navX reads angle in degree
	}
	/**
	 * Update all methods in need of routine refreshing
	 * 
	 */
	public void update() {
		updateHasTarget();
		updateHorizontalOffset();
		updateVerticalOffset();
		updateTargetArea();
		updateRotation();
		updateLatency();
		updateLedMode();
		updateCamMode();

		//changing position and distance
		double distance = getDistanceTraveled()-lastDistance;
		//Adjusting angle based distance (aiming)
		posX += distance*Math.cos(Math.toRadians(getAngle()));
		posY += distance*Math.sin(Math.toRadians(getAngle()));
		
		distance = getDistanceTraveled();
			
	}
	
	/**
	 * Update boolean hasTarget
	 */
	public void updateHasTarget() {
		double val = table.getEntry("tv").getDouble(-1);
		if (val == 0d) {
			hasTarget = false;
		} else if (val == 1d) {
			hasTarget = true;
		} 
	}

	public void updateHorizontalOffset() {
		horizontalOffset = table.getEntry("tx").getDouble(-1);
	}

	public void updateVerticalOffset() {
		verticalOffset = table.getEntry("ty").getDouble(-1);
	}


	public void updateTargetArea() {
		area = table.getEntry("ta").getDouble(-1);
	}

	public void updateRotation() {
		rotation = table.getEntry("ts").getDouble(-1);
	}

	public void updateLatency() {
		latency = table.getEntry("tl").getDouble(-1);
	}

	public void updateLedMode() {
		table.getEntry("ledMode").setDouble(led.getValue());
	}

	public void updateCamMode() {
		table.getEntry("camMode").setDouble(cam.getValue());
	}

	public void updatePipeline() {
		table.getEntry("pipeline").setDouble(pipeline);
	}

	public void setLedMode(LedMode led) {
		this.led = led;
	}

	public void setCamMode(CamMode cam) {
		this.cam = cam;
	}

	public void setPipeline(double pipeline) {
		this.pipeline = Math.max(Math.min(pipeline, 9), 0);
	}

	public boolean hasTarget() {
		return hasTarget;
	}

	public double getHorizontalOffset() {
		return horizontalOffset;
	}

	public double getVerticalOffset() {
		return verticalOffset;
	}

	public double getArea() {
		return area;
	}

	public double getRotation() {
		return rotation;
	}

	public double getLatency() {
		return latency;
	}

	public LedMode getLED() {
		return led;
	}

	public CamMode getCAM() {
		return cam;
	}

	public double getPipeline() {
		return pipeline;
	}

}