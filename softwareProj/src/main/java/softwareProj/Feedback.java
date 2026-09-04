package softwareProj;

public class Feedback {
	
	
    private String programTitle;
    private String clientName;
    private String clientEmail;
    private int rating; 
    private String review;

    public Feedback(String programTitle, String clientName, String clientEmail, int rating, String review) {
      
    	if (programTitle == null || programTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Program title cannot be null or empty.");   }
    	
    	
    	
        if (clientName == null || clientName.trim().isEmpty()) {
        	
        	
            throw new IllegalArgumentException("Client name cannot be null or empty.");
       
        }
        
        if (clientEmail == null || !clientEmail.contains("@")) {
        	
            throw new IllegalArgumentException("Invalid client email.");
        }
        
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
            
        }
        if (review == null || review.trim().isEmpty()) {
        	
            throw new IllegalArgumentException("Review cannot be null or empty.");  }

        this.programTitle = programTitle;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.rating = rating;
        this.review = review;
    }

    public String getProgramTitle() {
    	
        return programTitle;}

    public String getClientName() {
    	
        return clientName;
        
        
        
    }

    public String getClientEmail() {
    	
    	
    	
        return clientEmail;
        
        
        
        
    }

    public int getRating() {
    	
    	
    	
        return rating;
        
    }

    public String getReview() {
    	
   //must check again and ask my partners 
        return review;
    }

    @Override
    public String toString() {
    	
        return "Program: " + programTitle +
                "\nClient: " + clientName +
                " (" + clientEmail + ")" +
                "\nRating: " + rating + " stars" +
                "\nReview: " + review;
    } }
