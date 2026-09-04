package softwareProj;
import java.time.LocalTime;
import java.time.LocalDate;
public class User {
    private String name;
    private String email;
    private String password;
    private String organization;
    private String state;
    private String plantype;
  //  private int LoginCount;
   
  private  int Login_times;
 private LocalDate currentTime ;
    public User(String name, String email, String password, String organization, String state,String Plan) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.organization = organization;
        this.state = state;
        this.plantype=Plan;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization() {
        return organization;
    }
    public String getPlanType() {
    	return plantype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public void setPlantypew(String type) {
    	this.plantype=type;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return email.equals(user.email);
    }
    
    public int  getLoginTime() {
    	return this.Login_times;
    }
    public LocalDate getLastDate() {
    	return this.currentTime;
    }
    public void ActionTrack() {
    	currentTime=LocalDate.now();
    	Login_times++;
    }
    
    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", organization='" + organization + '\'' +
               ", state='" + state + '\'' +
               ",Plane='"+plantype+
               '}';
    }
}