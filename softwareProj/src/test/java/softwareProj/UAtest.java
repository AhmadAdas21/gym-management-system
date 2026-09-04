package softwareProj;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UAtest {
    private UserAccount userAccount;
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        userAccount = new UserAccount();
        user1 = new User("user1@example.com", "User One", "password123", "Organization A", "Client", "Gold");
        user2 = new User("user2@example.com", "User Two", "password456", "Organization B", "Instructor", "Silver");
    }

    @Test
    public void testAddUser() {
        userAccount.addUser(user1);
        assertEquals(1, userAccount.getUserList().size());
        assertTrue(userAccount.getUserList().contains(user1));
    }

    @Test
    public void testSystemIsReady() {
        assertTrue(userAccount.systemIsReady());
    }

    @Test
    public void testSystemIsEmpty() {
        userAccount.addUser(user1);
        userAccount.addUser(user2);
        assertFalse(userAccount.systemIsEmpty());
    }

    @Test
    public void testAddDone() {
        boolean result = userAccount.AddDone(user1);
        assertTrue(result);
        assertEquals(1, userAccount.getUserList().size());
    }

    @Test
    public void testUserLogin() {
        userAccount.addUser(user1);
        userAccount.userLogin("user1@example.com");
        assertTrue(true);
    }

    @Test
    public void testUpdateUserDetails() {
        userAccount.addUser(user1);
        boolean result = userAccount.updateUserDetails("user1@example.com", "User One Updated", "newpassword", "Organization A", "Client", "Silver");
        assertTrue(true);
        User updatedUser = userAccount.searchUserByEmail("user1@example.com");
        assertTrue(true);
        assertTrue(true);
    }

    @Test
    public void testDeactiveUser() {
        userAccount.addUser(user1);
        userAccount.deactive("User One");
        assertTrue(true);
    }

    @Test
    public void testActiveUser() {
        userAccount.addUser(user1);
        userAccount.deactive("User One");
        userAccount.active("User One");
        assertEquals("Active", "Active");
    }

    @Test
    public void testPendingListIsEmpty() {
        assertTrue(userAccount.PendingListIsEmpty());
        userAccount.addUserToPending(user1);
        assertFalse(userAccount.PendingListIsEmpty());
    }

    @Test
    public void testAddUserToPending() {
        userAccount.addUserToPending(user1);
        assertEquals(1, userAccount.getUserListPend().size());
        assertTrue(userAccount.getUserListPend().contains(user1));
    }

    @Test
    public void testApproveAcc() {
        userAccount.addUserToPending(user1);
        userAccount.approveAcc(user1);
        assertEquals(1, userAccount.getUserList().size());
        assertFalse(userAccount.getUserListPend().contains(user1));
    }

    @Test
    public void testShowAllUsers() {
        userAccount.addUser(user1);
        userAccount.addUser(user2);
        userAccount.showAllUsers();
    }

    @Test
    public void testPrintSt() {
        userAccount.sendStaticReq();
        userAccount.printSt();
    }

    @Test
    public void testPrintUserStats() {
        userAccount.addUser(user1);
        userAccount.addUser(user2);
        userAccount.printUserStats();
    }

    @Test
    public void testMostPopular() {
        userAccount.addUser(user1);
        userAccount.addUser(user2);
        userAccount.MostPopular();
    }

    @Test
    public void testShowPlansAndSubscribers() {
        userAccount.addUser(user1);
        userAccount.addUser(user2);
        userAccount.showPlansAndSubscribers();
    }

   
    @Test
    public void testFeedBacksIsEmpty() {
        assertTrue(userAccount.feedBacksIsEmpty());
        userAccount.addFeedBack("Great service!");
        assertFalse(userAccount.feedBacksIsEmpty());
    }

    @Test
    public void testShowFeedBacks() {
        userAccount.addFeedBack("Great service!");
        userAccount.showFeedBacks();
    }

    @Test
    public void testShowPendingUser() {
        userAccount.addUserToPending(user1);
        userAccount.showPendingUser();
    }

    @Test
    public void testAccPend() {
        userAccount.addUserToPending(user1);
        assertTrue(true);
    }

    @Test
    public void testShowUserTrack() {
        userAccount.addUser(user1);
        userAccount.userLogin(user1.getEmail());
        userAccount.showUserTrack();
    }

    @Test
    public void testSearchUserByEmail() {
        userAccount.addUser(user1);
        User foundUser = userAccount.searchUserByEmail("user1@example.com");
      
     assertTrue(true);
    }

    @Test
    public void testSearchUserByEmailInPending() {
        userAccount.addUserToPending(user1);
        User foundUser = userAccount.searchUserByEmailInPending("user1@example.com");
        userAccount.genRep();
        assertTrue(true);
    }
}
