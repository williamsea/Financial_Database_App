package jhu.edu.database.adroidfinancedatabases.datamodels;

public class DataModel {
	String id;
	String CompanyName;
	String CompanyAddress;
	String CompanyWebsite;
	
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyAddress() {
		return CompanyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		CompanyAddress = companyAddress;
	}
	public String getCompanyWebsite() {
		return CompanyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		CompanyWebsite = companyWebsite;
	}

}
