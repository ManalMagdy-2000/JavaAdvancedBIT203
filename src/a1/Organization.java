package a1;

import java.util.ArrayList;
import java.util.List;
/*
 * This class has a collection of OrganizationRep , Applicant and Appeal objects
 */
public class Organization {
	private List<OrganizationRep> organizationReps;
	private List<Appeal>appeals ;
	private List<Applicant>applicants ;
	private String orgID;
	private static int orgIdGen = 1;
	private String orgName ;
	private String address;
	public Organization(List<OrganizationRep> organizationReps, List<Appeal> appeals 
			,  List<Applicant> applicants, String orgID, String orgName,String address) {
		super();
		setOrganizationReps(new ArrayList<OrganizationRep>());
		setAppeals(new ArrayList<Appeal>());
		setApplicants(new ArrayList<Applicant>());
		setOrgID(orgID);
		setOrgName(orgName);
		setAddress(address);
	}
	
	public Organization(String orgName) {
		super();
		setOrgName(orgName);
	}

	public List<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}



	public List<OrganizationRep> getOrganizationReps() {
		return organizationReps;
	}


	public void setOrganizationReps(List<OrganizationRep> organizationReps) {
		this.organizationReps = organizationReps;
	}


	public List<Appeal> getAppeals() {
		return appeals;
	}


	public void setAppeals(List<Appeal> appeals) {
		this.appeals = appeals;
	}


	public String getOrgID() {
		return orgID;
	}


	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}


	public static int getOrgIdGen() {
		return orgIdGen;
	}


	public static void setOrgIdGen(int orgIdGen) {
		Organization.orgIdGen = orgIdGen;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!(obj instanceof Organization))
			return false;
		Organization rhs = ( Organization) obj;
    
		//Two orgs are equal only if they have the same name and orgID
		if ((this.orgName.equals(rhs.orgName)) && 
            this.orgID.equals(rhs.orgID))
		{
			return true;
		} else
			return false;
	}

	public int compareTo(Organization obj){
		if(this == obj)
			return 0;
		return (orgName.toLowerCase().compareTo(obj.orgName.toLowerCase()));
	}
	/*
	 * this method to add organization representative .
	 */
	public boolean addOrganizationRep(OrganizationRep orgRep) {
		getOrganizationReps().add(orgRep);
		return true;
	}
	/*
	 * this method to add applicants .
	 */
	public boolean addApplicants(Applicant applicants) {
		getApplicants().add(applicants);
		return true;
	}
	/*
	 * this method to let the Organization Representative
	 *  records the outcome of the Appeal
	 */
	public boolean addAppeals(Appeal appeals) {
		getAppeals().add(appeals);
		return true;
	}
	/*
	 * this method to search for appeals based on appeal ID
	 */
	public Appeal findAppeal(String appealID) {
		for (Appeal appeal: getAppeals())
			if (appeal.getAppealID().equalsIgnoreCase(appealID))
				return appeal;
		return null;
	}
	/*
	 * this method to search for applicants based on IDno
	 */
	public Applicant findApplicant(String IDno) {
		for (Applicant applicant: getApplicants())
			if (applicant.getIDno().equalsIgnoreCase(IDno))
				return applicant;
		return null;
	}
	/*
	 * this method to search for organization representative  based on username
	 */
	public OrganizationRep findOrganizationRep(String username) {
		for (OrganizationRep orgRep: getOrganizationReps())
			if (orgRep.getUsername().equalsIgnoreCase(username))
				return orgRep;
		return null;
	}
	public int numOfAppeals() {
		return getAppeals().size();
	}
	public int numOfApplicants() {
		return getApplicants().size();
	}
	
	@Override
	public String toString() {
		return "Organization [getApplicants()=" + getApplicants() + ", getOrganizationReps()=" + getOrganizationReps()
				+ ", getAppeals()=" + getAppeals() + ", getOrgID()=" + getOrgID() + ", getOrgName()=" + getOrgName()
				+ ", getAddress()=" + getAddress() + ", numOfAppeals()=" + numOfAppeals() + ", numOfApplicants()="
				+ numOfApplicants() + "]";
	}


	
	
	

}
