import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Class which start cars and find the winner
 * @author Yulia Krivitskaya
 *
 */

public class Racing {

	private final List<Car> raceCars;

    public Racing(List<Car> raceCars) {
        this.raceCars = raceCars;
    }
/**
 * The race is started
 * (Start all threads of cars)
 * @return car that finished first
  */
    public Car go() throws InterruptedException {
        ArrayBlockingQueue<Car> finishedCars = new ArrayBlockingQueue<Car>(raceCars.size());
        for (Car raceCar : raceCars) {
        	raceCar.setFinishedCars(finishedCars);
        	raceCar.start();
          }
        //disqualify 2 cars
        raceCars.get(3).disqualify();
        raceCars.get(5).disqualify();
        return finishedCars.take();
    }
	
}
