package project.beauty;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Appointment {
	 SimpleDateFormat DateFormat = new SimpleDateFormat ("yyyy-MM-dd");
// DATA
	private Customer customer;
	private Service service;
	private Date date;
	private double Time;
	private double TotalPrice;
// Constructor
	public Appointment (Customer customer, Service service, String date,double Time, double totalprice) {
		this.customer = customer;
		this.service = service;
		
		try {
			this.date = DateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.Time = Time;
		TotalPrice = totalprice;
	}
	// Setters
	public void Set_customer_Appo (Customer customer) {
		this.customer = customer;
	}
	public void Set_service_Appo (Service service) {
		this.service = service;
	}
	public void Set_date_Appo (Date date) {
		this.date = date;
	}
	public void Set_Time_Appo (double Time) {
		this.Time = Time;
	}
	public void Set_TotalPrice_Appo (double TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
// Getters
	public Customer Get_customer_Appo () {
		return customer;
	}
	public Service Get_service_Appo () {
		return service;
	}
	public Date Get_date_Appo () {
		return date;
	}
	public double Get_Time_Appo() {
		return Time;
	}
	public double Get_TotalPrice_Appo() {
		return TotalPrice;
	}
// toString
	@Override
	public String toString() {
		
		String formateddate = DateFormat.format(date);
		return (formateddate+", "+Time +", "+TotalPrice+", "+customer.toString()+", "+service.toString());
	}
	
	
	
	
}
