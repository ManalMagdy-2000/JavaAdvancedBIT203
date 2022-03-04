package a1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Appeal has a collection of contribution objects
 */
public class Appeal {
	static int appealIdGen = 1;
	private String appealID;
	private LocalDate fromDate ; 
	private LocalDate toDate; 
	private String description ;
	private double outcome;
	private List<Contribution> ctbs;
	private List<Disbursement> dsts ;
	public Appeal(LocalDate fromDate, LocalDate toDate, String description, double outcome,
			List<Contribution> ctbs) {
		setAppealID(appealIdGen++);
		setFromDate(fromDate);
		setToDate(toDate);
		setDescription(description);
		setOutcome(outcome);
		setCtbs(new ArrayList<Contribution>());
		setDsts(new ArrayList<Disbursement>());
	}
	
	public List<Disbursement> getDsts() {
		return dsts;
	}


	public void setDsts(List<Disbursement> dsts) {
		this.dsts = dsts;
	}


	public static int getAppealIdGen() {
		return appealIdGen;
	}

	public static void setAppealIdGen(int appealIdGen) {
		Appeal.appealIdGen = appealIdGen;
	}

	public String getAppealID() {
		return appealID;
	}
	public void setAppealID(int appealID) {
		this.appealID = String.format("T%02d", appealID);
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getOutcome() {
		return outcome;
	}
	public void setOutcome(double outcome) {
		this.outcome = outcome;
	}
	public List<Contribution> getCtbs() {
		return ctbs;
	}
	public void setCtbs(List<Contribution> ctbs) {
		this.ctbs = ctbs;
	}
	/*
	 * method to add contributions , it should be goods or chashDonation.
	 */
	public boolean addContributions(Contribution ctbs) {
		getCtbs().add(ctbs);
		return true;
	}
	/*
	 * method to record disbursements
	 */
	public boolean addDisbursement(Disbursement dsts) {
		getDsts().add(dsts);
		return true;
	}
	
	/*
	 * method to search for contributions based on contributionID
	 */
	public Contribution findContribution(String contributionID) {
		for(Contribution ctbs : getCtbs())
			if(ctbs.getContributionID().equalsIgnoreCase(contributionID))
				return ctbs;
		return null;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Appeal) {
			return getAppealID().equalsIgnoreCase(((Appeal) obj).getAppealID());
		}
		return false;
	}
	/*
	 * to find the number of the contributions made
	 */
	public int numOfCtbs() {
		return getCtbs().size();
	}

	@Override
	public String toString() {
		return "Appeal [getDsts()=" + getDsts() + ", getAppealID()=" + getAppealID() + ", getFromDate()="
				+ getFromDate() + ", getToDate()=" + getToDate() + ", getDescription()=" + getDescription()
				+ ", getOutcome()=" + getOutcome() + ", getCtbs()=" + getCtbs() + ", numOfContributions()="
				+ numOfCtbs() + "]";
	}
	
	
}
