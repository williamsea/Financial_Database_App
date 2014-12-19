package jhu.edu.database.adroidfinancedatabases.datamodels;

public class DetailedInfoModel {
	String id;
	String CompanyName;
	String Attribute1;
	String Attribute2;
	String Attribute3;
	String Attribute4;
	String Attribute5;

	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public String getAttribute1() {
		return Attribute1;
	}
	public void setAttribute1(String attribute1) {
		Attribute1 = attribute1;
	}
	
	public String getAttribute2() {
		return Attribute2;
	}
	public void setAttribute2(String attribute2) {
		Attribute2 = attribute2;
	}
	
	public String getAttribute3() {
		return Attribute3;
	}
	public void setAttribute3(String attribute3) {
		Attribute3 = attribute3;
	}
	
	public String getAttribute4() {
		return Attribute4;
	}
	public void setAttribute4(String attribute4) {
		Attribute4 = attribute4;
	}
	
	public String getAttribute5() {
		return Attribute5;
	}
	public void setAttribute5(String attribute5) {
		Attribute5 = attribute5;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
