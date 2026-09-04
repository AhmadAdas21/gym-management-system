package softwareProj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest {

    private instructor instructor;
    private fitness_programs program1;
    private fitness_programs program2;
    private schedules schedule1;
    private schedules schedule2;
    private User user;
    private UserAccount userA;
    private client client;
    @Before
    public void setUp() {
        instructor = new instructor();
        program1 = new fitness_programs("Weight Loss Program", "3 months", "Intermediate", "Lose weight", "Video tutorial", 248.4801);
        program2 = new fitness_programs("Muscle Gain Program", "2 months", "Advanced", "Build muscle", "Nutrition guide", 149.99);
        schedule1 = new schedules("Morning Class", "2025-01-10", "10:00 AM", "Morning Session");
        schedule2 = new schedules("Evening Class", "2025-01-10", "6:00 PM", "Evening Session");
        user = new User("", "hadi@xyz.com", "", "instructor", "active", "");
        userA= new UserAccount();
        client =new client(user, "", 0);
    }

    @Test
    public void testAddProgram() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        assertEquals(2, instructor.programList.size());
    }

    @Test
    public void testSearchByIndex() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        fitness_programs result = instructor.searchByIndex(2);
        assertNotNull(result);
        assertEquals("Muscle Gain Program", result.getTitle());
    }
    @Test
    public void testSearchByIndexNull() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        fitness_programs result = instructor.searchByIndex(3);
        assertNull(result);
    }
    @Test
    public void testUpdateProgram() {
        instructor.addProgram(program1);
        boolean updated = instructor.update(1, "Updated Program", "6 months", "Beginner", "Strengthen muscles", "Online resources", 250.99);
        assertTrue(updated);
        assertEquals("Updated Program", instructor.programList.get(0).getTitle());
    }

    @Test
    public void testDeleteProgram() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        boolean deleted = instructor.delete(1);
        assertTrue(deleted);
        assertEquals(1, instructor.programList.size());
    }

    @Test
    public void testShowPrograms() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        boolean displayed = instructor.show();
        assertTrue(displayed);
    }

    @Test
    public void testSearchByTitle() {
        instructor.addProgram(program1);
        instructor.addProgram(program2);
        fitness_programs result = instructor.searchBytitle("Weight Loss Program");
        assertNotNull(result);
        assertEquals("Weight Loss Program", result.getTitle());
    }

    @Test
    public void testAddSchedule() {
        instructor.addschedules(schedule1);
        instructor.addschedules(schedule2);
        assertEquals(2, instructor.schedulesList.size());
    }

    @Test
    public void testEditScheduleDate() {
        instructor.addschedules(schedule1);
        boolean edited = instructor.editdate(1, "2025-01-15");
        assertTrue(edited);
        assertEquals("2025-01-15", instructor.schedulesList.get(0).getDate());
    }

    @Test
    public void testEditScheduleTime() {
        instructor.addschedules(schedule1);
        boolean edited = instructor.editTime(1, "8:00 AM");
        assertTrue(edited);
        assertEquals("8:00 AM", instructor.schedulesList.get(0).getTime());
    }
 
    @Test
    public void testNotifyEditDate() {
      
        instructor.addschedules(schedule1);
        instructor.notifyeditDate(1);
    }

    @Test
    public void testNotifyEditTime() {
       
        instructor.addschedules(schedule1);
        instructor.notifyeditTime(1);
    }

    @Test
    public void testNotifyEditProgram() {
      
        instructor.addProgram(program1);
        instructor.notifyeditProgram(1);
    }
 
   
    @Test
    public void testNotifyOffer() {
      
        instructor.addProgram(program1);
        instructor.notifyOffer(1, new UserAccount());
    }
    @Test
    public void sendToUser() {
      
        instructor.addProgram(program1);
        instructor.sendToUser(new UserAccount(),"", "");
    }
    @Test
    public void testShowSchedule() {
        instructor.addschedules(schedule1);
        instructor.addschedules(schedule2);
        instructor.showSchedule();
    }
    @Test
    public void testShowScheduleB() {
        instructor.addschedules(schedule1);
        instructor.addschedules(schedule2);
        instructor.showSc();
    }
    
    @Test
    public void testeditDateEmail() {
        instructor.addschedules(schedule1);
        instructor.addschedules(schedule2);
        schedule1.enrollClient(user);
        instructor.editDateEmail(schedule1, user);
    }
    @Test
    public void testeditTimeEmail() {
    	instructor.addschedules(schedule1);
        schedule1.enrollClient(user);
        instructor.editTimeEmail(schedule1, user);
    }
    
    @Test
    public void testupdateEmail() {
        
    	instructor.addProgram(program1);
    	program1.enrollClient(user, "", 0);
        instructor.updateEmail(program1, client);
    }
    
}
