package a1;

import java.util.List;

/*
 * An abstract that represents a user in the HELPAid System. Each
 * user will have a unique username, password, fullname, Email and mobileNo . 
 */
public abstract class User implements Comparable<User>{
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String mobileNo;
	/**
	 * Constructor that takes five arguments that are used to 
	 * initialse the attributes, username, password, fullname ,
	 * email , and mobile number. 
	 * username Unique username of a user
	 * password Password of a user
	 * fullname Full Name of a user
	 * email Email of a user
	 * mobileNo Phone number of a user
	 */
	
	public User(String username, String password, String fullname,
			String email , String mobileNo) {
			setUsername(username);
			setPassword(password);
			setFullname(fullname);
			setEmail(email);
			setMobileNo(mobileNo);
		}	
		public User(String username, String password) {
		super();
		setUsername(username);
		setPassword(password);
	}
		public User(String fullname) {
		super();
		setFullname(fullname);
	}
		public User(String username, String password, String fullname) {
			super();
			setUsername(username);
			setPassword(password);
			setFullname(fullname);
		}
		/**
		 * Default constructor of a User
		 */
		public User() {
			this("not set", "not set", "not set", "not set" , "not set");
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}	
		 /*
		  *  Checking for equality of two User objects.
		  *  Two users are equal if their usernames are the same
		  */
		public boolean equals(Object obj) {
			if (obj instanceof User)
				return getUsername().equalsIgnoreCase(
					((User) obj).getUsername());
			return false;
		}

		/*
		 * Compare two users according to their full name ,
		 */
		public int compareTo(User oua) {
			return getFullname().compareTo(oua.getFullname());
		}

		@Override
		public String toString() {
			return "User [getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getFullname()="
					+ getFullname() + ", getEmail()=" + getEmail() + ", getMobileNo()=" + getMobileNo() + "]";
		}
	
		

}
