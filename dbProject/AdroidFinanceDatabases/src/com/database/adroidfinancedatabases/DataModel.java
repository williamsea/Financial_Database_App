package com.database.adroidfinancedatabases;

public class DataModel {
	String id;
	String PosterName;
	String StartTime;
	String EndTime;
	String Resturant;
	String AdditionalInformation;
	
	public String getPosterName() {
		return PosterName;
	}
	public void setPosterName(String posterName) {
		PosterName = posterName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getResturant() {
		return Resturant;
	}
	public void setResturant(String resturant) {
		Resturant = resturant;
	}
	public String getAdditionalInformation() {
		return AdditionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		AdditionalInformation = additionalInformation;
	}
}
