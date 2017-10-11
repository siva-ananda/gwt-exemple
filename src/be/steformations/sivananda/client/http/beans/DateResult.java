package be.steformations.sivananda.client.http.beans;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DateResult implements Serializable{
	
	private Date date;
	private String formattedDate;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	
	@Override
	public String toString() {
		return "DateResult [date=" + date + ", formattedDate=" + formattedDate + "]";
	}

}
