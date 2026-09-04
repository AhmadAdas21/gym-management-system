package softwareProj;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuggestionTest {

    @Test
    public void testConstructor() {
        Suggestion suggestion = new Suggestion("Improve UI", "client@example.com");

        assertNotNull(suggestion);
        assertEquals("Improve UI", suggestion.getContent());
        assertEquals("client@example.com", suggestion.getClientEmail());
    }

    @Test
    public void testGetContent() {
        Suggestion suggestion = new Suggestion("Improve UI", "client@example.com");
        assertEquals("Improve UI", suggestion.getContent());
    }

    @Test
    public void testGetClientEmail() {
        Suggestion suggestion = new Suggestion("Improve UI", "client@example.com");
        assertEquals("client@example.com", suggestion.getClientEmail());
    }

    @Test
    public void testGetProgramTitle() {
        Suggestion suggestion = new Suggestion("Improve UI", "client@example.com");
      
        assertNull(suggestion.getProgramTitle());
    }

    @Test
    public void testToString() {
        Suggestion suggestion = new Suggestion("Improve UI", "client@example.com");
        String expected = "Suggestion{content='Improve UI', clientEmail='client@example.com', programTitle='null'}";
        assertEquals(expected, suggestion.toString());
    }
}
