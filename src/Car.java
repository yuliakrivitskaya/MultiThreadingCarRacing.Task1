import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

/**
 * Class - Thread describe Car for racing
 * 
 * @author Yulia Krivitskaya
 *
 */
public class Car extends Thread {
	private ArrayBlockingQueue<Car> finishedCars;
	Logger log = Logger.getLogger(this.getClass().getSimpleName());

	/** Distance for racing */
	private static final long MAX_DISTANCE = 10000;
	/** Time of DISQUALIFICATION */
	public final long TIME_DISQUALIFICATION = 1000;
	/** friction car */
	private long friction;
	/** distance that the car has passed */
	private long distance;
	/** name of Car */
	private String nameCar;
	/** if can disqualify */
	private boolean isDisqualify;

	public Car(String nameCar, long friction) {
		this.nameCar = nameCar;
		this.friction = friction;
		isDisqualify = false;
	}

	@Override
	public void run() {
		try {

			while (distance < MAX_DISTANCE) {
				Thread.sleep(friction);
				distance += 100;
				log.info(nameCar + " " + distance);

				while (isDisqualify) {
					Thread.sleep(TIME_DISQUALIFICATION);
					Thread.currentThread().interrupt();
					qualify();
				}

			}

		} catch (InterruptedException e) {
			log.info(nameCar + " was disqualify for " + TIME_DISQUALIFICATION / 1000 + " sec");
			Thread.currentThread().run();
		}
		log.info(nameCar + " is finished");
		finishedCars.offer(this);
	}

	/**
	 * Method which disqualify car
	 */
	public void disqualify() {
		isDisqualify = true;
		log.info(nameCar + " is disqualify ");

	}

	/**
	 * Method which qualify car
	 */
	public void qualify() {
		isDisqualify = false;
	}

	public String getNameCar() {
		return nameCar;
	}

	public void setFinishedCars(ArrayBlockingQueue<Car> finishedCars) {
		this.finishedCars = finishedCars;
	}

}