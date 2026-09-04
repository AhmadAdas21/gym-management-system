package softwareProj;

import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
public class Client_Progress_Tracking_feature {
	
    UserAccount userAccount = new UserAccount();
    User client = new User("Ahmad AD", "Ahmad@example.com", "@@@", "Client", "Active", "Weight Loss");
    fitness_programs program = new fitness_programs("Weight Loss 101", "8 weeks", "Beginner", "Weight Loss", "Video", 50);
  instructor m = new instructor();
    client newClient = new client(  client, null, 0);
    @Before
    public void setUp() {
        
        userAccount.addUser(client);
          
        
        program.enrollClient(client, "", 0);
    }

    @Given("the client has enrolled in at least one program")
    public void the_client_has_enrolled_in_at_least_one_program() {
     newClient.receiveProgressReport(client,m.programList);
    }

    @Then("the system displays the following progress details for each enrolled program:")
    public void the_system_displays_the_following_progress_details_for_each_enrolled_program(DataTable dataTable) {
        List<Map<String, String>> expectedProgramDetails = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> programDetail : expectedProgramDetails) {
            String expectedProgramTitle = programDetail.get("Program Title");

          
            assertTrue("Client is not enrolled in the expected program: " + expectedProgramTitle,
                    program.getTitle().equalsIgnoreCase(expectedProgramTitle));
        }
    }
}
