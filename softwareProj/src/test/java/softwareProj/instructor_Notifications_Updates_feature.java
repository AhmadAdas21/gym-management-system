package softwareProj;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class instructor_Notifications_Updates_feature {
	
	
	User test1 = new User("hadi", "hadiassayra@gmail.com", "12312", "client", "Active","Silver");
	public UserAccount u = new UserAccount();
	schedules s = new schedules("asd", "asda" , "sad", "sda");
	fitness_programs pro = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
	fitness_programs pro1 = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
	User test2 = new User("hadi", "hadi@xuz.com", "12312", "instructor", "Active","nan");
	instructor ins =new instructor();
	@Before
    public void EmptyAvoid() {
      
        u.addUser(test1);
        u.addUser(test2);
        String r="";
        int a=0;
        s.enrollClient(test1);
        pro.enrollClient(test1,r,a);
        ins.addProgram(pro);
        
    }

	@Given("a group session for {string} is scheduled on {string} at {string}")
	public void a_group_session_for_is_scheduled_on_at(String string, String string2, String string3) {
	    
		schedules ss = new schedules("ydfg", "asfd","adsasd", "wdq");
		ins.addschedules(ss);
		
	}

	@When("I reschedule it to {string}")
	public void i_reschedule_it_to_at(String string) {
	    int i=1;
	    String date="dfs";
		ins.editdate(i,date);
		
		ins.notifyeditDate(i);
		
	}
	@When("I reschedule it at {string}")
	public void i_reschedule_it_at(String string) {
		int i=1;
	    String time="dfs";
		ins.editTime(i,time);
		
		
	}


	@Then("all enrolled clients should receive a notification about the schedule change for date.")
	public void all_enrolled_clients_should_receive_a_notification_about_the_schedule_change_for_date() {
		int i=1;
		ins.notifyeditDate(i);
	}

	@Then("all enrolled clients should receive a notification about the schedule change for time")
	public void all_enrolled_clients_should_receive_a_notification_about_the_schedule_change_for_time() {
		int i=1;
		ins.notifyeditTime(i);
	}
	
	
	@Given("I have created a new program titled {string}")
	public void i_have_created_a_new_program_titled(String string) {
	    ins.addProgram(pro);
	}
	
	@Given("I have created a new Chedule titled {string}")
	public void i_have_created_a_new_chedule_titled(String string) {
	    
		ins.addschedules(s);
	}


	@Then("all clients should receive a notification with the program details.")
	public void all_clients_should_receive_a_notification_with_the_program_details() {
	    
		ins.notifyProgram(pro,u);
		ins.notfyschedule(s,u);
	}
	
	
	@Given("I make offer to  program titled {string}")
	public void i_make_offer_to_program_titled(String string) {
	    int i= 1;
	    double d=0;
		ins.offer(i,d);
		
	}

	@Then("all clients should receive a notification for this offer.")
	public void all_clients_should_receive_a_notification_for_this_offer() {
	    int i =1;
		ins.notifyOffer(i,u);
		
	}
}
