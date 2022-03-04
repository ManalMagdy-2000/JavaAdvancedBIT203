package a1;
public class OrganizationRep extends User {
	/*
	  * User who wants to register for Aid
	  * subclass of User , inherits five attributes 
	  * from Superclass User
	 */
	private String title ;

	public OrganizationRep(String username, String password, String fullname, String email, String mobileNo,
			String title) {
		super(username, password, fullname, email, mobileNo);
		setTitle(title);
	}
	

	public OrganizationRep(String username, String password) {
		super(username, password);
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "OrganizationRep [getTitle()=" + getTitle() + "]";
	}
}
