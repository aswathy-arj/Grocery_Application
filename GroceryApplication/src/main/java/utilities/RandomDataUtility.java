package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker randomdata = new Faker();//Faker is a predefined class to generate random data
	
	public String generateRandomUsername() {
		return randomdata.name().username(); //usernames are under name() method -- names are under faker
	}
	public String generateRandomPassword() {
		return randomdata.internet().password(); //passwords are under internet() method
	}
	public String generateFullname() {
		return randomdata.name().fullName(); //Fullname are under name().
	}
	public String generateEmail() {
		return randomdata.internet().emailAddress(); //emailaddress are under internet().
	}
	public String generatePhoneNumber() {
		return randomdata.phoneNumber().cellPhone(); //mobile numbers are under phoneNumber() then under cellPhone(). 
	}
}
