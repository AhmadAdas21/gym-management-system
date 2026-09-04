package softwareProj;
import java.util.ArrayList;
import java.util.List;
public class client {
	
	
	fitness_programs c=new fitness_programs(null, null, null, null, null, 0);
	User u ;
	String r;
	int a;
	
	public client(User u, String rate, int atend) {
	
		this.u = u ;
		this.r =rate;
		this.a =atend;
		
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getR() {
		return r;
	}
 
	public void setR(String r) {
		this.r = r;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void print() {
		System.out.println("Rate"+r);
		System.out.println("Attendance"+a);
	}
	
	 public void receiveProgressReport(User u1,List<fitness_programs> programList) {
		 
	        System.out.println("Progress Report for " + u1.getName() + ":");
	        System.out.println("Completion Rate: " + r + "%");
	        System.out.println("Attendance: " + a);
	        System.out.println("Enrolled Programs:" );
	        for (fitness_programs program :  programList) {
	            for (client c : program.enrolledClients) {
	                if (c.getU().equals(u1)) {
	                    System.out.println(program);
	                    break;
	                }
	            }
	        }
	    }
	 
	 
	
}
