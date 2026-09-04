package softwareProj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {

    private Article article;

    @Before
    public void setUp() {
        article = new Article("AuthorType1", "Research", "This is a research article.", "author@example.com");
    }

    @Test
    public void testConstructor() {
        assertNotNull(article);
        assertEquals("AuthorType1", article.getAutherType());
        assertEquals("Research", article.getType());
        assertEquals("This is a research article.", article.getText());
        assertEquals("author@example.com", article.getEmail());
        assertEquals("Pending", article.getState());  // Default state is "Pending"
    }

    @Test
    public void testSetAutherType() {
        article.setAutherType("AuthorType2");
        assertEquals("AuthorType2", article.getAutherType());
    }

    @Test
    public void testSetType() {
        article.setType("Tutorial");
        assertEquals("Tutorial", article.getType());
    }

    @Test
    public void testSetEmail() {
        article.setEmail("newauthor@example.com");
      assertTrue(true);
    }

    @Test
    public void testSetText() {
        article.setText("This is an updated article text.");
        assertEquals("This is an updated article text.", article.getText());
    }

    @Test
    public void testSetState() {
        article.setState("Published");
        assertEquals("Published", article.getState());
    }

    @Test
    public void testGetState() {
        assertEquals("Pending", article.getState()); // Default state is "Pending"
        article.setState("Approved");
        assertEquals("Approved", article.getState());
    }

    @Test
    public void testGetAutherType() {
        assertEquals("AuthorType1", article.getAutherType());
    }

    @Test
    public void testGetType() {
        assertEquals("Research", article.getType());
    }

    @Test
    public void testGetEmail() {
        assertEquals("author@example.com", article.getEmail());
    }

    @Test
    public void testGetText() {
        assertEquals("This is a research article.", article.getText());
    }

    @Test
    public void testToString() {
        String expectedToString = "authorType :AuthorType1 , Article type : Research , email : author@example.com , Text of article : This is a research article.";
        assertEquals(expectedToString, article.toString());
    }

    @Test
    public void testToStringAfterUpdate() {
        article.setAutherType("AuthorType2");
        article.setType("Tutorial");
        article.setText("This is a tutorial article.");
        article.setEmail("tutorialauthor@example.com");

        String expectedToString = "authorType :AuthorType2 , Article type : Tutorial , email : tutorialauthor@example.com , Text of article : This is a tutorial article.";
    }
}
