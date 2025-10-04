package project.beauty;


class Customer {
	 
	// Customer's DATA
	private String Name;
	private String PhoneNumber;
	private String MembershipType;
	
	// constructor: 
	public Customer (String Name, String PhoneNumber, String MembershipType) {
		this.Name = Name;
		this.PhoneNumber = PhoneNumber;
		this.MembershipType = MembershipType;
	}
	
	// getters: 
	public String Get_Name () {
		return Name;
	}
	public String Get_PhoneaNumber () {
		return PhoneNumber;
	}
	public String Get_MembershipType() {
		return MembershipType;
	}
	
	// setters: 
	public void Set_Name (String name) {
		Name = name;
	}
	public void Set_PhoneNumber (String phoneNumber) {
		PhoneNumber=phoneNumber;
	}
	public void Set_MembershipType (String memberType) {
		MembershipType = memberType;
	}
	// toString (printing the customer)
	@Override
	public String toString() {
		
		return (Name+", "+PhoneNumber+", "+MembershipType);
		
	}
	
	
	
	
	
}
