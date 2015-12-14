import lejos.hardware.port.SensorPort; 
import lejos.hardware.sensor.EV3ColorSensor; 
import lejos.robotics.Color; 
import lejos.utility.Delay; 
/** 
 * Color sensor logic 
 * @author Daniel Lange 
 * @version 0.0.2 
 */ 
public class Vari { 
private EV3ColorSensor sensori; 
private int nakyy; 
private boolean cancel; 
	/** 
	 * Creating the sensor. 
	 */ 
	public Vari() { 
	this.cancel = false; 
 	this.sensori = new EV3ColorSensor(SensorPort.S1);
	}
	/**
	 *  Updating sensor data.
	 */
	public void paivita() {
		while (this.cancel == false) { 
	 		this.nakyy = this.sensori.getColorID(); 
	 		Delay.msDelay(100); 
		 	} 
		 	this.sensori.close(); 
	}
	/** 
	 * Alarm yes/no 
	 * @return true or false 
	 */ 
	public boolean halyttaa() { 
		boolean i = false; 
		if (this.nakyy == Color.BLACK) { 
 			i = true; 
 		} 
 		return i; 
 	} 
 	/** 
 	 * Shuts down the sensor 
 	 */ 
 	public void stop(EV3ColorSensor cs){ 
 		this.sensori = cs; 
 		this.cancel = true; 
 	} 
 } 
