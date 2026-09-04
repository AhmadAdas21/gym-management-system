package softwareProj;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeedBackTest {

    @Test
    public void testValidFeedbackCreation() {
        Feedback feedback = new Feedback(
            "Yoga Program", 
            "Eyas Nedal", 
            "eyas.nedal@example.com", 
            4, 
            "Excellent program with great trainers."
        );

        assertEquals("Yoga Program", feedback.getProgramTitle());
        assertEquals("Eyas Nedal", feedback.getClientName());
        assertEquals("eyas.nedal@example.com", feedback.getClientEmail());
        assertEquals(4, feedback.getRating());
        assertEquals("Excellent program with great trainers.", feedback.getReview());
    }

    @Test
    public void testToString() {
        Feedback feedback = new Feedback(
            "Yoga Program",
            "Ali Ahmad",
            "ali.ahmad@example.com",
            5,
            "Fantastic program!"
        );

        String expected = "Program: Yoga Program\n" +
                          "Client: Ali Ahmad (ali.ahmad@example.com)\n" +
                          "Rating: 5 stars\n" +
                          "Review: Fantastic program!";

        assertEquals(expected, feedback.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidProgramTitle_Null() {
        new Feedback(null, "Samer Mohamad", "samer.mohamad@example.com", 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidProgramTitle_Empty() {
        new Feedback("   ", "Samer Mohamad", "samer.mohamad@example.com", 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidClientName_Null() {
        new Feedback("Yoga Program", null, "samer.mohamad@example.com", 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidClientName_Empty() {
        new Feedback("Yoga Program", "   ", "samer.mohamad@example.com", 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidClientEmail_Null() {
        new Feedback("Yoga Program", "Eyas Nedal", null, 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidClientEmail_NoAtSymbol() {
        new Feedback("Yoga Program", "Ali Ahmad", "ali.ahmadexample.com", 4, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRating_TooLow() {
        new Feedback("Yoga Program", "Samer Mohamad", "samer.mohamad@example.com", 0, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRating_TooHigh() {
        new Feedback("Yoga Program", "Eyas Nedal", "eyas.nedal@example.com", 6, "Great program.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidReview_Null() {
        new Feedback("Yoga Program", "Ali Ahmad", "ali.ahmad@example.com", 4, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidReview_Empty() {
        new Feedback("Yoga Program", "Samer Mohamad", "samer.mohamad@example.com", 4, "   ");
    }
}
