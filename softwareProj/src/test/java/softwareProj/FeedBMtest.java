package softwareProj;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FeedBMtest {

    private FeedbackManager feedbackManager;

    @Before
    public void setUp() {
        feedbackManager = new FeedbackManager();
    }

    @Test
    public void testAddFeedback() {
        Feedback feedback = new Feedback("Yoga Program", "Alice Johnson", "alice.johnson@example.com", 5, "Excellent!");
        feedbackManager.addFeedback(feedback);

        List<Feedback> feedbackList = feedbackManager.getFeedbackByProgram("Yoga Program");
        assertEquals(1, feedbackList.size());
        assertEquals(feedback, feedbackList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFeedback_NullFeedback() {
        feedbackManager.addFeedback(null);
    }

    @Test
    public void testGetFeedbackByProgram() {
        Feedback feedback1 = new Feedback("Yoga Program", "Alice Johnson", "alice.johnson@example.com", 5, "Great!");
        Feedback feedback2 = new Feedback("Yoga Program", "Bob Smith", "bob.smith@example.com", 4, "Good!");
        Feedback feedback3 = new Feedback("Pilates Program", "Charlie Brown", "charlie.brown@example.com", 3, "Okay.");

        feedbackManager.addFeedback(feedback1);
        feedbackManager.addFeedback(feedback2);
        feedbackManager.addFeedback(feedback3);

        List<Feedback> yogaFeedback = feedbackManager.getFeedbackByProgram("Yoga Program");
        assertEquals(2, yogaFeedback.size());
        assertTrue(yogaFeedback.contains(feedback1));
        assertTrue(yogaFeedback.contains(feedback2));

        List<Feedback> pilatesFeedback = feedbackManager.getFeedbackByProgram("Pilates Program");
        assertEquals(1, pilatesFeedback.size());
        assertTrue(pilatesFeedback.contains(feedback3));

        List<Feedback> noFeedback = feedbackManager.getFeedbackByProgram("Zumba Program");
        assertTrue(noFeedback.isEmpty());
    }

    @Test
    public void testGetAverageRating() {
        Feedback feedback1 = new Feedback("Yoga Program", "Alice Johnson", "alice.johnson@example.com", 5, "Great!");
        Feedback feedback2 = new Feedback("Yoga Program", "Bob Smith", "bob.smith@example.com", 4, "Good!");

        feedbackManager.addFeedback(feedback1);
        feedbackManager.addFeedback(feedback2);

        double averageRating = feedbackManager.getAverageRating("Yoga Program");
        assertEquals(4.5, averageRating, 0.01);

        double noRating = feedbackManager.getAverageRating("Zumba Program");
        assertEquals(0.0, noRating, 0.01);
    }

    @Test
    public void testDisplayFeedbackForProgram() {
        Feedback feedback1 = new Feedback("Yoga Program", "Alice Johnson", "alice.johnson@example.com", 5, "Great!");
        Feedback feedback2 = new Feedback("Yoga Program", "Bob Smith", "bob.smith@example.com", 4, "Good!");

        feedbackManager.addFeedback(feedback1);
        feedbackManager.addFeedback(feedback2);

        feedbackManager.displayFeedbackForProgram("Yoga Program");
        feedbackManager.displayFeedbackForProgram("Pilates Program"); // Should print no feedback available
    }
}
