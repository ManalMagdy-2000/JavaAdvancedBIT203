package a1;

import java.time.LocalDate;

public class Goods extends Contribution{
	private String desciption ;
	private double estimatedValue ;
	public Goods(LocalDate receivedDate, String contributionID) {
		super(receivedDate, contributionID);
	}

	public String getDesciption() {
		return desciption;
	}
	public double getEstimatedValue() {
		return estimatedValue;
	}

	@Override
	public String toString() {
		return "Goods [getDesciption()=" + getDesciption() + ", getEstimatedValue()=" + getEstimatedValue() + "]";
	}



}
