package softwareProj;

import java.util.Objects;

import ch.qos.logback.core.net.server.Client;

import java.util.ArrayList;
import java.util.List;
public class fitness_programs {

	private String title;
    private String duration;
    private String difficulty;
    private String goals;
    private String attachments;
	
    List<client> enrolledClients ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
    
    private double price;
    
	public fitness_programs(String Title,String Duration,String Difficulty,String Goals,String Attachments,double Price) {
		enrolledClients = new ArrayList<>();
		this.title=Title;
		this.duration=Duration;
		this.difficulty=Difficulty;
		this.goals=Goals;
		this.attachments=Attachments;
		this.price=Price;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Fitness Programs: Title: " + title + " , Duration: " + duration + " , Difficulty: " + difficulty + " , Goals: "
				+ goals + " , Attachments: " + attachments +  " , Price: " + price ;
	}
	
	public User searchUserByTitle(String s) {
		
		for (client u : enrolledClients ) {
			
			if (u.getU().getName()==s) {
				return u.getU();
			}
			
		}
		return null;
		
	} 
	 public static List<fitness_programs> getProgramsForUser(User user, List<fitness_programs> programList) {
	        List<fitness_programs> userPrograms = new ArrayList<>();
	        for (fitness_programs program : programList) {
	            for (client c : program.enrolledClients) {
	                if (c.getU().equals(user)) {
	                    userPrograms.add(program);
	                    break;
	                }
	            }
	        }
	        return userPrograms;
	    }
	
	
	public User searchUserByIndex(int i) {
		
		client u = enrolledClients.get(i-1);
		for (client us : enrolledClients) {
			if (us.getU().equals(u.getU())) {
				return u.getU();
			}
		}  
		return null;
	}
	
	public void show() {
		int i =1 ;
		for (client u : enrolledClients ) {
			System.out.println(i+": "+u.getU().getName());
			i++;
		}
	}
	
	public void enrollClient( User u, String r, int a) {
		client c =new client(u, r, a);
		if (!enrolledClients.contains(c)) {
            enrolledClients.add(c) ;
            
            System.out.println("Client " + u.getName() + " has been enrolled in program " + title);
        } else {
            System.out.println("Client " + u.getName() + " is already enrolled in program " + title);
        }
    }

    public void listEnrolledClients() {
        System.out.println("Clients enrolled in " + title + ":");
        for (client client : enrolledClients) {
            System.out.println(client);
        }
    }
	
	
	
	
}
