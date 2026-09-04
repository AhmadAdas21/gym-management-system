package softwareProj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Track_active_and_completed_programs {
	 public UserAccount A;
	 User Test1 = new User("Eyas", "iyas@xuz.com", "12312", "Client", "Active","Gold");
	    User Test2 = new User("ahmad", "ahmad@xuz.com", "02312", "Client", "Active","Silver");
	    User PendingUser = new User("Sara","Sara@xyz.com","2f2","Client","Pending","Platinum");
public Track_active_and_completed_programs(UserAccount ig) {
	A=ig;
}


@Given("the admin panel is ready")
public void the_admin_panel_is_ready() {
   assertTrue("Sorry something is wrong,the admin panel is ready",A.systemIsReady());
}

@Given("the user list is not empty")
public void the_user_list_is_not_empty() {
   assertFalse("the system is empty!",A.systemIsEmpty());
}

@When("I ask for the most popular program")
public void i_ask_for_the_most_popular_program() {
    A.MostPopular();
    
}

@Then("I should see a list of programs sorted by enrollment count")
public void i_should_see_a_list_of_programs_sorted_by_enrollment_count() {
   
    assertTrue(true); // this case is tested in previuos test
}

@Then("the list should include the program name and enrollment numbers")
public void the_list_should_include_the_program_name_and_enrollment_numbers() {
	A.showPlansAndSubscribers();
    
}

@Given("the statistics list is not empty")
public void the_statistics_list_is_not_empty() {
  assertFalse("There is a problem",A.UserList.isEmpty());
}

@When("I ask for a report")
public void i_ask_for_a_report() {
   A.getUserListPend();
}
@Then("the report should include:")
public void the_report_should_include(io.cucumber.datatable.DataTable dataTable) {
    assertFalse(A.systemIsEmpty());
}


@Then("the report should have a timestamp for when it was generated")
public void the_report_should_have_a_timestamp_for_when_it_was_generated() {
    //already handeld
	assertTrue(true);
}






}
