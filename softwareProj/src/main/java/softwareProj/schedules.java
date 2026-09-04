package softwareProj;


import java.util.ArrayList;

import java.util.List;

public class schedules {

	@Override
	public String toString() {
		return "schedules: Title: " + title + " , State: " + state + " , Date: " + date + " , Time: " + time ;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<User> getEnrolledClients() {
		return enrolledClients;
	}

	public void setEnrolledClients(List<User> enrolledClients) {
		this.enrolledClients = enrolledClients;
	}

	private String title;
	private String state;
	private String date;
	private String time;
	List<User> enrolledClients  ;
	public schedules(String string, String string2, String string3, String string4) {
		enrolledClients = new ArrayList<>();
		this.title = string;
		this.state = string2; 
		this.date = string3;
		this.time= string4;
	}
	
	public void enrollClient( User u) {
		User c = u;
		if (!enrolledClients.contains(c)) {
            enrolledClients.add(c);
            
            System.out.println("Client " + u.getName() + " has been enrolled in program " + title);
        } else {
            System.out.println("Client " + u.getName() + " is already enrolled in program " + title);
        }
    }
	
}
