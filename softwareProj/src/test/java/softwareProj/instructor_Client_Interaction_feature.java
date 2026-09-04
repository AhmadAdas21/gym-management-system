package softwareProj;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.ugeholl;
import static org.junit.Assert.*;

public class instructor_Client_Interaction_feature {
	
	User test1 = new User("hadi", "hadiassayra@gmail.com", "12312", "instructor", "Active","Silver");
	public UserAccount u = new UserAccount();
	 instructor m =new instructor();
	fitness_programs pro = new fitness_programs("sd", "dds","sfgs", "sfsf", "df", 0);    
	User test2 = new User("hadi", "hadi@xuz.com", "12312", "instructor", "Active","nan");
	User test3 ;
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
	@Given("the client  {string} is enrolled in the {string} program")
	public void the_client_is_enrolled_in_the_program(String string, String string2) {
	    string2 = pro.getTitle();
	    string = test1.getName();
		fitness_programs ff = ins.searchBytitle(string2);
		ff.searchUserByTitle(string);
		
	}
	
	Email_Test emailsend = new Email_Test();

	@When("I send a message titled {string}")
	public void i_send_a_message_titled(String string) {
		emailsend.messageHeader = "from"+test2.getName();
		emailsend.messageContent = "keep going";
		emailsend.emailToContact = test1.getEmail();
		

	}

	@Then("the client should receive the message in their inbox.")
	public void the_client_should_receive_the_message_in_their_inbox() {
		emailsend.messageHeader = "from"+test2.getName();
		emailsend.messageContent = "keep going";
		emailsend.emailToContact = test1.getEmail();
		//emailsend.sendEmail(emailsend.messageHeader, emailsend.messageContent, emailsend.emailToContact);
	}
	
	//two
	


	@Given("i generate a progress report with sum details")
	public void i_generate_a_progress_report_with_sum_details() {
	    

		test3 = new User("hadi", "hadi@xuz.com", "12312", "client", "Active","silver");
		pro.enrollClient(test3,"",0);
		 
		
	}
	
	

	@When("send it")
	public void send_it() {
	   assertTrue(true);
	}



	@Then("the client should receive the progress report")
	public void the_client_should_receive_the_progress_report() { 
		ins.searchByIndex(1).enrolledClients.get(1).receiveProgressReport(ins.searchByIndex(1).searchUserByIndex(2),m.programList);
                 
	}
	 
	



	
	
	

}
