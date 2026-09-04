package softwareProj;
/*
import java.util.Scanner;

public class MainClassClient {
	
    public static void main(String[] args) {
    	
    	
        UserAccount cl = new UserAccount();
        FeedbackManager feedbackM = new FeedbackManager();
        
        ProgressManager progressM = new ProgressManager();
        
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to E-M Gaza Fitness Gym System!");
        
        System.out.println("Do you have a Client Account? (yes/no):");
        
        String isRegistered = in.nextLine();

        if (isRegistered.equalsIgnoreCase("no")) {
        	
        	
            System.out.println("Let’s create your account!");
            System.out.print("Enter your Name: ");
            String name = in.nextLine();
            System.out.print("Enter your Email: ");
            String email = in.nextLine();
            System.out.print("Enter your Password: ");
            String password = in.nextLine();
            System.out.print("Enter your Fitness Goal: ");
            String goal = in.nextLine();

            User newUser = new User(name, email, password, "Client", "Pending", goal);
            cl.addUserToPending(newUser);

            System.out.println("Your account has been created and sent for approval. Please check back later!");
            return;
        }

        System.out.println("Login to your account.");
        System.out.print("Enter  Email: ");
        String email = in.nextLine();
        System.out.print("Enter Password: ");
        String password = in.nextLine();

        User loggedIn = cl.searchUserByEmail(email);
        if (loggedIn == null || !loggedIn.getPassword().equals(password)) {
           System.out.println("Invalid login .");
            return;
        }

        System.out.println("Welcome, " + loggedIn.getName() + "!");
        boolean control = true;

        while (control) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Please choose an option:");
            System.out.println("1. Browse Programs");
            System.out.println("2. Enroll in a Program");
            //
            System.out.println("3. Track Your Progress");
            System.out.println("4. Submit a Feedback for program  ");
            System.out.println("5. Submit a Suggestion to an Instructor");
            System.out.println("6. Exit");
            
 
            System.out.print("Enter your choice: ");
            
            int choice = in.nextInt();
            in.nextLine(); 

            switch (choice) {
             case 1: //1
                    System.out.println("Available Programs:");
                  
                
                     break;

                case 2: //2
                    System.out.println("Enter the title of the program you want to enroll in:");
                  
                    String programTitle = in.nextLine();
                    
                    Program selectedProgram = progressM.getProgramByTitle(programTitle);
                    if (selectedProgram != null) {
                    	
                    	
                    Progress newProgress = new Progress(selectedProgram.getTitle(), 10, 5.0); 
                    progressM.addProgress(newProgress);
                    System.out.println("You have been successfully enrolled in " + selectedProgram.getTitle());
                    } else {
                        System.out.println("Program not found.");
                    }
                    break;

                case 3: 
                    System.out.println("Your Progress:");
                    for (Progress progress : progressM.getAllProgress()) {
                        System.out.println("Program: " + progress.getProgramTitle());
                      System.out.println("Completed Sessions: " + progress.getAttendedSessions() + "/" + progress.getTotalSessions());
                        System.out.println("Progress Bar: " + progress.getProgressBar());
                        System.out.println("--------------------------------");     }
                         break;

                case 4: 
                    System.out.println("Enter the title of the program you want to make feedback for:");
                    String feedbackProgramTitle = in.nextLine();
                    System.out.print("Enter your rating 1-5 : ");
                    int rating = in.nextInt();
                    in.nextLine(); 
                    System.out.print("Enter your review: ");
                    String review = in.nextLine();

                    Feedback feedback = new Feedback(feedbackProgramTitle, loggedIn.getName(), loggedIn.getEmail(), rating, review);
                    feedbackM.addFeedback(feedback);
                    System.out.println("Thank you for your feedback!");
                    break;

                case 5:
                    System.out.println("Enter your suggestion for improvement:");
                    String suggestionContent = in.nextLine();

                    System.out.println("Enter the program title related to this suggestion:");
                    String Programtitle = in.nextLine();

                    Suggestion sugg = new Suggestion(suggestionContent, loggedIn.getEmail(), Programtitle);

                   
                    SuggestionManager suggestionM = new SuggestionManager();
                    
                    
                    suggestionM.addSuggestion(sugg);

                    System.out.println("Thank you for your suggestion. It has been forwarded to the instructor.");
                    break;


                case 6: 
                    control = false;
                    
                    
                    System.out.println("Thank you for using E-M Gaza Fitness Gym System!");
                    break;

                default:
                    System.out.println("Invalid choice. try again.");
                    break;
            }
        } in.close();
    }}
*/