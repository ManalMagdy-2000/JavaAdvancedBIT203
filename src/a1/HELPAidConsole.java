package a1; 
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 
/*
 * Driver program for HELPAid
 */
public class HELPAidConsole {
	static Scanner input;
	static HELPAid helpaid;
	static Appeal appeal;
	static User loginUser;
	static DateTimeFormatter formatter = DateTimeFormatter.
		ofPattern("dd/MM/yyyy");
	
	/**
	 * The main method that starts the application.
	 */
	public static void main(String[] args) {
		input = new Scanner(System.in);
		helpaid = new HELPAid();	
		User admin = new OrganizationRep("Admin", "Admin123");
		helpaid.addUser(admin);
		double householdIncome = 0.0;
		List documents = null;
		boolean done = false;
        do {
            String choice = mainMenu();
            switch (choice) {
	            case "0":
	            	System.out.println("Thanks for using HELPAid :) ");
	            	done = true;
	            	break;
	            case "1":
	            	System.out.print("1.Enter User Type :");
	            	String userType = input.nextLine();
	            	signUp(userType);
	            	choice = mainMenu();
	            	break;
	            case "2":
	                login();
	                break;
	            case "3":
	                displayAllUsers();
	                break;
	            case "4":
	            	displayAllAppeals();
	            	break;
	            case "5":
	            	displayAllCtbs();
	            	break;
	            default:
	                System.out.println("Invalid choice"); 
	                break;
            }
            System.out.println();
        } while (!done);
	}
	/*------------------------------------------------------------Start Menus----------------------------------------------------*/


	/*
	 * Display the main menu, and get the user's response
	 */
	public static String mainMenu() {
		System.out.println("HELPAid System");
		System.out.println("------------------------------------");    
		System.out.println("1. Sign Up");
		System.out.println("2. Log In");
		System.out.println("3. Display all Users");
		System.out.println("4. Display all Appeals");
		System.out.println("5. Display all Contributions");
		System.out.println();       	
		System.out.println("0. Quit");
	    System.out.print("Your choice? ");
	    String choice = input.nextLine();
	    return choice;
	}
	/*
	 * Display the organization representative's menu
	 */
    public static String orgRepMenu() {
    	System.out.println("1. Register Applicant");
    	System.out.println("2. Organize Appeals");
    	System.out.println("3. Record Contributions");
    	System.out.println("4. Record Aid Disbursement");
        System.out.println();
        System.out.println("0. Log Out");
        System.out.println();
        System.out.print("Your choice: ");
        String choice = input.nextLine();
        return choice;
    }
    /*
     * Display the applicant's menu
     */
    public static String applicantMenu() {
    	System.out.println("1. View Your Disbursement");
        System.out.println();
        System.out.println("0. Log Out");
        System.out.println();
        System.out.print("Your choice: ");
        String choice = input.nextLine();
        return choice;
    }
    /*
     * display the HELPAid Admin menu
     */
    public static String adminMenu() {
    	System.out.println("1. Add Organization");
    	System.out.println("2. Add Organization Representative");
        System.out.println();
        System.out.println("0. Log Out");
        System.out.println();
        System.out.print("Your choice: ");
        String choice = input.nextLine();
        return choice;
    }
    /*------------------------------------------------------------End Menus----------------------------------------------------*/

	/**
	 * organization representative recording new applicants
	 * and uploads a document with the Aid Applicant’s 
	 * proof of household income 
	 */
	public static void registerApplicant() {
	    String fullname = getText("Full Name: ");
	    String username="";
	    usernameGen(username);
	    String password="";
	    passwordGen(password);
	    String IDno = getText("IDno: ");
   	 	String address = getText("Address: ");
   	 	System.out.print("Household Income: ");
   	 	double householdIncome = 0.0;
   	 	Applicant applicant = new Applicant(username , password,fullname, IDno,
 			address,householdIncome);
		String orgName = getText("Organization Name : ");
		Organization org = new Organization(orgName);
		org.addApplicants(applicant);
        String filename = getText("filename: ");
        String description = getText("description: ");
		Document document = new Document(filename , description);
		applicant.addDocument(document);
		System.out.println("Applicant's detail information:");
		System.out.println(applicant);
	}
    /**
     * method that creates either organization representative or applicant
     */
    public static User signUp(String userType) {
        System.out.println("Create " + userType + " ...");
        String username = getUsername();
        String password = getText("password: ");
        String fullname = getText("Full Name: ");
        String email = getText("Email: ");
        String mobileNo = getText("mobile no: ");
        User user = null;
        if (userType.equalsIgnoreCase("Applicant")) {
       	 String IDno = getText("IDno: ");
       	 String address = getText("Address: ");
       	 System.out.print("Household Income:");
       	 double householdIncome =input.nextDouble();   	 
       	 user = new Applicant(username,password, fullname,email,mobileNo,IDno,
       			address,householdIncome);
        }
        else if(userType.equalsIgnoreCase("organization representative")){
            String title= getText("title: ");
            user = new OrganizationRep(username, password, fullname, email,
                	mobileNo , title);
        }
        else {
        	System.out.println("Invalid User Type");
        }
        helpaid.addUser(user);
        System.out.println("New user created successfully!");
        return user;
    }
    /*
     * This method to get a valid username
     */
    public static String getUsername() {
    	String username = getText("Username: ");
    	while (helpaid.findUser(username) != null) {
            System.out.println("Username already exists. "
                    + "Please enter another username!\n");
            username = getText("Username: ");
    	}
    	return username;
    }
	
    /**
     * Method that initiate user login.
     * Once login, a different menu options will be 
     * displayed, depends on the type of login user.
     */
    public static void login() {
    	boolean finished = false;
    	do {   		
            String username = getText("Username: ");
            String inPassword = getText("Password: ");
            loginUser = helpaid.findUser(username);
    		if (loginUser == null) {
            	System.out.println("User name DOES NOT exist!");
            	return ;
    		}
        	if (!loginUser.getPassword().equals(inPassword)) {
                System.out.println("Invalid password!");
        		return ;
    		}
    		finished = true;
    	} while (!finished);
    	// Once login different menu will display,
    	// depending what type of User.
        System.out.println();
        if (loginUser instanceof OrganizationRep) {
        	if(loginUser.getUsername() == "Admin") {
        		adminMenu();
        	}
        	else {
            	OrganizationRep user = (OrganizationRep) loginUser;
            	orgRepMenu();
        	}
        }
        else if (loginUser instanceof Applicant) {
         	applicantMenu();
        }
    }
    /*
     * method to generate a username
     */
    public static String usernameGen(String username) {
    	String fullname = "";
    		   username = "" ;
    	username = username + fullname.charAt(0);
    	username = username + fullname.length();
    	username = username + new Random().nextInt(10);
    	return username;  	
    }

    /*
     * method to generate a password
     */
	public static String passwordGen(String len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
          +"jklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len.length(); i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	/**
	 * Display all users in the HELPAid System
	 */
	public static void displayAllUsers() {
       System.out.println();
	   if (helpaid.numOfUsers() == 0) {
	       System.out.println("No users has been registered into the system yet");
	   } 
	   else {
		   String standard = getText("standard? " +
			   "(<O>riginal or <N>ame) ").toUpperCase();
	       System.out.println("List of users:");
	       System.out.println(helpaid.sortUsers(
	    		   standard.charAt(0)=='N'? "Name": "Original"));
	   }		
	}
	/**
	 * Display all Appeals has been made
	 */
	public static void displayAllAppeals() {
       System.out.println();
		if (helpaid.numOfAppeals() != 0) {
			System.out.println("All Appeals:");
			helpaid.getAppeals().stream()
				.forEach(System.out::println);
		}
		else
			System.out.println("No appeal has been made yet.");
	}
	/**
	 * Display all contributions has been made
	 */
	public static void displayAllCtbs() {
       System.out.println();
		if (appeal.numOfCtbs() != 0) {
			System.out.println("All Contributions:");
			appeal.getCtbs().stream()
				.forEach(System.out::println);
		}
		else
			System.out.println("No contribution has been made yet.");
	}
	
    /**
     * Getting text input from user, with validation for empty string. 
     * Value of input depends on the prompt.
     */
    public static String getText(String prompt) {
        System.out.print(prompt);
        String text = input.nextLine().trim();
        while (text.equals("")) {
            System.out.println("This field cannot be blank! "
                    + "Please enter again!\n");
            System.out.print(prompt);
            text = input.nextLine().trim();
        }
        return text;
    }

}
