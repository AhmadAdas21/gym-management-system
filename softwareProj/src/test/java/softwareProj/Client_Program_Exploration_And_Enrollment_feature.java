package softwareProj;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client_Program_Exploration_And_Enrollment_feature {

    UserAccount u = new UserAccount();
  
    instructor instructor = new instructor();
    User loggedInClient;
    List<fitness_programs> availablePrograms;

    @Before
    public void setup() {
       
        loggedInClient = new User("Ahmad ADAS", "ahmadnaji@example.com", "123", "Client", "Active", "Weight Loss");
        u.addUser(loggedInClient);

        availablePrograms = new ArrayList<>();
        availablePrograms.add(new fitness_programs("Weight Loss 101", "8 weeks", "Beginner", "Weight Loss", "Video", 50));
        availablePrograms.add(new fitness_programs("Muscle Builder", "12 weeks", "Intermediate", "Muscle Building", "PDF", 75));
        availablePrograms.add(new fitness_programs("Flexibility Pro", "6 weeks", "Advanced", "Flexibility", "Guide", 60));

        for (fitness_programs program : availablePrograms) {
            instructor.addProgram(program);
        }
    }

    @Given("the client is logged into the system")
    public void the_client_is_logged_into_the_system() {
        assertTrue("Client is not logged in.", loggedInClient != null && loggedInClient.getState().equalsIgnoreCase("Active"));
    }

    @When("the client selects {string} from the menu")
    public void the_client_selects_from_the_menu(String menuOption) {
        assertTrue("Invalid menu option.", menuOption.equalsIgnoreCase("Browse Programs") || menuOption.equalsIgnoreCase("Track Your Progress"));
    }

    @Then("the system displays the following details for each program:")
    public void the_system_displays_the_following_details_for_each_program(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedPrograms = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> expectedProgram : expectedPrograms) {
            assertTrue("Program not found: " + expectedProgram.get("Title"),
                    availablePrograms.stream().anyMatch(p -> p.getTitle().equals(expectedProgram.get("Title"))));
        }
    }

    @Given("the client has viewed the available programs")
    public void the_client_has_viewed_the_available_programs() {
        assertFalse("No available programs to view.", availablePrograms.isEmpty());
    }

    @When("the client enters the title of the program {string}")
    public void the_client_enters_the_title_of_the_program(String programTitle) {
        assertTrue("Program not found.", instructor.programList.stream().anyMatch(p -> p.getTitle().equals(programTitle)));
    }

    @Then("the system checks if the program exists")
    public void the_system_checks_if_the_program_exists() {
        assertFalse("No programs available to check.", instructor.programList.isEmpty());
    }

    @Then("the system enrolls the client in the program")
    public void the_system_enrolls_the_client_in_the_program() {
        String programTitle = "Weight Loss 101";
        fitness_programs program = instructor.searchBytitle(programTitle);
        assertTrue("Program enrollment failed.", program != null);
    }
    @Then("the system initializes the client's progress for the program with:")
    public void the_system_initializes_the_client_s_progress_for_the_program_with(DataTable dataTable) {
    	 List<Map<String, String>> progressData = dataTable.asMaps(String.class, String.class);
         for (Map<String, String> data : progressData) {
             Progress progress = new Progress(
                     "Weight Loss 101",
                     Integer.parseInt(data.get("Total Sessions")),
                     5.0 
             );
             loggedInClient.ActionTrack(); 
             progress.updateWeightLoss(0.0); 
             assertTrue("Progress initialization failed.", progress.getAttendedSessions() == 0);
             assertTrue("Progress initialization failed.", progress.getProgressBar().equals("0% completed"));
         }
        
    }

  

    @Then("the system displays a confirmation message: {string}")
    public void the_system_displays_a_confirmation_message(String message) {
        System.out.println(message);
    }

   
  
}
