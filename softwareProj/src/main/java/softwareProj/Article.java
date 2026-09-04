package softwareProj;

public class Article {
	private String Auther_type;
	private String text;
	private String email;
	private String type;
	private String State;
	
	public Article(String Auther_type,String type,String text,String email) {
		this.Auther_type=Auther_type;
		this.type=type;
		this.email=email;
		this.text=text;
		this.State="Pending";
	}
	public void setAutherType(String At) {
		this.Auther_type=At;
	}
	public void setType (String s) {
		this.type=s;
	}
	public void setEmail(String e) {
		this.email=email;
	}
	public void setText(String t) {
		this.text=t;
	}
	public void setState(String st) {
		this.State=st;
	}
	
	public String getState() {
		return this.State;
	}
	public String getAutherType() {
		return this.Auther_type;
	}
	public String getType() {
		return this.type;
	}
	public String getEmail() {
		return this.email;
	}
	public String getText() {
		return this.text;
	}
	@Override
	public String toString() {
		return "authorType :"+this.Auther_type+ " , Article type : "+this.type+" , email : "+this.email+" , Text of article : "+ this.text;
	}
	
	

}
