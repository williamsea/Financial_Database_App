package jhu.edu.database.adroidfinancedatabases.datamodels;

public class DetailedInfoModel {
	String id;
	String AttributeName;
	String AttributeValue;

	
	public String getAttributeName() {
		return AttributeName;
	}
	public void setAttributeName(String attributeName) {
		AttributeName = attributeName;
	}
	public String getAttributeValue() {
		return AttributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		AttributeValue = attributeValue;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
