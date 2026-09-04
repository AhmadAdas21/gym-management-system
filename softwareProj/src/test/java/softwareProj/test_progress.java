package softwareProj;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class test_progress {
	 public UserAccount A;
	 instructor ins =new instructor();
	
	    User TestUser = new User("www", "ww@example.com", "password123", "Client", "Active", "Gold");
    client a = new client(TestUser, null, 0);
	    fitness_programs program1 = new fitness_programs("Yoga", "3 months", "Medium", "Improve flexibility", "Yoga video", 50);
	    fitness_programs program2 = new fitness_programs("Cardio", "6 weeks", "Hard", "Improve endurance", "Cardio routines", 100);

    Progress progress = new Progress("Weight Loss Program", 10, 5.0);

    @Test
    public void testSetAndGetMethods() {
       
        progress.getProgramTitle();
        progress.getAttendedSessions();
        progress.getTotalSessions();
        progress.getWeightLossGoal();
        progress.getCurrentWeightLoss();
        progress.isCompleted();

       
        progress.getProgressBar();
        progress.isWeightLossGoalAchieved();
    }

    @Test
    public void testAttendSession() {
       
        progress.attendSession();
        progress.attendSession();
        progress.getAttendedSessions();
    }

    @Test
    public void testSecondConstructorValidInputs() {
       
        Progress progress = new Progress("Fitness Program", "true", 5);
        progress.getProgramTitle();
        progress.isCompleted();
        progress.getAttendedSessions();
    }

    @Test
    public void testSecondConstructorWithZeroSessions() {
        
        Progress progress = new Progress("Fitness Program", "false", 0);
        progress.getProgramTitle();
        progress.isCompleted();
        progress.getAttendedSessions();
    }

    @Test
    public void testSecondConstructorWithEdgeCaseInputs() {
       
        Progress progress = new Progress("Yoga Program", "true", Integer.MAX_VALUE);
        progress.getProgramTitle();
        progress.isCompleted();
        progress.getAttendedSessions();
    }

    @Test
    public void testSecondConstructorWithEmptyTitle() {


        Progress progress = new Progress("", "true", 3);
        progress.getProgramTitle();
        progress.isCompleted();
        progress.getAttendedSessions();
    }
    @Test
    public void testCompleteAndWeightLoss() {
      
        progress.completeProgram();
        progress.isCompleted();

       
        progress.updateWeightLoss(2.5);
        progress.isWeightLossGoalAchieved();
    }
    @Test
    public void testfromreturn(){
    	
    	    
    	   
    	    program1.enrollClient(TestUser, "80", 10);
    	    program2.enrollClient(TestUser, "70", 12);

    	    
    	    List<fitness_programs> johnsPrograms = program1.getProgramsForUser(TestUser, ins.programList);

    	   
    	  
    	       
    }
    
    
    @Test
    public void testReceiveProgressReport() {
 
        User testUser = new User("John", "john@example.com", "password123", "Client", "Active", "Gold");
        
        
        fitness_programs program1 = new fitness_programs("Yoga", "3 months", "Medium", "Improve flexibility", "Yoga video", 50);
        fitness_programs program2 = new fitness_programs("Cardio", "6 weeks", "Hard", "Improve endurance", "Cardio routines", 100);

        
        client client1 = new client(testUser, null, 0);
        program1.enrollClient(testUser, "75", 10);
        program2.enrollClient(testUser, "80", 8);
        
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  

       
        instructor ins = new instructor();
        client1.receiveProgressReport(testUser, List.of(program1, program2));
        
        
        String output = outputStream.toString();
        
        
        assertTrue(output.contains("Progress Report for John:"));
        assertTrue(output.contains("Completion Rate:"));
        assertTrue(output.contains("Attendance:"));
        assertTrue(output.contains("Enrolled Programs:"));
        assertTrue(output.contains("Yoga"));
        assertTrue(output.contains("Cardio"));
    }
}
