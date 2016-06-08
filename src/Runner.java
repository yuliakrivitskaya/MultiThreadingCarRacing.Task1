import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class Runner {

	public static void main(String[] args) throws InterruptedException {
		 
		ArrayList<Car> carsForRace = new ArrayList<Car>();
		carsForRace.add(new Car("Car#1", 100));
		carsForRace.add(new Car("Car#2", 110));
		carsForRace.add(new Car("Car#3", 120));
		carsForRace.add(new Car("Car#4", 100));
		carsForRace.add(new Car("Car#5", 150));
		carsForRace.add(new Car("Car#6", 100));
		carsForRace.add(new Car("Car#7", 110));
		carsForRace.add(new Car("Car#8", 100));
		carsForRace.add(new Car("Car#9", 110));
		carsForRace.add(new Car("Car#10", 100));
		carsForRace.add(new Car("Car#11", 110));

		Racing race = new Racing(carsForRace.subList(0, carsForRace.size()));
        try {
            Car winner = race.go();
            Thread.sleep(6000);
            System.out.println("The winner is " + winner.getNameCar());
           
        } catch (InterruptedException e) {
            System.out.println("The race was interrupted, maybe by a streaker?");
        }
    }

}
