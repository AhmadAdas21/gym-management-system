package softwareProj;

import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Admin_User_Management_feature {

    public UserAccount A;
    User Test1 = new User("Eyas", "iyas@xuz.com", "12312", "Client", "Active","Gold");
    User Test2 = new User("ahmad", "ahmad@xuz.com", "02312", "Client", "Active","Silver");
    User PendingUser = new User("Sara","Sara@xyz.com","2f2","Client","Pending","Platinum");


    public Admin_User_Management_feature(UserAccount ig) {
        A = ig;
    }

    @Before
    public void EmptyAvoid() {
        A.addUser(Test1); 
        A.addUser(Test2);
        A.addUserToPending(PendingUser);
    }

    @Given("the admin panel \\(user management system) is ready")
    public void the_admin_panel_user_management_system_is_ready() {
        assertTrue("The admin panel is not ready!", A.systemIsReady());
    }

    @Given("it contains the following data:")
    public void it_contains_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        assertFalse("The Data of users is empty", A.systemIsEmpty());
        for (User user : A.UserList) { 
            System.out.println(user);
        }
    }

    User tmp;
    String tmpEmail;
    String tmpState;
    @When("I add a new user with the following data:")
    public void i_add_a_new_user_with_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        if (rows.size() < 2) {
            throw new IllegalArgumentException("DataTable must have at least 2 rows, with the second row containing user data.");
        }

        if (rows.get(1).size() < 6) {
            throw new IllegalArgumentException("DataTable must have at least 6 columns for user data (Name, Email, Password, Organization, State, Plan).");
        }

        String name = rows.get(1).get(0);
        String email = rows.get(1).get(1);
        String password = rows.get(1).get(2);
        String organization = rows.get(1).get(3);
        String state = rows.get(1).get(4);
        String plan = rows.get(1).get(5);

        tmpEmail = email;
        tmpState = state;

        tmp = new User(name, email, password, organization, state, plan);

        boolean isUserAdded = A.AddDone(tmp);
        assertTrue("This user already exists or could not be added.", isUserAdded);
    }

    @Then("the new user Eyas should be saved in the system with Active state")
    public void the_new_user_eyas_should_be_saved_in_the_system_with_active_state() {
        A.addUser(tmp);

        boolean isUserAdded = A.getUserList().stream()
            .anyMatch(user -> user.getName().equals("Eyas") && user.getState().equals("Active"));

        assertTrue("User was not saved with the expected state", isUserAdded);
    }

    User tmpFound;
    @When("I update the user with email ahmad@xyz.com to have the following data:")
    public void i_update_the_user_with_email_ahmad_xyz_com_to_have_the_following_data(io.cucumber.datatable.DataTable dataTable) {
        String email12 = "ahmad@xuz.com";
        tmpFound = A.searchUserByEmail(email12);
        assertFalse("Sorry, no result for entered email", tmpFound == null);
    }

    @When("I deactivate the user with email hadi@xyz.com")
    public void i_deactivate_the_user_with_email_hadi_xyz_com() {
        String email12 = "ahmad@xuz.com";
        tmpFound = A.searchUserByEmail(email12);
        assertFalse("User not found for deactivation", tmpFound == null);
        A.deactive("ahmad");
    }

    @Then("the state of the user Hadi should be Inactive")
    public void the_state_of_the_user_hadi_should_be_inactive() {
        String email12 = "ahmad@xuz.com";
        tmpFound = A.searchUserByEmail(email12);

        assertTrue("The user is not deactivated, something went wrong", tmpFound.getState().equalsIgnoreCase("Not Active"));
    }

    @Given("that the pending account list is not empty and the admin panel is ready")
    public void that_the_pending_account_list_is_not_empty_and_the_admin_panel_is_ready() {
        assertFalse("The system is not ready for activating account", A.PendingListIsEmpty());
    }

    @Given("the following client registration requests are pending:")
    public void the_following_client_registration_requests_are_pending(io.cucumber.datatable.DataTable dataTable) {
        for (User r : A.PendingList) {
            System.out.println(r);
        }
    }

    @When("the admin approves the registration request for Sara")
    public void the_admin_approves_the_registration_request_for_sara() {
        String email12 = "Sara@xyz.com";
        tmpFound = A.searchUserByEmailInPending(email12);
      //  System.out.println("Eyasssssss"+tmpFound);
        assertTrue("Pending user not found for approval", tmpFound != null);
        A.approveAcc(tmpFound);
        //System.out.println("Eyassssss2212s"+tmpFound);
    }

    @Then("the state of Sara  account should change to \"Active")
    public void the_state_of_sara_account_should_change_to_active() {
        assertTrue("Sorry this account is not actived",tmpFound.getState().equalsIgnoreCase("Active"));
    }

    @Then("the other pending account for Ali should still be Pending so the list will be:")
    public void the_other_pending_account_for_ali_should_still_be_pending_so_the_list_will_be(io.cucumber.datatable.DataTable dataTable) {
        for (User user : A.PendingList) {
            assertTrue(user.getState().equalsIgnoreCase("Pending"));
        }
    }

    @Given("the admin-panel is ready")
    public void the_admin_panel_is_ready() {
        assertTrue("The admin panel is not ready!", A.systemIsReady());
    }

    @Given("the following clients exist in the system:")
    public void the_following_clients_exist_in_the_system(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> clients = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> clientData : clients) {
            String name = clientData.get("Name");
            String email = clientData.get("Email");
            String password = clientData.get("Password");
            String organization = clientData.get("Organization");
            String state = clientData.get("State");
            String planType = clientData.get("PlanType");

            User newUser = new User(name, email, password, organization, state, planType);

            A.addUser(newUser);
        }

        System.out.println("Clients added to the system: " + clients.size());
    }

    @When("the admin requests client statistics")
    public void the_admin_requests_client_statistics() {
        A.sendStaticReq();
    }

    @Then("the system should provide the following summary:")
    public void the_system_should_provide_the_following_summary(io.cucumber.datatable.DataTable dataTable) {
        A.printSt();
    }



}