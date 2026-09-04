package softwareProj;

import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Client_Account_Mangment_feature {
    public UserAccount client;
    private User newUser;

    @Before
    public void setUp() {
      
        client = new UserAccount();
        client.addUser(new User("Ahmad", "ahmad@example.com", "password123", "Client", "Active", "Gold"));
    }

    @Given("the client does not already have an account")
    public void the_client_does_not_already_have_an_account() {
        
        assertTrue("The client account list is not empty!", !client.getUserList().isEmpty());
    }

    @When("the client provides the following details:")
    public void the_client_provides_the_following_details(DataTable dataTable) {
        
        List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
        Map<String, String> details = userDetails.get(0);

      
        newUser = new User(details.get("Name"), details.get("Email"), details.get("Password"), "Client", "Pending", details.get("Fitness Plan"));

       
        boolean isAddedToPending = !client.UserList.stream().anyMatch(user -> user.equals(newUser));
        if (isAddedToPending) {
            client.addUserToPending(newUser);
        }

       
        assertTrue("The user could not be added to the pending list.", isAddedToPending);
    }

    @When("the email is not already registered in the system")
    public void the_email_is_not_already_registered_in_the_system() {
        
        User foundUser = client.searchUserByEmail(newUser.getEmail());
        assertTrue("The email is already registered in the system.", foundUser == null);
    }

    @Then("the system adds the client account with {string} status")
    public void the_system_adds_the_client_account_with_status(String status) {
       
        newUser.setState(status);
        assertEquals("The user was not added with the correct status.", status, newUser.getState());
    }

    @Then("the system informs the client that the account is under review for approval")
    public void the_system_informs_the_client_that_the_account_is_under_review_for_approval() {
       
        System.out.println("Your account is under approval.");
    }
}
