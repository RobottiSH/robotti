import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;
/**
 * Color sensor logic
 * @author danielml
 * @version 0.0.1
 */
public class Vari {
	private EV3ColorSensor sensori;
	private int nakyy;
	private boolean cancel;
	/**
	 * Creating and updating the sensor.
	 */
	public Vari() {
		this.cancel = false;
	 	this.sensori = new EV3ColorSensor(SensorPort.S1);
	 	while (cancel == false) {
	 		this.nakyy = this.sensori.getColorID();
	 		Delay.msDelay(100);
	 	}
	 	this.sensori.close();
	}
	/**
	 * Hyökkääkö vai ei?
	 * @return true or false
	 */
	public boolean hyokkaa() {
		boolean i = false;
		if (this.nakyy == Color.RED || this.nakyy == Color.BLACK || this.nakyy == Color.GRAY) {
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
