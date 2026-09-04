package softwareProj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class instructor {
	
	private static final Logger LOGGER = Logger.getLogger(instructor.class.getName());
	Email_Test emailsend = new Email_Test();
	public List<fitness_programs> programList;
	public List<schedules> schedulesList;
	
	public instructor(){
		programList = new ArrayList<>();
		schedulesList = new ArrayList<>();
	}
	
	public boolean systemIsEmpty() {
		 
		return programList.isEmpty(); 
		
	} 

	public void addProgram(fitness_programs fit) {
		
		programList.add(fit);
		
	}

	 

	public fitness_programs searchByIndex(int x) {
		
		return searchByIndex(programList, x-1);
		
	}

	public boolean update(int i,String t, String dur, String dif, String g, String a, double p) {
		
		fitness_programs pro = searchByIndex(i);
		if (pro ==null) {
			System.out.println("faild");
			return false;
		}
		
		pro.setTitle(t);
		pro.setDuration(dur);
		pro.setDifficulty(dif);
		pro.setGoals(g);
		pro.setAttachments(a);
		pro.setPrice(p);
		
		int index =programList.indexOf(pro);
		if(index !=-1 ) {
			programList.set(index, pro);
		}
		
		System.out.println("update Sucseful");
		pro.toString();
		return true;
		
	}
 
	public boolean delete(int x) {
		
		
		fitness_programs pro = searchByIndex(x);
		if (pro ==null) {
			return false;
		}
		programList.remove(x-1);
		System.out.println("Delete Sucseful"); 
		return true;
	}
	
	public boolean show() {
		int i=0;
		if (!programList.isEmpty()) {
		for (fitness_programs f : programList ) {
			System.out.println((i+1) +": "+ f.getTitle());
			i++;
		}
		return true;
		}
		return false;
	}
	public boolean showSc() {
		int i=0;
		if (!schedulesList.isEmpty()) {
		for (schedules s : schedulesList) {
			System.out.println((i+1) +": "+ s.getTitle());
			i++;
		}
		return true;  
		}
		return false;
	}
	
	public fitness_programs searchBytitle(String string) {
		
		
		
		for (fitness_programs f : programList) {
			if (f.getTitle().equals(string)) {
				return f;
			}
		}
		return null;
	}
	
	public void addschedules(schedules s) {

		if (!schedulesList.isEmpty()) {
			
			for (schedules ss :schedulesList ) {
				if (ss.equals(s)) {
					return ;
				}
				
			}	
				schedulesList.add(s);
				System.out.println("Added sucses");
				s.toString();
		}
		else {
			schedulesList.add(s);
			System.out.println("Added sucses");
			s.toString();
		}
	}

	public schedules searchByIndexSchedule(int x) {
		
		return searchByIndex(schedulesList, x-1);
		
	}
	
	public boolean editdate(int i, String date) {
		
		schedules pro = searchByIndexSchedule(i);
		
		if (pro ==null) {
			System.out.println("faild");
			return false;
		}
		
		pro.setDate(date);
		
		int index =schedulesList.indexOf(pro);
		if(index !=-1 ) {
			schedulesList.set(index, pro);
		}
		
		System.out.println("update Sucseful");
		return true;
	}

	public void notifyeditDate(int i) {
		
		schedules s = searchByIndexSchedule(i);
		if ( s != null) {
		for (User u : s.enrolledClients ) {
			
			editDateEmail(s, u);
		}
		}
		else 
			 LOGGER.warning("Does not exist");
		
		
	}

	public void editDateEmail(schedules s, User u) {
		String messageHeader = "schedules "+ s.getTitle() ;
		String messageContent = "schedules "+ s.getTitle() + " change date to "+s.getDate();
		String emailToContact = u.getEmail();
		emailsend.sendEmail(messageHeader, messageContent, emailToContact);
	}

	public boolean editTime(int i, String time) {
		
		schedules pro = searchByIndexSchedule(i);
		
		if (pro ==null) {
			System.out.println("faild");
			return false;
		}
		
		pro.setTime(time);
		
		int index =schedulesList.indexOf(pro);
		if(index !=-1 ) {
			schedulesList.set(index, pro);
		}
		
		System.out.println("update Sucseful");
		return true;
		
	}

	public void notifyeditTime(int i) {
		
		schedules s = searchByIndexSchedule(i);
		if ( s != null) {
		for (User u : s.enrolledClients ) {
			
			editTimeEmail(s, u);
		}
		}
		else 
			LOGGER.warning("Does not exist");
		
	}

	public void editTimeEmail(schedules s, User u) {
		String messageHeader = "schedules "+ s.getTitle() ;
		String messageContent = "schedules "+ s.getTitle() + " change Time to "+s.getTime();
		String emailToContact = u.getEmail();
		emailsend.sendEmail(messageHeader, messageContent, emailToContact);
	}
	
	public void notifyeditProgram(int i) {
		
		fitness_programs s = searchByIndex(i);
		if ( s != null) {
		for (client u : s.enrolledClients ) {
			
			updateEmail(s, u);
		}
		}
		else 
			LOGGER.warning("Does not exist");
		
	}

	public void updateEmail(fitness_programs s, client u) {
		String messageHeader = "Program "+ s.getTitle() ;
		String messageContent = "Program  "+ s.getTitle() + " Was ubdated to "+s.toString();
		String emailToContact = u.getU().getEmail();
		emailsend.sendEmail(messageHeader, messageContent, emailToContact);
	}

	public void notifyProgram(fitness_programs pro, UserAccount u2) {
		String messageHeader = "New Program";
		String messageContent = pro.toString();
		
		sendToUser(u2, messageHeader, messageContent);
		
		
	}
	
	public void offer(int i,double p) {
		
		
			fitness_programs s = searchByIndex(i);
			
			s.setPrice(p);
			System.out.println("New price "+p);
		}
		 
		 	

	public void notifyOffer(int i, UserAccount u) {
		
		fitness_programs s = searchByIndex(i);
		String messageHeader = "New Offer";
		String messageContent = s.toString();
		sendToUser(u, messageHeader, messageContent);
		
	}

	public void notfyschedule(schedules s, UserAccount u) {
		
		String messageHeader = "New Schedule";
		String messageContent = s.toString();
		
		sendToUser(u, messageHeader, messageContent);
	}

	public void sendToUser(UserAccount u, String messageHeader, String messageContent) {
		for (User us:u.UserList ) {
		String emailToContact = us.getEmail();
		emailsend.sendEmail(messageHeader, messageContent, emailToContact);
		}
	}
	
	public void showSchedule() {
		int i=0;
		for (schedules f : schedulesList ) {
			System.out.println((i+1) +": "+ f.getTitle());
			i++;
		}
	} 
	
	public static <T> T searchByIndex(List<T> list, int i) {
        if (i >= 0 && i < list.size()) {
            return list.get(i);
        }
        return null;
    }
	
	
	
	
	
	
	
}


