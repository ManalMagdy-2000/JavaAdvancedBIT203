package a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * HELP Aid is an information system that has been proposed to 
 * manage the registration of aid applicants and organizations that are helping them.
 * HelpAid has a collection of User objects , Appeal objects  , and Organization objects.
 */
public class HELPAid {
	private List<User> users;
	private List<Appeal> appeals;
	private List<Organization> orgs;
	
	/*
	 * Constructor for HelpAid
	 */
	public HELPAid() {
		setUsers(new ArrayList<User>());
		setAppeals(new ArrayList<Appeal>());
		setOrgs(new ArrayList<Organization>());
	}
	public List<Appeal> getAppeals() {
		return appeals;
	}

	public void setAppeals(List<Appeal> appeals) {
		this.appeals = appeals;
	}

	public List<Organization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}

	/*
	 * Adding user to HelpAid , should be an Applicant or a organizationRep
	 */
	public void addUser(User aUser) {
		getUsers().add(aUser);
	}
	/**
	 * Finding a user based on the unique username.
	 * username username of user
	 * The user whose username matches the
	 * username, null otherwise
	 */
	public User findUser(String username) {
		for (User user: getUsers())
			if (user.getUsername().equalsIgnoreCase(username))
				return user;
		return null;
	}
	/**
	 *  Number of users in HELPAid
	 */
	public int numOfUsers() {
		return getUsers().size();
	}
	public List<User> getUsers() {
		return users;
	}
	/**
	 * users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
/*
 * Display detail of all users, either in original sequence, or sorted according to fullname;
 */
	public String sortUsers(String formula) {
		ArrayList<User> usersClone = (ArrayList<User>) getUsers();	
		ArrayList<User> cloneUsers = (ArrayList<User>) usersClone.clone();
		if (formula.equalsIgnoreCase("fullname"))
			Collections.sort(cloneUsers);
		String allUsers = "";
		for (User user: cloneUsers)
			allUsers += user + "\n";
		return allUsers;
	}
	
	 /* Adding new  Appeals.*/

	public void addAppeal(Appeal anAppeal) {
		getAppeals().add(anAppeal);
	}
	 /* Find an appeal based on the appeal ID*/ 
	
	public Appeal findAppeal(String appealID) {
		for (Appeal appeal: getAppeals())
			if (appeal.getAppealID().equalsIgnoreCase(appealID))
				return appeal;
		return null;
	}
	/**
	 *  Number of appeals in HELPAid
	 */
	public int numOfAppeals() {
		return getAppeals().size();
	}
	
	 /* Adding new  organizations */ 
	
	public void addOrganization(Organization org ) {
		getOrgs().add(org);
	}
	 /* Find an organization based on the organization ID*/ 
	
	public Organization findOrganization(String orgID) {
		for (Organization org: getOrgs())
			if (org.getOrgID().equalsIgnoreCase(orgID))
				return org;
		return null;
	}
	/**
	 *  Number of organizations in HELPAid
	 */
	public int numOfOrgs() {
		return getOrgs().size();
	}
	/*
	 * this method to view all aid Appleals, sorted according to 
	 * Organization name, followed by aid Appeals (sorted according to from date).
	 */
	public String viewAppeals() {
		String str = "";
		for (Organization org: getOrgs()) {
			if (org.numOfAppeals() != 0) {
				for (Appeal appeal: org.getAppeals())
					str += appeal + "\n";
			}
		}
		return str;
	}
	/*
	 * this method to view a list of Applicants registered with the Organization 
	 */
	public String viewApplicants() {
		String str = "";
		for (Organization org: getOrgs()) {
			if (org.numOfApplicants() != 0) {
				for (Applicant applicant: org.getApplicants())
					str += applicant + "\n";
			}
		}
		return str;
	}
	@Override
	public String toString() {
		return "HELPAid [getAppeals()=" + getAppeals() + ", getOrgs()=" + getOrgs() + ", numOfUsers()=" + numOfUsers()
				+ ", getUsers()=" + getUsers() + ", numOfAppeals()=" + numOfAppeals() + ", numOfOrgs()=" + numOfOrgs()
				+ ", viewAppeals()=" + viewAppeals() + ", viewApplicants()=" + viewApplicants() + "]";
	}
	
	
	

	
}
