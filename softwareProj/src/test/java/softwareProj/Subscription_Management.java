package softwareProj;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Subscription_Management {

    public UserAccount A;
    User Test1 = new User("Eyas", "iyas@xuz.com", "12312", "Client", "Active","Unknown");
    User Test2 = new User("ahmad", "ahmad@xuz.com", "02312", "Client", "Active","Silver");
    User PendingUser = new User("Sara","Sara@xyz.com","2f2","Client","Pending","Platinum");
public Subscription_Management (UserAccount ig) {
	A=ig;
}

public void EmptyAvoidnces() {
    
    A.addUser(Test2);
    }

@Given("Admin-panel is ready")
public void admin_panel_is_ready() {
	  assertTrue("Sorry something is wrong,the admin panel is ready",A.systemIsReady());
}

@Given("User List is not empty")
public void user_list_is_not_empty() {
   assertFalse("Sorry no User Found ",A.systemIsEmpty());
}

@When("i add a new user , i can detrmine its Subscribation Plan")
public void i_add_a_new_user_i_can_detrmine_its_subscribation_plan() {
   Test1.setPlantypew("Platinum");
   A.addUser(Test1);
}

@When("i can update its plan")
public void i_can_update_its_plan() {
   
   A.updateUserDetails("Eyas","iyas@xuz.com", "12312","Client", "Active", "Gold");//here we update plan from platinum to gold

}
}
