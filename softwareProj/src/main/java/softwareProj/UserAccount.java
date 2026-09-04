package softwareProj;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;

public class UserAccount {
	public List<String> suggestions;
    public List<User> UserList;
    public List<User> PendingList;
    public List<String> feedBack;

    private Map<String, Integer> loginCountMap;
    public List<User> PlanList;
    PdfGenerate pdfGenerate = new PdfGenerate("GeneratedReport.pdf");
    Scanner in=new Scanner(System.in);

    public void addsuggestion(String k) {
		suggestions.add(k);
	}
    public boolean suggestionIsEmpty() {
		if(suggestions.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
    
    public void showsuggestions() {
		if (suggestions.isEmpty()) {
			System.out.println("No Recent suggestions");
			return;
		}
		for (String f:suggestions) {
			System.out.println(f);
		}
	}
    public UserAccount() {
        UserList = new ArrayList<>();
        PendingList = new ArrayList<>();
        loginCountMap = new HashMap<>();
        feedBack=new ArrayList<>();
        suggestions=new ArrayList<>();
        
    }

    public void addUser(User user) {
        UserList.add(user);
        loginCountMap.put(user.getEmail(), 0);
    }

    public boolean systemIsReady() {
        return UserList != null;
    }

    public boolean systemIsEmpty() {
        return UserList.isEmpty();
    }

    public boolean AddDone(User user) {
        if (UserList == null) {
            throw new IllegalStateException("UserList is not initialized");
        }
        for (User existingUser : UserList) {
            if (existingUser.equals(user)) {
                return false;
            }
        }
        UserList.add(user);
        loginCountMap.put(user.getEmail(), 0);
        return true;
    }

    public List<User> getUserList() {
        return new ArrayList<>(UserList);
    }

    public List<User> getUserListPend() {
        return new ArrayList<>(PendingList);
    }

    public boolean AddISDone() {
        int tsize = UserList.size();
        return UserList.size() == tsize + 1;
    }

    public void userLogin(String email) {
        if (loginCountMap.containsKey(email)) {
            int currentCount = loginCountMap.get(email);
            loginCountMap.put(email, currentCount + 1);
        } else {
            System.out.println("User not found: " + email);
        }
    }

    public int getLoginCount(User user) {
        return loginCountMap.getOrDefault(user.getEmail(), 0);
    }

    public User searchUserByEmail(String email) {
        for (User user : getUserList()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User searchUserByEmailInPending(String email) {
        for (User user : getUserListPend()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean updateUserDetails(String email, String name, String password, String organization, String status, String plan) {
      
        User user = searchUserByEmail(email);  
        
        if (user == null) {
            System.out.println("User not found with email: " + email);
            return false;
        }

      
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setOrganization(organization);
        user.setState(status);
        user.setPlantypew(plan);

     
        int index = UserList.indexOf(user); 
        if (index != -1) {
            UserList.set(index, user);  
        }

        System.out.println("User details updated successfully for email: " + email);
        return true;
    }


    public void deactive(String name) {
        
        User userToDeactivate = null;
        for (User user : UserList) {
            if (user.getName().equalsIgnoreCase(name)) {
                userToDeactivate = user;
                break;
            }
        }
        
      
        if (userToDeactivate != null) {
        	if (userToDeactivate.getState().equalsIgnoreCase("Not Active")) {
        		System.out.println("This account is already Deactive!");
        		return;
        	}
            userToDeactivate.setState("Not Active");
            System.out.println("User " + name + " has been deactivated.");
        } else {
            System.out.println("User not found with name: " + name);
        }
    }
    public void active(String name) {
        
        User userToactivate = null;
        for (User user : UserList) {
            if (user.getName().equalsIgnoreCase(name)) {
                userToactivate = user;
                break;
            }
        }
        
      
        if (userToactivate != null ) {
        	if (userToactivate.getState().equalsIgnoreCase("Active")) {
        		System.out.println("This account is already Active!");
        		return;
        	}
            userToactivate.setState("Active");
            System.out.println("User " + name + " has been Activated.");
        } else {
            System.out.println("User not found with name: " + name);
        }
    }

    public boolean PendingListIsEmpty() {
        return PendingList.isEmpty();
    }

    public void addUserToPending(User user) {
        PendingList.add(user);
    }

    public void approveAcc(User pendingUser) {
        pendingUser.setState("Active");
        UserList.add(pendingUser);
        PendingList.remove(pendingUser);
    }

    boolean sendStatus = false;

    public void sendStaticReq() {
        sendStatus = true;
    }
    public void showAllUsers() {
        if (UserList.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (User user : UserList) {
                System.out.println(user);  
            }
        }
    }
    public void printSt() {
        if (sendStatus) {
            System.out.println("Getting Statistcs");
        } else {
            System.out.println("Fail");
        }
    }

    public void printUserStats() {
        if (!UserList.isEmpty()) {
            int totalLogins = 0;
            User mostActiveUser = null;
            int mostLogins = 0;

            for (User user : UserList) {
                totalLogins += user.getLoginTime();  

                if (user.getLoginTime() > mostLogins) {
                    mostActiveUser = user;
                    mostLogins = user.getLoginTime();
                }
            }


            double averageLogins = UserList.size() > 0 ? totalLogins / (double) UserList.size() : 0;

            System.out.println("| Total Number of Logins            | " + totalLogins + " |");
            System.out.println("| Most Active Client by Logins      | " + (mostActiveUser != null ? mostActiveUser.getName() : "N/A") + " |");
         
            System.out.println("| Average Logins Per Client         | " + String.format("%.2f", averageLogins) + " |");
        } else {
            System.out.println("No users found.");
        }
    }

    public void MostPopular() {
        if (UserList.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        Map<String, Integer> planUsageCount = new HashMap<>();

        for (User user : UserList) {
            String planType = user.getPlanType(); 
            planUsageCount.put(planType, planUsageCount.getOrDefault(planType, 0) + 1);
        }

   
        String mostPopularPlan = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : planUsageCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopularPlan = entry.getKey();
                maxCount = entry.getValue();
            }
        }

      
        System.out.println("Plan Usage Counts:");
        for (Map.Entry<String, Integer> entry : planUsageCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("The most popular plan is: " + (mostPopularPlan != null ? mostPopularPlan : "N/A") + " with " + maxCount + " users.");
    }
    public void showPlansAndSubscribers() {
       
        Map<String, Integer> planCountMap = new HashMap<>();

       
        for (User user : UserList) {
            String planType = user.getPlanType();
            planCountMap.put(planType, planCountMap.getOrDefault(planType, 0) + 1);
        }

       
        System.out.println("Plan Type | Number of Subscribers");
        System.out.println("--------------------------------");
        for (Map.Entry<String, Integer> entry : planCountMap.entrySet()) {
            System.out.printf("%-10s | %d%n", entry.getKey(), entry.getValue());
        }
    }
    public void genRep() {

        int total = UserList.size();

        int revenue = 0;
        int goldCount = 0, silverCount = 0, platinumCount = 0;
        int clientCount = 0, instructorCount = 0;

        for (User user : UserList) {

            System.out.println("User: " + user.getName() + ", State: " + user.getState() + ", Plan: " + user.getPlanType());

            switch (user.getPlanType().toLowerCase()) {
                case "gold":
                    if (user.getState().equalsIgnoreCase("active")) {
                        goldCount++;
                    }
                    break;
                case "silver":
                    if (user.getState().equalsIgnoreCase("active")) {
                        silverCount++;
                    }
                    break;
                case "platinum":
                    if (user.getState().equalsIgnoreCase("active")) {
                        platinumCount++;
                    }
                    break;
                default:
                    break;
            }

            if (user.getState().equalsIgnoreCase("Client")) {
                clientCount++;
            } else if (user.getState().equalsIgnoreCase("Instructer")) {
                instructorCount++;
             }
        }

        revenue = (goldCount * 400) + (silverCount * 200) + (platinumCount * 600);

        int instAmo = 0;
        for (User user : UserList) {

            if (user.getOrganization().equalsIgnoreCase("Client") && user.getState().equalsIgnoreCase("active")) {
                clientCount++;
            } else if (user.getOrganization().equalsIgnoreCase("Instructer") && user.getState().equalsIgnoreCase("active")) {
                instructorCount++;
            }
        }
        instAmo = instructorCount * 500;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        System.out.println("Report generated on: " + timestamp);
        System.out.println("Total number of instructors and subscribers: " + total);
        System.out.println("Number of Clients : " + clientCount);
        System.out.println("Number of Instructors : " + instructorCount);
        System.out.println("Revenue: " + revenue);
        System.out.println("Paid salary to instructors: " + instAmo);

        System.out.println("********************************************");

     
        pdfGenerate.addText("Report generated on: " + timestamp);
        pdfGenerate.addText("Total number of instructors and subscribers: " + total);
        pdfGenerate.addText("Number of Clients : " + clientCount);
        pdfGenerate.addText("Number of Instructors : " + instructorCount);
        pdfGenerate.addText("Revenue: " + revenue);
        pdfGenerate.addText("Paid salary to instructors: " + instAmo);
        pdfGenerate.generatePdf();

        System.out.println("The report has been saved successfully as a PDF!");
    }


	public boolean feedBacksIsEmpty() {
		if(feedBack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void addFeedBack(String s) {
		feedBack.add(s);
	}
	
	
	public void showFeedBacks() {
		if (feedBack.isEmpty()) { 
			System.out.println("No Recent FeedBacks !");
			return;
		}
		for (String f:feedBack) {
			System.out.println(f);
		}
	}
	
	
	public void showPendingUser() {
		
		for (User t: PendingList) {
			System.out.println(t);
		}
	}
	
	public void AccPend(String temail) {
		
		
		User temp= searchUserByEmailInPending(temail);
		temp.setState("Active");
		addUser(temp);
		 
	}
	public void showUserTrack() {
	    try {
	        if (UserList.isEmpty()) {
	            System.out.println("Sorry, The System is empty of Data");
	        } else {
	            for (User r : UserList) {
	            	
	                if (r.getState().equalsIgnoreCase("Active")) {
	                	System.out.println("******************************************");
	                    System.out.println("The user Email: " + r.getEmail());
	                    System.out.println("The user Name: " + r.getName());
	                    System.out.println("The user Type: " + r.getState());
	                    System.out.println("The Last Login Date: " + r.getLastDate());
	                    System.out.println("Login Times: " + r.getLoginTime());
	                }
	            }
	        }
	    } catch (StackOverflowError e) {
	        System.err.println("Error: StackOverflowError occurred.");
	        e.printStackTrace();
	    }
	}


	}
	




