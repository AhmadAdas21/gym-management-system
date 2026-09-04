package softwareProj;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class SuggestionManagerTest {

    private SuggestionManager suggestionManager;
    private List<fitness_programs> programsManagedByInstructor;

    @Before
    public void setUp() {
      
        suggestionManager = new SuggestionManager();
        programsManagedByInstructor = new ArrayList<>();

       
        programsManagedByInstructor.add(new fitness_programs("Weight Loss Program", "3 months", "Intermediate", "Lose weight", "Video tutorial", 199.99));
        programsManagedByInstructor.add(new fitness_programs("Muscle Gain Program", "2 months", "Advanced", "Build muscle", "Nutrition guide", 149.99));
    }

    @Test
    public void testAddSuggestion() {
       
        suggestionManager.addSuggestion(new Suggestion("Weight Loss Program", "Great program!"));
        suggestionManager.addSuggestion(new Suggestion("Muscle Gain Program", "Needs improvement."));
    }

    @Test
    public void testAddNullSuggestion() {
     
        suggestionManager.addSuggestion(null);
    }

    @Test
    public void testGetSuggestionsForInstructor_NoSuggestions() {
      
        List<Suggestion> instructorSuggestions = suggestionManager.getSuggestionsForInstructor("abd@example.com", programsManagedByInstructor);
        System.out.println("Suggestions fetched (No suggestions added): " + instructorSuggestions.size());
    }

    @Test
    public void testGetSuggestionsForInstructor_WithSuggestions() {
       
        suggestionManager.addSuggestion(new Suggestion("Weight Loss Program", "Great program!"));
        suggestionManager.addSuggestion(new Suggestion("Muscle Gain Program", "Needs improvement."));

       
        List<Suggestion> instructorSuggestions = suggestionManager.getSuggestionsForInstructor("ahmad@example.com", programsManagedByInstructor);
        System.out.println("Suggestions fetched (With suggestions): " + instructorSuggestions.size());
    }

    @Test
    public void testGetSuggestionsForInstructor_NoMatchingSuggestions() {
       
        suggestionManager.addSuggestion(new Suggestion("Yoga Program", "Improve flexibility"));
        suggestionManager.addSuggestion(new Suggestion("Pilates Program", "Great for core strength"));

        
        List<Suggestion> instructorSuggestions = suggestionManager.getSuggestionsForInstructor("Qais@example.com", programsManagedByInstructor);
        System.out.println("Suggestions fetched (No matches): " + instructorSuggestions.size());
    }

    @Test
    public void testDisplaySuggestions_NoSuggestions() {
        
        suggestionManager.displaySuggestions();
    }

    @Test
    public void testDisplaySuggestions_WithSuggestions() {
        
        suggestionManager.addSuggestion(new Suggestion("Weight Loss Program", "Great program!"));
        suggestionManager.addSuggestion(new Suggestion("Muscle Gain Program", "Needs improvement."));

        
        suggestionManager.displaySuggestions();
    }
}
