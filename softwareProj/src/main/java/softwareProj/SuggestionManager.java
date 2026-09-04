package softwareProj;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SuggestionManager {
    private static final Logger logger = Logger.getLogger(SuggestionManager.class.getName());
    private List<Suggestion> suggestions;

    public SuggestionManager() {
        this.suggestions = new ArrayList<>();
    }

    public void addSuggestion(Suggestion suggestion) {
        if (suggestion == null) {
            logger.warning("Cannot add a null suggestion.");
            return;
        }
        suggestions.add(suggestion);
        logger.info("Suggestion added successfully: " + suggestion.getProgramTitle());
    }

    public List<Suggestion> getSuggestionsForInstructor(String instructorEmail, List<fitness_programs> programsManagedByInstructor) {
        if (programsManagedByInstructor == null || programsManagedByInstructor.isEmpty()) {
            logger.warning("Programs managed by the instructor are empty or null.");
            return new ArrayList<>();
        }

        List<Suggestion> instructorSuggestions = new ArrayList<>();

        for (Suggestion suggestion : suggestions) {
            for (fitness_programs program : programsManagedByInstructor) {
                if (suggestion != null && program != null &&
                        suggestion.getProgramTitle() != null &&
                        suggestion.getProgramTitle().equalsIgnoreCase(program.getTitle())) {
                    instructorSuggestions.add(suggestion);
                }
            }
        } 

        logger.fine("Suggestions fetched for instructor: " + instructorEmail + " - " + instructorSuggestions.size() + " suggestions found.");
        return instructorSuggestions;
    }

    public void displaySuggestions() {
        if (suggestions == null || suggestions.isEmpty()) {
            logger.warning("No suggestions to display.");
        } else {
            for (Suggestion suggestion : suggestions) {
                logger.info("Suggestion: " + suggestion.getProgramTitle() + " - " + suggestion.getProgramTitle());
            }
        }
    }
}
