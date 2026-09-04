package softwareProj;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

public class MainClass {
    public static void main(String[] args) {
    	UserAccount m=new UserAccount();
    	instructor ins = new instructor();
		Article_manage t=new Article_manage();
		Scanner in =new Scanner(System.in);
		IDCardSent emailSender=new IDCardSent();
		   Email_Test emailsend = new Email_Test();
		   
		User c;
       
       
        ProgressManager progressM = new ProgressManager();
        SuggestionManager suggestionM = new SuggestionManager();
        int choice; 
        
 boolean MainINTERFace=true;
	 while (MainINTERFace) {
	    System.out.println("--------------------------------------------------------");
	    System.out.println("\n");
        System.out.println("Welcome to E-M Gaza Fitness Gym System!");
        System.out.println("Please Choose Organization:");
        System.out.println("1. Admin");
        System.out.println("2. Instructors");
        System.out.println("3. Client");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = in.nextInt();
        in.nextLine(); 
 

        if (choice == 1) { // Admin 
            System.out.print("Username: ");
            String username = in.nextLine();
            System.out.print("Password: ");
            String password = in.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Welcome Admin, Have a wonderful day!");

                boolean adminRunning = true;
                while (adminRunning) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Choose an operation please:");
                    System.out.println("1. Show All Clients");
                    System.out.println("2. Add a Client");
                    System.out.println("3. Update Info");
                    System.out.println("4. Deactivate a Client");
                    System.out.println("5. See New Sign-Up Requests");
                    System.out.println("6. Show Statistics");
                    System.out.println("7. See Programs (Plans) Info");
                    System.out.println("8. Contact a User (by Email)");
                    System.out.println("9. See Feedbacks");
                    System.out.println("10. See Article Requests");
                    System.out.println("11. activate a Client");
                    System.out.println("12. Show Users Activety ");
                    System.out.println("13. Exit");
                    System.out.print("Enter your choice: ");
                    int adminChoice = in.nextInt();
                    in.nextLine();

                    switch (adminChoice) {
                        case 1:
                            m.showAllUsers();
                            break;
                        case 2:
                            System.out.print("Enter Name: ");
                            String name = in.nextLine();
                            System.out.print("Enter Email: ");
                            String email = in.nextLine();
                            System.out.print("Enter Password: ");
                            String passwordClient = in.nextLine();
                            System.out.print("Enter Organization: ");
                            String organization = in.nextLine();
                            System.out.print("Enter Client State: ");
                            String state = in.nextLine();
                            System.out.print("Enter Plan Type (if it is an Instructor, enter 'nan'): ");
                            String planType = in.nextLine();

                            User newUser = new User(name, email, passwordClient, organization, state, planType);
                              m.addUser(newUser);

                            System.out.print("Do you want to send a welcome email? (yes/no): ");
                            String sendEmail = in.nextLine();
                            if (sendEmail.equalsIgnoreCase("yes")) {
                                emailSender.generateAndSendCard(name, email);
                            }

                            System.out.println("Client has been successfully added.");
                            break;
                        case 3:
                            System.out.println("Available Users:");
                            m.showAllUsers();
                            System.out.print("Enter Email to Update: ");
                            String updateEmail = in.nextLine();
                            System.out.print("Enter New Name: ");
                            String newName = in.nextLine();
                            System.out.print("Enter New Password: ");
                            String newPassword = in.nextLine();
                            System.out.print("Enter New Organization: ");
                            String newOrganization = in.nextLine();
                            System.out.print("Enter New State: ");
                            String newState = in.nextLine();
                            System.out.print("Enter New Plan Type: ");
                            String newPlanType = in.nextLine();

                            m.updateUserDetails(updateEmail, newName, newPassword, newOrganization, newState, newPlanType);
                            break;
                        case 4:
                        	m.showAllUsers();
                            System.out.print("Enter Name to Deactivate: ");
                            String deactivateName = in.nextLine();
                            m.deactive(deactivateName);
                            break;
                        case 5:
                        	m.showPendingUser();
                        	System.out.print("Enter the email of the user the you want to active:");
                        	String wemail=in.nextLine();
                        	System.out.print("Enter the name of the user :");
                        	String knname=in.nextLine();
                            m.AccPend(wemail);
                            System.out.print("Do you want to send a welcome email? (yes/no): ");
                            String sendEmail2 = in.nextLine();
                            if (sendEmail2.equalsIgnoreCase("yes")) {
                                emailSender.generateAndSendCard(knname, wemail);
                            }

                            System.out.println("Client has been successfully added.");
                            break;
                        case 6:
                            m.printUserStats();
                            break;
                        case 7:
                            m.genRep();
                            break;
                        case 8:
                            System.out.print("Enter User Email: ");
                            String emailToContact = in.nextLine();
                            System.out.print("Enter Message Header: ");
                            String messageHeader = in.nextLine();
                            System.out.print("Enter Message: ");
                            String messageContent = in.nextLine();

                            emailsend.sendEmail(messageHeader, messageContent, emailToContact);
                            break;
                        case 9:
                            m.showFeedBacks();
                            break;
                        case 10:
                            t.showArtTipRequsts();
                            boolean hasPendingArticles = t.Article_Tip_List.stream()
                                    .anyMatch(article -> article.getState().equalsIgnoreCase("Pending"));

                            if (!hasPendingArticles) {
                                System.out.println("No articles with 'Pending' state found.");
                                continue;
                            }
                            System.out.print("Enter Email of the Author: ");
                            String authorEmail = in.nextLine();
                            System.out.print("Approve or Reject Article (A/R): ");
                            String decision = in.nextLine();

                            if (decision.equalsIgnoreCase("A")) {
                                t.approveArticle(authorEmail);
                            } else {
                               t.rejectArticle(authorEmail);
                            }
                            break;
                        case 11:
                        	m.showAllUsers();
                            System.out.print("Enter Name to activate: ");
                            String activateName = in.nextLine();
                            m.active(activateName);
                            break;
                        case 12:
                        	m.showUserTrack();
                        	break;
                        case 13:
                            System.out.println("Exiting Admin Menu. Goodbye!");
                            adminRunning = false;
                            
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid credentials for Admin.");
            }
        }
        else if (choice == 2) {
        	
        	System.out.println("Login to your account.");
            System.out.print("Enter Email: ");
            String email = in.nextLine();
            System.out.print("Enter Password: ");
            String password = in.nextLine();

            User loggedInUser = m.searchUserByEmail(email);
            if (loggedInUser == null || !loggedInUser.getPassword().equals(password)) {
                System.out.println("Invalid login information.");
                continue;
            } else if (loggedInUser.getState().equalsIgnoreCase("Active") && 
                       loggedInUser.getOrganization().equalsIgnoreCase("Instructor")) {
                System.out.println("Login successful.");
               
            } else {
                System.out.println("Access denied. User is either inactive or not an Instructor.");
                continue;
            }
        	
            
            	
                    System.out.println("--------------------------------------------------------");
                    System.out.println("Welcome Instructor, Have a wonderful day!");

                    boolean fInstructor = true;
                    while (fInstructor) {
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Choose an operation please:");
                        System.out.println("1. Create new Program");
                        System.out.println("2. Edit Program");
                        System.out.println("3. Delete Program");
                        System.out.println("4. Create schedule");
                        System.out.println("5. Edit Date");
                        System.out.println("6. Edit Time");
                        System.out.println("7. Send message");
                        System.out.println("8. Show report");
                        System.out.println("9. Make Offer");
                        System.out.println("10. update Rate");
                        System.out.println("11. update Attendance");
                        System.out.println("12. Exit");
                        System.out.print("Enter your choice: ");
                        int adminChoice = in.nextInt();
                        in.nextLine();

                        switch (adminChoice) {
                        case 1:	
                        	System.out.print("Enter Title: ");
                        	String title = in.nextLine();
                        	System.out.print("Enter Duration: ");
                        	String duration = in.nextLine();
                        	System.out.print("Enter Difficulty: ");
                        	String difficulty = in.nextLine();
                        	System.out.print("Enter Goals: ");
                        	String goals = in.nextLine();
                        	System.out.print("Enter Attachments: ");
                        	String attachments = in.nextLine();
                        	System.out.print("Enter Price: ");
                        	String sprice = in.nextLine();
                        	double price =Double.parseDouble(sprice);
                        	fitness_programs f = new fitness_programs(title,duration,difficulty,goals,attachments,price);
                        	ins.addProgram(f);
                        	ins.notifyProgram(f, m);
                    		System.out.println(f.toString());
                        	break ;
                        case 2:                            	
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int index = Integer.parseInt(in.nextLine());
                        	System.out.print("Enter Title: ");
                        	String t1 = in.nextLine();
                        	System.out.print("Enter Duration: ");
                        	String d = in.nextLine();
                        	System.out.print("Enter Difficulty: ");
                        	String difficulty1 = in.nextLine();
                        	System.out.print("Enter Goals: ");
                        	String goals1 = in.nextLine();
                        	System.out.print("Enter Attachments: ");
                        	String attachments1 = in.nextLine();
                        	System.out.print("Enter Price: ");
                        	String sprice1 = in.nextLine();
                        	double price1 =Double.parseDouble(sprice1);
                        	if(ins.update(index, t1, d, difficulty1, goals1, attachments1, price1))
                        	ins.notifyeditProgram(index);
                        	}
                        	else
                        		System.out.println("There is no program yet");
                        	break;
                        case 3:	
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int index1 = Integer.parseInt(in.nextLine());
                        	ins.delete(index1); 
                        	}
                        	else
                        		System.out.println("There is no program yet");
                        	break;
                        case 4:
                        	System.out.print("Enter Title: ");
                        	String t2 = in.nextLine();
                        	System.out.print("Enter State: ");
                        	String state = in.nextLine();
                        	System.out.print("Enter Date: ");
                        	String date= in.nextLine();
                        	System.out.print("Enter Time: ");
                        	String time = in.nextLine();
                        	schedules s = new schedules(t2, state, date, time);
                        	ins.addschedules(s);
                        	ins.notfyschedule(s, m);
                        	break;
                        case 5:	
                        	if(ins.showSc()) {
                        	System.out.print("Enter number of Schedule: ");
                        	int index11 = Integer.parseInt(in.nextLine());
                        	System.out.print("Enter new Date: ");
                        	String nd = in.nextLine();
                        	ins.editdate(index11, nd);
                        	ins.notifyeditDate(index11);
                        	}
                        	else 
                        		System.out.println("There is no Schedule yet");
                        	break;
                        case 6:
                        	if(ins.showSc()) {
                        	System.out.print("Enter number of Schedule: ");
                        	int index3 = Integer.parseInt(in.nextLine());
                        	System.out.print("Enter new Time: ");
                        	String nt = in.nextLine();
                        	ins.editTime(index3, nt);
                        	ins.notifyeditTime(index3);
                        	}
                        	else 
                        		System.out.println("There is no Schedule yet");
                        	break;
                        case 7:
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int ind = Integer.parseInt(in.nextLine());
                        	if(!ins.searchByIndex(ind).enrolledClients.isEmpty()) {
                        	ins.searchByIndex(ind).show();
                        	System.out.print("Enter number of User: ");
                        	int ind2 = Integer.parseInt(in.nextLine());
                        	ins.searchByIndex(ind).searchUserByIndex(ind2);
                        	System.out.print("Enter message Header : ");
                        	String messageHeader =   in.nextLine();
                        	System.out.print("Enter message Content : ");
                    		String messageContent = in.nextLine();
                    		String emailToContact = ins.searchByIndex(ind).searchUserByIndex(ind2).getEmail();
                    		emailsend.sendEmail(messageHeader, messageContent, emailToContact);
                        	}
                        	else
                        		System.out.println("There is no Client enrolled yet");
                        	}
                        	else 
                        		System.out.println("There is no Program yet");
                        	break;
                        case 8: 
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int i = Integer.parseInt(in.nextLine());
                        	
                        	if(!ins.searchByIndex(i).enrolledClients.isEmpty()) {
                        	ins.searchByIndex(i).show();
                        	System.out.print("Enter number of User: ");
                        	int i2 = Integer.parseInt(in.nextLine());
                        	ins.searchByIndex(i).enrolledClients.get(i2-1).receiveProgressReport(ins.searchByIndex(i).searchUserByIndex(i2),ins.programList);
                        	
                        	} 
                        	else
                        		System.out.println("There is no Client enrolled yet");
                        	}
                        	else 
                        		System.out.println("There is no Program yet");
                        	break ;
                        case 9 : 
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int inde = Integer.parseInt(in.nextLine());
                        	
                        	System.out.print("original Price "+ins.searchByIndex(inde).getPrice()+" Enter New price ");
                        	int p = Integer.parseInt(in.nextLine());
                        	ins.offer(inde,p);
                        	if(!ins.searchByIndex(inde).enrolledClients.isEmpty()) {
                        	ins.notifyOffer(inde, m);
                        	}	
                        	}	
                        	else 
                        		System.out.println("There is no Program yet");
                        	break ;
                        case 10 :	
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int ind1 = Integer.parseInt(in.nextLine());
                        	if(!ins.searchByIndex(ind1).enrolledClients.isEmpty()) {
                        	ins.searchByIndex(ind1).show();
                        	System.out.print("Enter number of User: ");
                        	int ind3 = Integer.parseInt(in.nextLine());
                        	System.out.print("Enter Rate: ");
                        	String ss = in.nextLine();
                        	ins.searchByIndex(ind1).enrolledClients.get(ind3-1).r=ss;
                        	}
                        	else
                        		System.out.println("There is no Client enrolled yet");
                        	}
                        	else 
                        		System.out.println("There is no Program yet");
                        	break;
                        case 11 :
                        	if(ins.show()) {
                        	System.out.print("Enter number of program: ");
                        	int ind11 = Integer.parseInt(in.nextLine());
                        	if(!ins.searchByIndex(ind11).enrolledClients.isEmpty()) {
                        	ins.searchByIndex(ind11).show();
                        	System.out.print("Enter number of User: ");
                        	int ind33 = Integer.parseInt(in.nextLine());
                        	System.out.print("Enter Rate: ");
                        	int sss = Integer.parseInt(in.nextLine());
                        	ins.searchByIndex(ind11).enrolledClients.get(ind33-1).a=sss;
                        	}
                        	else
                        		System.out.println("There is no Client enrolled yet");
                        	}
                        	else 
                        		System.out.println("There is no Program yet");
                        	break;
                        case 12 :
                        	fInstructor = false;
                        	break;
                            	
                            	
                        }
                    }
           
        }
        else if (choice == 3) { 
            System.out.print("Do you have a Client Account? (yes/no): ");
            String isRegistered = in.nextLine();
            String name=null;
            String goal=null;
            if (isRegistered.equalsIgnoreCase("no")) {
                System.out.print("Enter Name: ");
                 name = in.nextLine();
                System.out.print("Enter Email: ");
                String email = in.nextLine();
                System.out.print("Enter Password: ");
                String password = in.nextLine();
                System.out.print("Enter Fitness Plan : ");
                 goal = in.nextLine();
                  
                User newUser = new User(name, email, password, "Client", "Pending", goal);
              
                User x=m.searchUserByEmail(email);
                if (x==null) {
                	  m.addUserToPending(newUser);
                  	
                	  System.out.println("Your account has been created and sent for approval. Please check back later.");
                      continue;  	
                }
                else {
                	System.out.println("Sorry,This email is already Used!");
                	  continue; 
                }
              
            }

            System.out.println("Login to your account.");
            System.out.print("Enter Email: ");
            String email = in.nextLine();
            System.out.print("Enter Password: ");
            String password = in.nextLine();

            User loggedInUser = m.searchUserByEmail(email);
            
             if (email.equals("admin") && password.equals("admin")) {
          	  System.out.println("Login successful.");
             }
          
             else if (loggedInUser == null || !loggedInUser.getPassword().equals(password)) {
                System.out.println("Invalid login information.");
                continue;
                
             }
          
            else if (loggedInUser.getState().equalsIgnoreCase("Active") && 
                       loggedInUser.getOrganization().equalsIgnoreCase("Client")) {
                System.out.println("Login successful.");
               
            } else {
                System.out.println("Access denied. User is either inactive or not a client.");
                continue;
            }


            System.out.println("Welcome, " + loggedInUser.getName() + "!");
           boolean clientRunning = true;
           loggedInUser.ActionTrack();
            while (clientRunning) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Client Menu:");
                System.out.println("1. Browse Programs");
                System.out.println("2. Enroll in a Program");
                System.out.println("3. Track Your Progress");
                System.out.println("4. Submit Feedback for a Program");
                System.out.println("5. Submit a Suggestion to an Instructor");
                System.out.println("6. Add an Article");
                System.out.println("7. Show Articles");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int clientChoice = in.nextInt();
                in.nextLine();

                switch (clientChoice) {
                
                
                    case 1:
                    	
                    	ins.show();                    	
                    	
                    	
                    	
                    	
                    	
                      
                      break;
                    case 2:
                    	int choises;
                    	System.out.println("Want to enroll in fitness program or schedules?");
                    	System.out.println("1 - Fitness programs ");
                    	System.out.println("2 - Schedules ");
                    	choises = in.nextInt();

                    	if(choises == 1) { 

                    	    System.out.println("Enter the title of the program you want to enroll in:");
                    	    ins.show();  
                    	    in.nextLine(); 
                    	    String programTitle = in.nextLine().trim();  

                    	   
                    	    
                    	    fitness_programs selectedProgram = ins.searchBytitle(programTitle);

                    	    if (selectedProgram != null) {
                    	      

                    	        boolean alreadyEnrolled = false;
                    	        for (client enrolledClient : selectedProgram.enrolledClients) {
                    	            if (enrolledClient.getU().getName().equalsIgnoreCase(name)) {
                    	                alreadyEnrolled = true;
                    	                break;
                    	            }
                    	        } 

                    	        if (!alreadyEnrolled) {
                    	       
                    	        
                    	            client newClient = new client(  m.searchUserByEmail(email), null, 0);

                    	            selectedProgram.enrolledClients.add(newClient);
                    	          


                    	            System.out.println("You have been successfully enrolled in " + selectedProgram.getTitle());
                    	           
                    	        } else {
                    	            System.out.println(name + " is already enrolled in " + selectedProgram.getTitle());
                    	        }
                    	    } else {
                    	        System.out.println("Program not found.");
                    	    }

                    	} else if(choises == 2) {
                    		
                    	
                    	
                    	 
                    	System.out.println("choose the schedule that stasifies you ");
                    ins.showSc();
                    	int cho=in.nextInt(); 
                    	ins.searchByIndexSchedule(cho).enrollClient( m.searchUserByEmail(email));
                    		 
                    	       
                    	} else {
                    	    System.out.println("Invalid choice. Please enter 1 or 2.");
                    	}
                    	
                        break;
                    case 3:
                    	
                    	   System.out.println("Your Progress:");
                    	   
                      //   for (Progress progress : progressM.getAllProgress()) {
                      //        System.out.println("Program: " + progress.getProgramTitle());
                      //      System.out.println("Completed Sessions: " + progress.getAttendedSessions() + "/" + progress.getTotalSessions());
                        //      System.out.println("Progress Bar: " + progress.getProgressBar());
                           //   System.out.println("--------------------------------");     } 
                         
                        	 client  newClient= new client( m.searchUserByEmail(email),null,0);
                    	   newClient.receiveProgressReport(  m.searchUserByEmail(email),ins.programList);
                        break;
                    case 4:
                      System.out.print("Enter A FeedBack to the Admin :");
                      String feedBack=in.nextLine();
                      String feedBackTotal=("Writter Email :"+ email+" "+feedBack);
                      m.addFeedBack(feedBackTotal);
                        break;
                    case 5:
                    	   System.out.println("Enter your suggestion for improvement:");
                           String suggestionContent = in.nextLine();

                            

                           Suggestion sugg = new Suggestion(suggestionContent, loggedInUser.getEmail());

                          
                         
                           
                           
                           suggestionM.addSuggestion(sugg);

                           System.out.println("Thank you for your suggestion. It has been forwarded to the instructor.");
                           break;
                     
                       
                      
                    case 6:
                       
                        String authType="Client";
                        String st="Pending";
                        System.out.print("Enter the article Type :");
                        String artc=in.nextLine();
                        System.out.print("Enter the article Text :");
                        String artctext=in.nextLine();
                        
                        
                        Article arti=new Article (authType,artc,artctext,email);
                        t.addArtTip(arti);
                        System.out.println("Your Article is now sent to admin, Keep checking articles to see if its approved or not");
                        break;
                    case 7:
                    	   System.out.println("if nothing shown, then there is no recent articles");
                      t.showArtTipApproved();
                        break;
                    case 8:
                    	
                        System.out.println("Exiting Client Menu. Goodbye!");
                        
                        clientRunning = false;
                        break;
                    default:
                    	
                        System.out.println("Invalid choice. Please try again.");
                } 
        }
        }
 
        
        else if (choice==4){
        	
            System.out.println("System is closed, GoodBye");
        	return;
        }
        else {
        	System.out.println("Invalid Choice!");
       
       
    }
	 
    
		 
	 }
    
	 in.close();
	  }

    
    }
    
*/