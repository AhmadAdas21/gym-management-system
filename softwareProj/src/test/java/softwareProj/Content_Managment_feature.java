package softwareProj;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Content_Managment_feature {
	 public UserAccount A;
	 public Article_manage o;
	    User Test1 = new User("Eyas", "iyas@xuz.com", "12312", "Client", "Active","Gold");
	    User Test2 = new User("ahmad", "ahmad@xuz.com", "02312", "Client", "Active","Silver");
	    User PendingUser = new User("Sara","Sara@xyz.com","2f2","Client","Pending","Platinum");
	    Article test =new Article ("Eyas","Article","any text","iyas@xuz.com");
	    Article test2 =new Article ("ahmad","Article","any thing","ahmad@xuz.com");
		String feedBack="Hello, i wish more speed in article acception";
	


	    public Content_Managment_feature(UserAccount ig,Article_manage ig2) {
	        A = ig;
	        o=ig2;
	       
	    }
	    @Before
	    public void EmptyAvoidnces() {
	        A.addUser(Test1); 
	        A.addUser(Test2);
	        A.addUserToPending(PendingUser);
	    o.addArtTip(test);   
	    o.addArtTip(test2);
		A.addFeedBack(feedBack); 
	    }

	

@Given("the Articls_Tips List is ready")
public void the_articls_tips_list_is_ready() {
	 assertFalse("Sorry there is no article or tips in reusts!",o.Article_tipIsEmpty());

}

@When("the admin aprove the article or tip from instructers,or user")
public void the_admin_aprove_the_article_or_tip_from_instructers_or_user() {
 o.approveArticle("iyas@xuz.com");
}

@Then("in the user interface it should be shown")
public void in_the_user_interface_it_should_be_shown() {
    o.showArtTipApproved();
}

@Then("thier state is approved")
public void thier_state_is_approved() {
	 assertTrue("Sorry something wrong happend!",test.getState().equalsIgnoreCase("approved"));

}

@Then("if the admin reject the request for tip or article")
public void if_the_admin_reject_the_request_for_tip_or_article() {
	 o.rejectArticle("ahmad@xuz.com");

}

@Then("the Articls or tips State should be rejected")
public void the_articls_or_tips_state_should_be_rejected() {
	 assertTrue("The operation Faild",test2.getState().equalsIgnoreCase("rejected"));

}

@Given("the feedback List is not empty")
public void the_feedback_list_is_not_empty() {

    assertFalse("Sorry , No feedBack",A.feedBacksIsEmpty());

}

@Then("the admin should see a list of feedbacks, each feedback with user-writter email.")
public void the_admin_should_see_a_list_of_feedbacks_each_feedback_with_user_writter_email() {
    
	A.showFeedBacks();

}




}