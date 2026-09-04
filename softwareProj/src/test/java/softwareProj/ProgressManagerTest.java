
package softwareProj;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProgressManagerTest {

    private ProgressManager progressManager;
    private fitness_programs fitnessProgram;
    private Progress progress;
    private User user;

    @Before
    public void setUp() {
        progressManager = new ProgressManager();
        fitnessProgram = new fitness_programs("Fitness Program", "6 months", "Intermediate", "Lose weight", "Videos", 100.0);
        progress = new Progress("Fitness Program", 10, 15.0);
        user = new User("Sara", "john@example.com", "password", "HealthCorp", "NY", "Basic");
    }

    @Test
    public void testAddFitnessProgram() {
        progressManager.addFitnessProgram(fitnessProgram);
        assertEquals(1, progressManager.getAllFitnessPrograms().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFitnessProgram_NullProgram() {
        progressManager.addFitnessProgram(null);
    }

    @Test
    public void testGetFitnessProgramByTitle() {
        progressManager.addFitnessProgram(fitnessProgram);
        fitness_programs retrievedProgram = progressManager.getFitnessProgramByTitle("Fitness Program");
        assertEquals(fitnessProgram, retrievedProgram);
    }

    @Test
    public void testGetFitnessProgramByTitle_ProgramNotFound() {
        assertNull(progressManager.getFitnessProgramByTitle("NonExistingProgram"));
    }

    @Test
    public void testAddProgress() {
        progressManager.addProgress(progress);
        assertEquals(1, progressManager.getAllProgress().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProgress_NullProgress() {
        progressManager.addProgress(null);
    }

    @Test
    public void testGetProgressByProgramTitle() {
        progressManager.addProgress(progress);
        Progress retrievedProgress = progressManager.getProgressByProgramTitle("Fitness Program");
        assertEquals(progress, retrievedProgress);
    }

    @Test
    public void testGetProgressByProgramTitle_ProgressNotFound() {
        assertNull(progressManager.getProgressByProgramTitle("NonExistingProgram"));
    }

   

    @Test(expected = IllegalArgumentException.class)
    public void testEnrollClientInProgram_ProgramNotFound() {
        progressManager.enrollClientInProgram("NonExistingProgram", user, "Client", 30);
    }

    @Test
    public void testListClientsInProgram() {
        progressManager.addFitnessProgram(fitnessProgram);
        progressManager.enrollClientInProgram("Fitness Program", user, "Client", 30);
        progressManager.listClientsInProgram("Fitness Program");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListClientsInProgram_ProgramNotFound() {
        progressManager.listClientsInProgram("NonExistingProgram");
    }

    @Test
    public void testSearchUserByTitle() {
        fitnessProgram.enrollClient(user, "Client", 30);
        User foundUser = fitnessProgram.searchUserByTitle("Sara");
        assertNotNull(foundUser);
        assertEquals("Sara", foundUser.getName());
    }

    @Test
    public void testShowEnrolledClients() {
        fitnessProgram.enrollClient(user, "Client", 30);
        fitnessProgram.show(); 
    }

    
    

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidWeightLoss() {
        progress.updateWeightLoss(-1);
    }

    @Test
    public void testProgressBar() {
        progress.attendSession();
        assertEquals("10% completed", progress.getProgressBar());
    }
}
