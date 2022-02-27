package ca.bcit.comp3601;

/**
 * @author Dalvir Chiount, A01258927
 */

public class Customer {

	private int memberId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String code;
	private String country;
	private String phoneNumber;
	private String email;
	
	public Customer() {
		super();

	}

	public Customer(int memberId, String firstName, String lastName, String address, String city, String code,
			String country, String phoneNumber, String email) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.code = code;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", city=" + city + ", code=" + code + ", country=" + country + ", phoneNumber="
				+ phoneNumber + ", email=" + email + "]";
	}
	
}
