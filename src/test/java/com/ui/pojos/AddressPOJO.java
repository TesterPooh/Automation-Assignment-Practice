package com.ui.pojos;

public class AddressPOJO {

private String company;
private String addressLine1;
private String addressLine2;
private String city;
private String Zipcode;
private String country;
private String homephone;
private String mobilephone;
private String additionalinfo;
private String addressalias;
private String state;
public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String zipcode,
		String country, String homephone, String mobilephone, String additionalinfo, String addressalias,
		String state) {
	super();
	this.company = company;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.Zipcode = zipcode;
	this.country = country;
	this.homephone = homephone;
	this.mobilephone = mobilephone;
	this.additionalinfo = additionalinfo;
	this.addressalias = addressalias;
	this.state = state;
}
public AddressPOJO(String name, String buildingNumber, String streetAddress, String city2, String zipCode2,
		String country2, String phoneNumber, String cellPhone, String additionalinfo2, String addressalias2,
		int numberBetween) {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
			+ ", city=" + city + ", Zipcode=" + Zipcode + ", country=" + country + ", homephone=" + homephone
			+ ", mobilephone=" + mobilephone + ", additionalinfo=" + additionalinfo + ", addressalias=" + addressalias
			+ ", state=" + state + "]";
}
public String getCompany() {
	return company;
}
public String getAddressLine1() {
	return addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public String getCity() {
	return city;
}
public String getZipcode() {
	return Zipcode;
}
public String getCountry() {
	return country;
}
public String getHomephone() {
	return homephone;
}
public String getMobilephone() {
	return mobilephone;
}
public String getAdditionalinfo() {
	return additionalinfo;
}
public String getAddressalias() {
	return addressalias;
}
public String getState() {
	return state;
}



}
