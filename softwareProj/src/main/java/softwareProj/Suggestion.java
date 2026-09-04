package softwareProj;

import java.util.List;
public class Suggestion {
	 
    private String content;
    private String clientEmail;
    private String programTitle;

    public Suggestion(String content, String clientEmail) {
        this.content = content;
        this.clientEmail = clientEmail;
       
    }

    public String getContent() {
        return content;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
               "content='" + content + '\'' +
               ", clientEmail='" + clientEmail + '\'' +
               ", programTitle='" + programTitle + '\'' +
               '}';
    }
}
