package entities;

import java.util.Date;

public class Travel {

	private int travelId;
	private Date travelDate;
	private String source;
	private String travelDestination;
	private int numberOfPersons;
	
	public Travel() {
		
	}
	
	public Travel(int travelId, Date travelDate, String source, String travelDestination, int numberOfPersons) {
		super();
		this.travelId = travelId;
		this.travelDate = travelDate;
		this.source = source;
		this.travelDestination = travelDestination;
		this.numberOfPersons = numberOfPersons;
	}

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTravelDestination() {
		return travelDestination;
	}

	public void setTravelDestination(String travelDestination) {
		this.travelDestination = travelDestination;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	@Override
	public String toString() {
		return "Travel [travelId=" + travelId + ", travelDate=" + travelDate + ", source=" + source
				+ ", travelDestination=" + travelDestination + ", numberOfPersons=" + numberOfPersons + "]";
	}
	
	
}
