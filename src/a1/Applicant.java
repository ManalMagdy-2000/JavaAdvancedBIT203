package a1;

import java.util.ArrayList;
import java.util.List;

/*
 * User who wants to register for Aid
 * subclass of User , inherits five attributes 
 * from Superclass User
 */
public class Applicant extends User {
	private String IDno;
	private String address;
	private double householdIncome;
	private List<Document> documents;
	/*
	 * Constructor that takes five arguments that are used to 
	 * initialse the attributes
	 */
	
	
	public Applicant(String username, String password, String fullname, String email, String mobileNo, String IDno,
			String address, double householdIncome) {
		super(username, password, fullname, email, mobileNo);
		setIDno(IDno);
		setAddress(address);
		setHouseholdIncome(householdIncome);
		setDocuments(new ArrayList<Document>());
	}
	public Applicant(String username, String password, String fullname,String IDno,
			String address, double householdIncome) {
		super(username, password, fullname);
		setIDno(IDno);
		setAddress(address);
		setHouseholdIncome(householdIncome);
	}


	public void addDocument(Document doc) {
		getDocuments().add(doc);
	}
	/*
	 * returns the number of documents by applicant
	 */
    public int numOfDocuments() {
    	return getDocuments().size();
    }
    /*
     * method has the details of  all documents uploaded by the appicant
     */
    public String documentDetails() {
    	if (getDocuments().size() != 0) {
    		String str = "";
    		for (Document doc: getDocuments()) {
    			str += doc + "\n";
    		}
    		return str;
    	}
    	return null;
    }
	public String getIDno() {
		return IDno;
	}
	public void setIDno(String iDno) {
		IDno = iDno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getHouseholdIncome() {
		return householdIncome;
	}
	public void setHouseholdIncome(double householdIncome) {
		this.householdIncome = householdIncome;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	@Override
	public String toString() {
		return "Applicant [numOfDocuments()=" + numOfDocuments() + ", documentDetails()=" + documentDetails()
				+ ", getIDno()=" + getIDno() + ", getAddress()=" + getAddress() + ", getHouseholdIncome()="
				+ getHouseholdIncome() + ", getDocuments()=" + getDocuments() + "]";
	}
    	

}
