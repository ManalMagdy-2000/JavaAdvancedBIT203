package a1;
import java.time.LocalDate;
public class Disbursement {
	private LocalDate disbursementDate ;
	private double cashAmount; 
	private String goodsDisbursed;
	public Disbursement(LocalDate disbursementDate, double cashAmount, String goodsDisbursed) {
		super();
		setDisbursementDate(disbursementDate);
		setCashAmount(cashAmount);
		setGoodsDisbursed(goodsDisbursed);
	}
	public LocalDate getDisbursementDate() {
		return disbursementDate;
	}
	public void setDisbursementDate(LocalDate disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	public double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public String getGoodsDisbursed() {
		return goodsDisbursed;
	}
	public void setGoodsDisbursed(String goodsDisbursed) {
		this.goodsDisbursed = goodsDisbursed;
	}
	@Override
	public String toString() {
		return "Disbursement [getDisbursementDate()=" + getDisbursementDate() + ", getCashAmount()=" + getCashAmount()
				+ ", getGoodsDisbursed()=" + getGoodsDisbursed() + "]";
	}
	
	
}
