package project.beauty;


class Service  {
// DATA
	private String Name;
	private String Duration;
	private double Price;
	
// CONSTRUCTOR
	public Service (String Name, String Duration, double Price) {
		this.Name = Name;
		this.Duration = Duration; 
		this.Price = Price;
	}
// Setters
	public void Set_Name_Ser (String name) {
		Name = name;
	}
	public void Set_Duration_Ser (String duration) {
		Duration = duration;
	}
	public void Set_Price_Ser (double price) {
		Price = price;
	}
// Getters
	public String Get_Name_Ser () {
		return Name;
	}
	public String Get_Duration_Ser () {
		return Duration;
	}
	public double Get_Price_Ser () {
		return Price;
	}
// toString
	@Override
	public String toString() {
		return (Name + ", "+ Duration+ ", "+ Price );
	}
	
	
}
