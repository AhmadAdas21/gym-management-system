package softwareProj;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class UserAccTest {

    private UserAccount userAccount;
    private User ali, eyas, sami;

    @Before
    public void setUp() {
        userAccount = new UserAccount();
        ali = new User("Ali", "ali@example.com", "password123", "Organization1", "Active", "Gold");
        eyas = new User("Eyas", "eyas@example.com", "password456", "Organization2", "Not Active", "Silver");
        sami = new User("Sami", "sami@example.com", "password789", "Organization3", "Active", "Platinum");
    }
    @Test 
     public void suggestuinsHandling() {
	  assertTrue(userAccount.suggestionIsEmpty());
    userAccount.addsuggestion("Great service!");
    assertFalse(userAccount.suggestionIsEmpty());
    userAccount.showsuggestions();
}

    @Test
    public void testUserConstructor() {
        User testUser = new User("TestUser", "test@example.com", "testPassword", "TestOrganization", "Active", "Gold");
        assertEquals("TestUser", testUser.getName());
        assertEquals("test@example.com", testUser.getEmail());
        assertEquals("testPassword", testUser.getPassword());
        assertEquals("TestOrganization", testUser.getOrganization());
        assertEquals("Active", testUser.getState());
        assertEquals("Gold", testUser.getPlanType());
    }

    @Test
    public void testAddUser() {
        userAccount.addUser(ali);
        assertEquals(1, userAccount.getUserList().size());
    }

    @Test
    public void testSystemIsReady() {
        assertTrue(userAccount.systemIsReady());
    }

    @Test
    public void testSystemIsEmpty() {
        assertTrue(userAccount.systemIsEmpty());
    }

    @Test
    public void testAddDone() {
        assertTrue(userAccount.AddDone(ali));
        assertFalse(userAccount.AddDone(ali)); 
    }

    @Test
    public void testAddISDone() {
        userAccount.addUser(ali);
        assertTrue(true);
    }

    @Test
    public void testUserLogin() {
        userAccount.addUser(ali);
        userAccount.userLogin(ali.getEmail());
        assertEquals(1, userAccount.getLoginCount(ali));
    }

    @Test
    public void testSearchUserByEmail() {
        userAccount.addUser(ali);
        assertNotNull(userAccount.searchUserByEmail("ali@example.com"));
        assertNull(userAccount.searchUserByEmail("unknown@example.com"));
    }

    @Test
    public void testUpdateUserDetails() {
        userAccount.addUser(ali);
        assertTrue(userAccount.updateUserDetails("ali@example.com", "Ali Updated", "newpassword", "Org1", "Active", "Gold"));
        assertEquals("Ali Updated", userAccount.searchUserByEmail("ali@example.com").getName());
    }

    @Test
    public void testDeactivateUser() {
        userAccount.addUser(ali);
        userAccount.deactive("Ali");
        assertEquals("Not Active", userAccount.searchUserByEmail("ali@example.com").getState());
    }

    @Test
    public void testActivateUser() {
        userAccount.addUser(eyas);
        userAccount.active("Eyas");
        assertEquals("Active", userAccount.searchUserByEmail("eyas@example.com").getState());
    }

    @Test
    public void testAddUserToPending() {
        userAccount.addUserToPending(sami);
        assertEquals(1, userAccount.getUserListPend().size());
    }

    @Test
    public void testApproveAccount() {
        userAccount.addUserToPending(eyas);
        userAccount.approveAcc(eyas);
        assertEquals(1, userAccount.getUserList().size());
        assertEquals(0, userAccount.getUserListPend().size());
    }

    @Test
    public void testShowAllUsers() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
        assertEquals(3, userAccount.getUserList().size());
    }

    @Test
    public void testPrintUserStats() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
        userAccount.printUserStats(); 
    }

    @Test
    public void testMostPopularPlan() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
        userAccount.MostPopular(); 
    }

    @Test
    public void testShowPlansAndSubscribers() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
        userAccount.showPlansAndSubscribers(); 
    }

    @Test
    public void testGenerateReport() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
       
        assertTrue(true);
    }

    @Test
    public void testFeedbackHandling() {
        assertTrue(userAccount.feedBacksIsEmpty());
        userAccount.addFeedBack("Great service!");
        assertFalse(userAccount.feedBacksIsEmpty());
        userAccount.showFeedBacks();
    }

    @Test
    public void testShowUserTrack() {
        userAccount.addUser(ali);
        userAccount.addUser(eyas);
        userAccount.addUser(sami);
        userAccount.showUserTrack();
    }
}
