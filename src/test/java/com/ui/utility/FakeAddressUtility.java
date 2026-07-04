package com.ui.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

public class FakeAddressUtility {

	
	 public static void main(String[] args) { getFakeAddress();
	
	}
	
public static AddressPOJO getFakeAddress()
{
	Faker faker = new Faker(Locale.US);
	AddressPOJO addressPOJO= new AddressPOJO(faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), 
			faker.address().city(), faker.numerify("#####"),  faker.address().country(), faker.phoneNumber().cellPhone(),
			faker.phoneNumber().cellPhone(), "other", "OfficeAddress", faker.numerify("#"));
     return addressPOJO	;

}

}
