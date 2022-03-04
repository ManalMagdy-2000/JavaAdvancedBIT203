package a1;
import java.time.LocalDate;
import java.util.List;
public abstract class Contribution implements Comparable <Contribution> {
	private LocalDate receivedDate;
	private static int contributionIdGen = 1;
	private String contributionID;
	public Contribution(LocalDate receivedDate, String contributionID) {
		if(!(receivedDate.isAfter(LocalDate.now()))){
            this.receivedDate = receivedDate;
        } else {
            this.receivedDate = LocalDate.now();
        }
		setContributionID(contributionIdGen++);
	}
	
	public Contribution() {
		receivedDate = LocalDate.now();
		
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(LocalDate receivedDate) {
	    if(!( receivedDate.isAfter(LocalDate.now()))){
            this. receivedDate =  receivedDate;
        } else {
            this. receivedDate = LocalDate.now();
        }
	}
	public String getContributionID() {
		return contributionID;
	}
	public void setContributionID(int contributionID) {
		this.contributionID = String.format("T%02d", contributionID);
	}
	public static int getContributionIdGen() {
		return contributionIdGen;
	}
	public static void setContributionIdGen(int contributionIdGen) {
		Contribution.contributionIdGen = contributionIdGen;
	}
	
    
	public boolean equals(Object obj) {
		if (obj instanceof User)
			return getContributionID().equalsIgnoreCase(
				((Contribution) obj).getContributionID());
		return false;
	}
    
	public int compareTo(Contribution ctb) {
		return getContributionID().compareTo(ctb.getContributionID());
	}

	@Override
	public String toString() {
		return "Contribution [getReceivedDate()=" + getReceivedDate() + ", getContributionID()=" + getContributionID()
				+ "]";
	}
	

}
