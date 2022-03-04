package a1;
import java.time.LocalDate;
import java.util.List;
public class CashDonation extends Contribution{
	private double amount ;
	private String paymentChannel ;
	private String referenceNo ;
	public CashDonation(LocalDate receivedDate, String contributionID) {
		super(receivedDate, contributionID);
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentChannel() {
		return paymentChannel;
	}
	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	@Override
	public String toString() {
		return "CashDonation [getAmount()=" + getAmount() + ", getPaymentChannel()=" + getPaymentChannel()
				+ ", getReferenceNo()=" + getReferenceNo() + "]";
	}


	

	

}
