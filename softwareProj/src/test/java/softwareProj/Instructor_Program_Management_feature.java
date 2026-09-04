package softwareProj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;





import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Instructor_Program_Management_feature {
	
	
	public UserAccount u = new UserAccount();
	User test1 = new User("hadi", "hadi@xuz.com", "12312", "instructor", "Active","nan");
	instructor ins =new instructor();
	@Before
    public void EmptyAvoid() {
        u.addUser(test1); 
        
        fitness_programs pro = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
        ins.addProgram(pro);
    }
	
	@Given("i am on program manage page")
	public void i_am_on_program_manage_page() {
		
	    int n = u.getUserList().indexOf(test1);
		String s=u.getUserList().get(n).getOrganization();
	    
		assertSame("your not an instructor", "instructor", s);

	}
	
	@Given("it contains :")
	public void it_contains(io.cucumber.datatable.DataTable dataTable) {
		
        for (fitness_programs f : ins.programList ) { 
            System.out.println(f);
        }
        assertFalse("The Data of programs is empty", ins.systemIsEmpty());
	}

	fitness_programs fit = new fitness_programs(null, null,null, null, null, 0);
	@When("I create a new fitness program with the following details:")
	public void i_create_a_new_fitness_program_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
	    
		fit.setTitle("Yoga Essentials");
		fit.setDuration( "6 weeks");
		fit.setDifficulty("Beginner");
		fit.setGoals("Improve flexibility");
		fit.setAttachments("Video tutorials");
		fit.setPrice(50);
	}

	
	
	@Then("the program should be saved successfully")
	public void the_program_should_be_saved_successfully() {
		ins.addProgram(fit);
		
		System.out.println("Program added to the system: ");
	}
	


	

	//tag 2
	
	fitness_programs tmp ;
	@Given("a fitness program already exists in the system,")
	public void a_fitness_program_already_exists_in_the_system() {
	    
		int x = 0 ;
		tmp = ins.searchByIndex(1);
		assertNotNull("Sorry, no result for entered program", tmp);
	}

	 	String t;
	    String dur;
	    String dif;
	    String g;
	    String a;
	    double p;
	    int i;
	@When("i edit the program details such as the title, duration,....,")
	public void i_edit_the_program_details_such_as_the_title_duration() {
	     t="t";
	     dur="dur";
	     dif="dif";
	     g="g";
	     a="a";
	     p= 1;
	     i=0;
		
		
	}

	@Then("the system should save the updated information")
	public void the_system_should_save_the_updated_information() {
	   i=1;
		ins.update(i,t,dur,dif,g,a,p );
	}

	@Given("index of program to delete it")
	public void index_of_program_to_delete_it() {
		int x = 1;
		tmp = ins.searchByIndex(x);
		assertNotNull("Sorry, no result for entered program", tmp);
		
	}


	@Then("the system should remove the program from the catalog")
	public void the_system_should_remove_the_program_from_the_catalog() {
	    int x=1;
		ins.delete(x);
	}
	

	
	@Given("i am on program manage")
	public void i_am_on_program_manage() {
		int n = u.getUserList().indexOf(test1);
		String s=u.getUserList().get(n).getOrganization();
	    
		assertSame("your not an instructor", "instructor", s);

	}

	schedules ss;
	@When("I set schedules for group sessions by selecting the session type \\(online or in-person), title, date, and time,")
	public void i_set_schedules_for_group_sessions_by_selecting_the_session_type_online_or_in_person_title_date_and_time() {
	     ss =new schedules("yoga","online","12-12-2024","12:30 AM");
	    
	}


	@Then("the system should record the schedule")
	public void the_system_should_record_the_schedule() {
	    
		ins.addschedules(ss);
		
	}
	
	 instructor inst;
	 @Given("i add program")
	 public void i_add_program() {
		 inst = new instructor();
	        inst.programList = new ArrayList<>(); 
	 }

	 @Then("should handle it")
	 public void should_handle_it() {
	     assertTrue("Expected the system to be empty", inst.systemIsEmpty());
	 }
	
	
	}
	

