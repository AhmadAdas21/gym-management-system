package softwareProj;

import java.util.ArrayList;
import java.util.List;

public class FeedbackManager {
    private List<Feedback> feedbackList;

    public FeedbackManager() {
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        if (feedback == null) {
            throw new IllegalArgumentException("Feedback cannot be null.");
        }
        feedbackList.add(feedback);
    }

    public List<Feedback> getFeedbackByProgram(String programTitle) {
        List<Feedback> programFeedback = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getProgramTitle().equalsIgnoreCase(programTitle)) {
                programFeedback.add(feedback);
            }
        }
        return programFeedback;
    }

    public double getAverageRating(String programTitle) {
        int totalRating = 0;
        int count = 0;
        for (Feedback feedback : feedbackList) {
            if (feedback.getProgramTitle().equalsIgnoreCase(programTitle)) {
                totalRating += feedback.getRating();
                count++;   }
        }
        return count == 0 ? 0 : (double) totalRating / count;
    }

    public void displayFeedbackForProgram(String programTitle) {
    	
        List<Feedback> programFeedback = getFeedbackByProgram(programTitle);
        
        if (programFeedback.isEmpty()) {
        	
        	
            System.out.println("No feedback available for the program: " + programTitle);
            
        } else {  System.out.println("Feedback for program: " + programTitle);
            
            for (Feedback feedback : programFeedback) {
            	
                System.out.println(feedback);
                System.out.println("--------------------");
               }
        }  } }
