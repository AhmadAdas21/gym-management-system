package softwareProj;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testUnuses {

	
	schedules s =new schedules("yoga","online","12-12-2024","12:30 AM");;
	List<User> enrolledClients   = new ArrayList<>();
	User test1 = new User("hadi", "hadiassayra@gmail.com", "12312", "client", "Active","Silver");
	client c =new client(test1, "", 0);
	fitness_programs pro = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
	@Test
	public void setSch() {
		
		s.setTitle("");
		s.setState("");
		s.getState();
		s.setEnrolledClients(enrolledClients);
		s.getEnrolledClients();
		s.toString();
		s.enrollClient(test1);
		s.enrollClient(test1);
		
	}
	
	@Test
	public void setClient() {
		
		c.setU(test1);
		c.setA(0);
		c.setR("");
		c.getA();
		c.getR();
	}
	@Test
	public void setfit() {
		
		pro.getAttachments();
		pro.getDifficulty();
		pro.getDuration();
		pro.getGoals();
		pro.getPrice();
		pro.getTitle();
	}
	
	
	
}
