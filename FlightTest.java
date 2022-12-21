import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sbi.Flight;
import com.sbi.FlightRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"classpath:myspring3.xml"} )
public class FlightTest {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Test
	void testSelectAllFlights() {
		System.out.println(">>> Trying to create spring container...");
		/*
		 * ApplicationContext ctx = new ClassPathXmlApplicationContext("myspring3.xml");
		 * System.out.println(">>> spring container...created..........");
		 */
		
		 // = ctx.getBean(FlightRepository.class);
		Assertions.assertTrue(flightRepo!=null);
		System.out.println("Got the flight repo...");
		
		List<Flight> listOfFlight =  flightRepo.getAvailableFlights();
		
		Assertions.assertTrue(listOfFlight.size() > 0 );
		
		for (Flight flight : listOfFlight) {
			System.out.println("Flight : "+flight);
		}
		

	}
	
}
