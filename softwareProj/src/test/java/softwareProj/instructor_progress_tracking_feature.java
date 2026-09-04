package softwareProj;

import static org.junit.Assert.assertSame;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class instructor_progress_tracking_feature {

	
	User test1 = new User("hadi", "hadiassayra@gmail.com", "12312", "client", "Active","Silver");
	public UserAccount u = new UserAccount();
	
	fitness_programs pro = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
	User test2 = new User("hadi", "hadi@xuz.com", "12312", "instructor", "Active","nan");
	instructor ins =new instructor();
	@Before
    public void EmptyAvoid() {
      
        u.addUser(test1);
        u.addUser(test2);
        String r="";
        int a=0;
        pro.enrollClient(test1,r,a);
        ins.addProgram(pro);
    }
	
	@Given("I am logged in as an instructor")
	public void i_am_logged_in_as_an_instructor() {
	    
		int n = u.getUserList().indexOf(test2);
		String s=u.getUserList().get(n).getOrganization();
	    
		assertSame("your not an instructor", "instructor", s);

		
		
	}

	@Given("the client has name {string}  enrolled in the {string} program,")
	public void the_client_has_name_enrolled_in_the_program(String string, String string2) {
	    
		string2 = pro.getTitle();
	    string = test1.getName();
		fitness_programs ff = ins.searchBytitle(string2);
		ff.searchUserByTitle(string);
		
	}


	String rate="";
	int atend=0;
	client c = new client(test1, rate ,atend);
	@Then("I should see the details")
	public void i_should_see_the_details() {
		
		c.print();
		
		
	}
  
		

	//2
	
	@Given("the client {string} is enrolled in the {string} program,")
	public void the_client_is_enrolled_in_the_program(String string, String string2) {
		string2 = pro.getTitle();
	    string = test1.getName();
		fitness_programs ff = ins.searchBytitle(string2);
		ff.searchUserByTitle(string);
	}

	Email_Test emailsend = new Email_Test();
	@When("I send a reminder titled {string}")
	public void i_send_a_reminder_titled(String string) {
	    
		emailsend.messageHeader = "from"+test2.getName();
		emailsend.messageContent = "keep going";
		emailsend.emailToContact = test1.getEmail();
	}

	@Then("the client should receive the reminder in their inbox.")
	public void the_client_should_receive_the_reminder_in_their_inbox() {
		emailsend.messageHeader = "from"+test2.getName();
		emailsend.messageContent = "keep going";
		emailsend.emailToContact = test1.getEmail();
		//emailsend.sendEmail(emailsend.messageHeader, emailsend.messageContent, emailsend.emailToContact);
	}
	
	
	
	
	
	
}
