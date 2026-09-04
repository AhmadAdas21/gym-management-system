package softwareProj;
import java.util.ArrayList;
import java.util.List;

public class Article_manage {
    public List<Article> Article_Tip_List;
    
    public Article_manage() {
    	Article_Tip_List=new ArrayList<>();
    	
    }
	
	public boolean Article_tipIsEmpty() {
		if (Article_Tip_List.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	public void addArtTip (Article r) {
		Article_Tip_List.add(r);
		
	}

	public void showArtTipRequsts() {
		if (Article_Tip_List.isEmpty()) {
			System.out.println("No recent Article");
			return;
		}
		
	for (Article r : Article_Tip_List) {
		if (r.getState().equalsIgnoreCase("Pending")){
		System.out.println(r);
	}
	}
	
	}
	public void showArtTipApproved() {
		if (Article_Tip_List.isEmpty()) {
			System.out.println("No recent Article");
			return;
		}
		for (Article r : Article_Tip_List) {
			if (r.getState().equalsIgnoreCase("Approved")) {
				System.out.println(r);
			}
		}
		
	}
	public void showArtTipRejected() {
		if (Article_Tip_List.isEmpty()) {
			System.out.println("No recent Article");
			return;
		}
		for (Article r : Article_Tip_List) {
			if (r.getState().equalsIgnoreCase("Rejected")) {
				System.out.println(r);
			}
		}
	}
	
	public  void approveArticle(String email) {
        boolean found = false;
        for (Article article : Article_Tip_List) {
            if (article.getEmail().equals(email)) {
                article.setState("Approved");
                System.out.println("Article by " + email + " has been approved.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No article found for the provided email.");
        }
        System.out.println("The accepted Articles/Tips :");
        showArtTipApproved();
        
    }
	public void rejectArticle(String email) {
	    boolean found = false;
	    for (Article article : Article_Tip_List) {
	        if (article.getEmail().equals(email)) {
	            article.setState("Rejected");
	            System.out.println("Article by " + email + " has been rejected.");
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("No article found for the provided email.");
	    }

	    System.out.println("The rejected Articles/Tips:");
	    showArtTipRejected();
	}

	

}
