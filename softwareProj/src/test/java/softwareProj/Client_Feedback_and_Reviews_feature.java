package softwareProj;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class Client_Feedback_and_Reviews_feature {
	

    UserAccount userAccount = new UserAccount();
    SuggestionManager suggestionManager = new SuggestionManager();
    User testUser = new User("sami barakat", "samibar@example.com", "password123", "Client", "Active", "Weight Loss");
    fitness_programs program = new fitness_programs("Weight Loss 101", "8 weeks", "Beginner", "Weight Loss", "Video", 50);
    Suggestion lastSuggestion;

    @Before
    public void setup() {
        
        userAccount.addUser(testUser);

       
        program.enrollClient(testUser, "", 0);
    }

   


    @Given("I have participated in the program {string}")
    public void i_have_participated_in_the_program(String programTitle) {
    	boolean isEnrolled = program.getTitle().equalsIgnoreCase(programTitle);

        assertTrue("The client has not participated in the program: " + programTitle, isEnrolled);
        System.out.println("Client is enrolled in the program: " + programTitle);
    }

    @When("I enter the feedback {string}")
    public void i_enter_the_feedback(String feedbackContent) {
        
        userAccount.addFeedBack(feedbackContent);
        System.out.println("Feedback received: " + feedbackContent);
    }

    @Then("the admin should receive a notification with the feedback")
    public void the_admin_should_receive_a_notification_with_the_feedback() {
    	 boolean feedbackExists = !userAccount.feedBack.isEmpty();

    	   
    	    assertTrue("Admin did not receive any feedback notification.", feedbackExists);
    	    System.out.println("Admin received the feedback notification: " + userAccount.feedBack.get(userAccount.feedBack.size() - 1));
    }

    @When("I enter the suggestion {string}")
    public void i_enter_the_suggestion(String suggestionContent) {
        
        userAccount.addFeedBack("Suggestion: " + suggestionContent);
        System.out.println("Suggestion received: " + suggestionContent);
    }

    @Then("the instructor should receive a notification with the suggestion")
    public void the_instructor_should_receive_a_notification_with_the_suggestion() {
       
        boolean suggestionExists = userAccount.feedBack.stream()
                .anyMatch(feedback -> feedback.startsWith("Suggestion: "));

        assertTrue("Instructor did not receive the suggestion notification.", suggestionExists);
        System.out.println("Instructor received the suggestion notification.");
    }
}