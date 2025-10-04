package project.beauty;

import javax.swing.*;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class BeautySalonGUI implements ActionListener{
	
	
	 JMenuItem edit; JMenuItem delete;
	  private int[][] clickCounter = new int[7][9]; int g;
	  private JButton[][] buttons = new JButton [7][9];
	  private String[] dates = new String[7];
	 
	private static List<Customer> Custommers = new ArrayList <Customer> ();
	private static List <Service> Services = new ArrayList <Service> ();
	private static List <Appointment> Appointments = new ArrayList <Appointment> ();
	private static Map <String, Double> MembershipDiscount = new HashMap <String, Double> ();
	static {
	    MembershipDiscount.put("Silver", 0.05);
	    MembershipDiscount.put("Gold", 0.10);
	    MembershipDiscount.put("Platinum", 0.15);
	}
	//private static Map <JButton, List<Appointment>> AppointmentMap = new HashMap <JButton, List<Appointment>> ();
	private  SimpleDateFormat DateFormat = new SimpleDateFormat ("yyyy-MM-dd");
	String[] Options = {"Silver", "Gold", "Platinum"};
	String[] ServiceLong = {"30 Minutes", "1 Hour", "1.5 Hours", "2 Hours", "2.5 Hours", "3 Hours"};
	
	JFrame Frame1, Frame2, Frame3, Frame4; 
	JButton ButtonA1, ButtonA2, ButtonA3, ButtonA4, ButtonA5, ButtonA6, ButtonA7, ButtonA8;
	JButton ButtonC;
	JTextField NameText,PhoneNumText;
	JComboBox ComboBox = new JComboBox (Options);
	JComboBox ServiceComboBox = new JComboBox (ServiceLong);
	JComboBox <Customer> ComboCustomerBox  = new JComboBox <Customer> (Custommers.toArray(new Customer[0]));
 	JComboBox <Service> ComboServiceBox  = new JComboBox <Service> (Services.toArray(new Service[0]));
	ImageIcon SalonIcon = new ImageIcon (getClass().getResource("icon.png"));
	ImageIcon backgroundPic = new ImageIcon (getClass().getResource("icoon.png"));
	JMenuItem save; JMenuItem load;
	JButton StartButton;
	JButton button1;
	JButton button2;
	JLabel labelbackground;
	// constructor
	public BeautySalonGUI () {

		Frame1 = new JFrame ("Beauty Salon Management System");
		
		Frame1.setIconImage(SalonIcon.getImage());
		Frame1.setLocationRelativeTo(null);
		Frame1.setResizable(false);
		Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame1.setSize(800, 800);;
		
	    button1 = new JButton ("Admin");
		button1.setBounds(370, 380, 200, 90);
		button1.setBackground(new Color (0xFFF2FE));
		button1.setFocusable(false);
		button1.setFont(new Font ("Algerian", Font.BOLD,30));
		button1.setBorder(BorderFactory.createEtchedBorder());
		
		button1.addActionListener(this);
		
	    button2 = new JButton ("Customer");
		button2.setBounds(600, 380, 200, 90);
		button2.setBackground(new Color (0xFFF2FE));
		button2.setFocusable(false);
		button2.setFont(new Font ("Algerian", Font.BOLD,30));
		button2.setBorder(BorderFactory.createEtchedBorder());
		
	 
		button2.addActionListener(this);
	
	    labelbackground = new JLabel (backgroundPic);
		labelbackground.setSize(800, 800);
		Frame1.add(labelbackground);
		
	    StartButton = new JButton ("Welcome to Beauty Salon System");
		StartButton.setBounds(350, 550, 500, 90);
		StartButton.setBackground(new Color (0xFFF2FE));
		StartButton.setFocusable(false);
		StartButton.setFont(new Font ("Algerian", Font.BOLD,20));
		StartButton.setBorder(BorderFactory.createEtchedBorder());
		StartButton.addActionListener(this);
	
		labelbackground.add(StartButton);
		Frame1.pack();
		Frame1.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == StartButton) {
			labelbackground.add(button1);
			labelbackground.add(button2);
			}
		else if (e.getSource() == button1) {
			Frame2 = new JFrame ("Beauty Salon Management System - Admin Page");
			JLabel background = new JLabel (backgroundPic);
			Frame2.setIconImage(SalonIcon.getImage());
			Frame2.setSize(800, 800);
			Frame2.setResizable(false);
			Frame2.setVisible(true);
			Frame2.add(background);
			Frame2.setLayout(new FlowLayout());
			ButtonA1 = new JButton("Add Customer");
			ButtonA1.setBounds(230, 100, 230, 90);
			ButtonA1.setBackground(new Color (0xFFF2FE));
			ButtonA1.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA1.setFocusable(false);
			ButtonA2 = new JButton("Edit Customer");
			ButtonA2.setBounds(470, 100, 230, 90);
			ButtonA2.setBackground(new Color (0xFFF2FE));
			ButtonA2.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA2.setFocusable(false);
			ButtonA3 = new JButton("Delete Customer");
			ButtonA3.setBounds(710, 100, 230, 90);
			ButtonA3.setBackground(new Color (0xFFF2FE));
			ButtonA3.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA3.setFocusable(false);
			ButtonA4 = new JButton("Add Service");
			ButtonA4.setBounds(230, 300, 230, 90);
			ButtonA4.setBackground(new Color (0xFFF2FE));
			ButtonA4.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA4.setFocusable(false);
			ButtonA5 = new JButton("Edit Service");
			ButtonA5.setBounds(470, 300, 230, 90);
			ButtonA5.setBackground(new Color (0xFFF2FE));
			ButtonA5.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA5.setFocusable(false);
			ButtonA6 = new JButton("Delete Service");
			ButtonA6.setBounds(710, 300, 230, 90);
			ButtonA6.setBackground(new Color (0xFFF2FE));
			ButtonA6.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA6.setFocusable(false);
			ButtonA7 = new JButton("View Appointments");
			ButtonA7.setBounds(310, 500, 260, 90);
			ButtonA7.setBackground(new Color (0xFFF2FE));
			ButtonA7.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA7.setFocusable(false);
			ButtonA8 = new JButton("View Customers");
			ButtonA8.setBounds(580, 500, 260, 90);
			ButtonA8.setBackground(new Color (0xFFF2FE));
			ButtonA8.setFont(new Font ("Algerian", Font.BOLD,20));
			ButtonA8.setFocusable(false);
			
			JMenuBar menuFile = new JMenuBar ();
			JMenu File = new JMenu ("Files");
			 save = new JMenuItem ("Save Data");
			 save.addActionListener(this);
			 load = new JMenuItem ("Load Data");
			 load.addActionListener(this);
			File.add(save);
			File.add(load);
			menuFile.add(File);
			Frame2.setJMenuBar(menuFile);
			
			
			background.add(ButtonA1);
			background.add(ButtonA2);
			background.add(ButtonA3);
			background.add(ButtonA4);
			background.add(ButtonA5);
		    background.add(ButtonA6);
			background.add(ButtonA7);
			background.add(ButtonA8);
			
			ButtonA1.addActionListener(this);
			ButtonA2.addActionListener(this);
			ButtonA3.addActionListener(this);
			ButtonA4.addActionListener(this);
			ButtonA5.addActionListener(this);
			ButtonA6.addActionListener(this);
			ButtonA7.addActionListener(this);
			ButtonA8.addActionListener(this);
			
		}
		else if (e.getSource() == button2) {
			Frame3 = new JFrame ("Beauty Salon Management System - Customer Page");
			Frame3.setIconImage(SalonIcon.getImage());
			Frame3.setSize(800, 800);
			Frame3.setResizable(false);
			Frame3.getContentPane().setBackground(new Color (0xFFF2FE));
			
			JMenuBar menu = new JMenuBar ();
			 edit = new JMenuItem ("Edit Appointment");
			 delete = new JMenuItem ("Delete Appointment");
			JMenu proccess = new JMenu("Process Appointment");
			JMenu helpMenu = new JMenu("Help");
			JMenu contactMenu = new JMenu("Contact");
			proccess.add(edit);
			edit.addActionListener(this);
			proccess.add(delete);
			delete.addActionListener(this);
			menu.add(proccess);
			menu.add(helpMenu);
			menu.add(contactMenu);
			// to make the gird: 
			JPanel weekPanel = new JPanel(new GridLayout(7, 1));
			
			Calendar calendar = Calendar.getInstance();
			for (int i = 0; i < 7; i++) { // 7 days (A week)
				g=i;
	            Date dayDate = calendar.getTime();
	            String formattedDate = DateFormat.format(dayDate);
	            dates[i] = formattedDate;
	            JPanel dayPanel = new JPanel(new GridLayout(1, 9)); // 9 working hours for a day 
	            dayPanel.setBorder(BorderFactory.createTitledBorder(formattedDate));
	            for (int hour=9; hour<18; hour++) {
	            	int finalhour = hour; 
	            	String finalformattedDate = formattedDate;
	            	JButton hourButton = new JButton(hour + ":00");
	            	hourButton.setBackground(new Color (0xFFF2FE));
	            	hourButton.setFocusable(false);
	            	hourButton.addActionListener(event -> handleHourButtonClick(event, finalformattedDate,g, finalhour));
	            	buttons[i][hour - 9] = hourButton;
	            	dayPanel.add(hourButton);
	            	
	            }  
	            weekPanel.add(dayPanel);
	            calendar.add(Calendar.DAY_OF_MONTH, 1); // +1 for current date, next day
			   
			
		}
			Frame3.setJMenuBar(menu);
			Frame3.add(weekPanel);
			Frame3.setVisible(true);
		}
		else if (e.getSource() == ButtonA1) { // Add Customer
			AddCustomer();
			
		}
		else if (e.getSource() == ButtonA2) { // Edit Customer
			EditCustomer(SelectCustomer());
		}
		else if (e.getSource() == ButtonA3) { // Delete Customer
			DeleteCustomer(SelectCustomer());
		}
		else if (e.getSource() == ButtonA4) { // Add Service
			AddService();
		}
		else if (e.getSource() == ButtonA5) { // Edit Service
			EditService(SelectService());
		}
		else if (e.getSource() == ButtonA6) { // Delete Service
			DeleteService(SelectService());
		}
		else if (e.getSource() == ButtonA7) { // View Appointments
		    ViewAppointments();
		}
		else if (e.getSource() == ButtonA8) { // View Customers
			ViewCustomers();
		}
		else if (e.getSource() == edit) { // Edit Appointment
			EditAppointment(SelectAppointment());
		}
		else if (e.getSource() == delete) { // Delete Appointment
			DeleteAppointment(SelectAppointment());
		}
		else if (e.getSource() == save) {
			SaveCustomers();
			SaveServices();
			SaveAppointments();
		}
		else if (e.getSource() == load) {
			LoadCustomers();
			LoadServices();
			LoadAppointments();
		}
		
		
	}
	
	private Customer SelectCustomer () {
		JComboBox <Customer> ComboCustomerBox  = new JComboBox <Customer> (Custommers.toArray(new Customer[0]));
		JPanel Panel = new JPanel(new GridLayout(2,1));
		Panel.add(new JLabel ("Select Customer"));
		Panel.add(ComboCustomerBox);
		int result = JOptionPane.showConfirmDialog(null, Panel,"Select Customer", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			return (Customer)(ComboCustomerBox.getSelectedItem());
		}
		else {
			return null;
		}
	}
	private void AddCustomer() {
		JPanel Panel = new JPanel (new GridLayout(3,2));
		 NameText = new JTextField(15);
		 PhoneNumText = new JTextField(15);
		Panel.add(new JLabel("Name: "));
		Panel.add(NameText);
		Panel.add(new JLabel ("Phone Number: "));
		Panel.add(PhoneNumText);
		Panel.add(new JLabel ("Mmembership Type: "));
		Panel.add(ComboBox);
		int AddCustomerResult = JOptionPane.showConfirmDialog(null, Panel, "Add Customer", JOptionPane.OK_CANCEL_OPTION);
		if (AddCustomerResult == JOptionPane.OK_OPTION) {
			String Name = NameText.getText();
			String PhoneNumber = PhoneNumText.getText();
			String MemberShip = (String)ComboBox.getSelectedItem();
			Customer customer = new Customer (Name,PhoneNumber,MemberShip);
			Custommers.add(customer);
			JOptionPane.showMessageDialog(null, "The Customer has Added Successfully");
			
		}
	}
	private void EditCustomer(Customer customer) {
		if (customer != null) {
			 NameText = new JTextField(customer.Get_Name(),15);
			 PhoneNumText = new JTextField(customer.Get_PhoneaNumber(),15);
			 ComboBox.setSelectedItem(customer.Get_MembershipType());
			 JPanel panel = new JPanel (new GridLayout(3,2));
			 panel.add(new JLabel("Name: "));
			 panel.add(NameText);
			 panel.add(new JLabel ("Phone Number: "));
			 panel.add(PhoneNumText);
			 panel.add(new JLabel ("Mmembership Type: "));
			 panel.add(ComboBox);
			 int EditCustomerResult = JOptionPane.showConfirmDialog(null, panel, "Edit Customer", JOptionPane.OK_CANCEL_OPTION);
				if (EditCustomerResult == JOptionPane.OK_OPTION) {
					customer.Set_Name(NameText.getText());
					customer.Set_PhoneNumber(PhoneNumText.getText());
					customer.Set_MembershipType((String)ComboBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, "The Customer has Edited Successfully");
		}
	}
	}
	private void DeleteCustomer (Customer customer) {
		if (customer != null) {
			int Confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?", "Delete Customer", JOptionPane.YES_NO_OPTION);
		    if (Confirm == JOptionPane.YES_OPTION) {
		    	Custommers.remove(customer);
		    	JOptionPane.showMessageDialog(null, "The Customer has Deleted Successfully");
		    }
		}
	}
	
	private void AddService() {
		JPanel Panel = new JPanel (new GridLayout(3,2));
		 JTextField ServiceName = new JTextField(15);
		 JTextField ServicePrice = new JTextField(15);
		 Panel.add(new JLabel("Name: "));
		 Panel.add(ServiceName);
		 Panel.add(new JLabel("Duration: "));
		 Panel.add(ServiceComboBox);
		 Panel.add(new JLabel("Price: "));
		 Panel.add(ServicePrice);
		 int AddServiceResult = JOptionPane.showConfirmDialog(null, Panel, "Add Service", JOptionPane.OK_CANCEL_OPTION);
		 if (AddServiceResult == JOptionPane.OK_OPTION) {
			 String Name = ServiceName.getText();
			 double Price = Double.parseDouble(ServicePrice.getText());
			 String duration = (String)ServiceComboBox.getSelectedItem(); 
			 Service service = new Service (Name, duration, Price);
			 Services.add(service);
			 JOptionPane.showMessageDialog(null, "The service has added successfully");
			
		 } 
	}
	private Service SelectService() {
		JComboBox <Service> ComboServiceBox  = new JComboBox <Service> (Services.toArray(new Service[0]));
		JPanel Panel = new JPanel(new GridLayout(2,1));
		Panel.add(new JLabel ("Select Service"));
		Panel.add(ComboServiceBox);
		int result = JOptionPane.showConfirmDialog(null, Panel,"Select Service", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			return (Service)(ComboServiceBox.getSelectedItem());
		}
		else {
			return null;
		}
	}
	private void EditService(Service service) {
		if (service != null) {
			 JTextField Name = new JTextField(service.Get_Name_Ser(),15);
			 JTextField Price = new JTextField(Double.toString(service.Get_Price_Ser()),15);
			 ServiceComboBox.setSelectedItem(service.Get_Duration_Ser());
			 JPanel Panel = new JPanel (new GridLayout(3,2));
			 Panel.add(new JLabel("Name: "));
			 Panel.add(Name);
			 Panel.add(new JLabel("Duration: "));
			 Panel.add(ServiceComboBox);
			 Panel.add(new JLabel("Price: "));
			 Panel.add(Price);
			 int EditServiceResult = JOptionPane.showConfirmDialog(null, Panel, "Edit Service", JOptionPane.OK_CANCEL_OPTION);
			 if (EditServiceResult == JOptionPane.OK_OPTION) {
				 service.Set_Name_Ser(Name.getText());
				 service.Set_Duration_Ser((String)ServiceComboBox.getSelectedItem());
				 service.Set_Price_Ser(Double.parseDouble(Price.getText()));
				 JOptionPane.showMessageDialog(null, "The Service has Edited Successfully");
			 }	
	}
	}
	private void DeleteService (Service service) {
		if (service != null) {
			int Confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this service?", "Delete Service", JOptionPane.YES_NO_OPTION);
		    if (Confirm == JOptionPane.YES_OPTION) {
		    	Services.remove(service);
		    	JOptionPane.showMessageDialog(null, "The Service has Deleted Successfully");	
		}
	}
	}
	private void ViewCustomers () {
		JTextArea TextArea = new JTextArea ();
		TextArea.setEditable(false);
		JPanel Plane = new JPanel ();
		for (Customer customer : Custommers) {
		TextArea.append(customer.toString()+"\n");
		}
		Plane.add(new JScrollPane(TextArea));
		Plane.add(TextArea);
		JOptionPane.showMessageDialog(null, Plane, "Customers", JOptionPane.INFORMATION_MESSAGE);
	}
	private void ViewAppointments () {
		JTextArea TextArea = new JTextArea ();
		TextArea.setEditable(false);
		JPanel Plane = new JPanel ();
		for (Appointment appointment : Appointments) {
		TextArea.append(appointment.toString()+"\n");
		}
		Plane.add(new JScrollPane(TextArea));
		Plane.add(TextArea);
		JOptionPane.showMessageDialog(null, Plane, "Appointments", JOptionPane.INFORMATION_MESSAGE);
	}
	 private void handleHourButtonClick(ActionEvent event, String date, int day, int hour) {
		  int hourIndex = hour - 9;
		  JButton button = (JButton)event.getSource();
		  if (clickCounter[day][hourIndex] < 3) {
			  AddAppointment(date, hour);
			  clickCounter[day][hourIndex]++;
			 
			  if ( clickCounter[day][hourIndex]==3) {
				button.setBackground(Color.red);
		        button.setEnabled(false);    
			  } 
		  } 
	 }
	 
	
	 private void AddAppointment (String date, int hour) {
     	JPanel AppointmentPanel = new JPanel (new GridLayout(4,2));
     	JComboBox <Customer> ComboCustomerBox  = new JComboBox <Customer> (Custommers.toArray(new Customer[0]));
     	JComboBox <Service> ComboServiceBox  = new JComboBox <Service> (Services.toArray(new Service[0]));
     	AppointmentPanel.add(new JLabel ("Customer: "));
     	AppointmentPanel.add(ComboCustomerBox);
     	AppointmentPanel.add(new JLabel ("Service: "));
     	AppointmentPanel.add(ComboServiceBox);
     	AppointmentPanel.add(new JLabel ("Date: "));
     	AppointmentPanel.add(new JLabel (date));
     	AppointmentPanel.add(new JLabel ("Time: ")); 
     	AppointmentPanel.add(new JLabel (Integer.toString(hour )+":00"));
        int AddAppointmentResult =	JOptionPane.showConfirmDialog(null, AppointmentPanel, "Add Appointment", JOptionPane.OK_CANCEL_OPTION);
        if (AddAppointmentResult == JOptionPane.OK_OPTION) {
        	Customer customer = (Customer)ComboCustomerBox.getSelectedItem();
        	Service service = (Service)ComboServiceBox.getSelectedItem();
        	double Discount = MembershipDiscount.getOrDefault(customer.Get_MembershipType(), 0.0);
        	double TotalPrice = service.Get_Price_Ser() - (service.Get_Price_Ser()*Discount);
        	if (customer != null && service != null) {
        	        Appointment appointment = new Appointment (customer, service, date,hour, TotalPrice );
                	Appointments.add(appointment);
                	
        }	
	}
	 }
	 
	  
	 private Appointment SelectAppointment() {
		JPanel panel = new JPanel (new GridLayout (1,2));
	    panel.add(new JLabel ("Appointment:"));
	    JComboBox <Appointment> AppointmentComboBox  = new JComboBox <Appointment> (Appointments.toArray(new Appointment[0]));
	    panel.add(AppointmentComboBox);
	    int result = JOptionPane.showConfirmDialog(null, panel, "Select Appointment", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	    	return (Appointment)(AppointmentComboBox.getSelectedItem());
	    }
	    else 
	    	return null;
	 }
	 
	 
	 private void EditAppointment (Appointment appointment) {
		 if (appointment != null) {
		JPanel Panel = new JPanel (new GridLayout (4,2));
		JComboBox <Customer> ComboCustomerBox  = new JComboBox <Customer> (Custommers.toArray(new Customer[0]));
	 	JComboBox <Service> ComboServiceBox  = new JComboBox <Service> (Services.toArray(new Service[0]));
		ComboCustomerBox.setSelectedItem(appointment.Get_customer_Appo());
		ComboServiceBox.setSelectedItem(appointment.Get_service_Appo());
		Panel.add(new JLabel ("Customer: "));
		Panel.add(ComboCustomerBox);
		Panel.add(new JLabel ("Service: "));
		Panel.add(ComboServiceBox);
		Panel.add(new JLabel ("Date: "));
		 JComboBox<String> dateComboBox = new JComboBox<String>();
	        Calendar calendar = Calendar.getInstance();
	        for (int i = 0; i < 7; i++) {
	            Date dayDate = calendar.getTime();
	            String formattedDate = DateFormat.format(dayDate);
	            dateComboBox.addItem(formattedDate);
	            calendar.add(Calendar.DAY_OF_MONTH, 1);
	        }
	        dateComboBox.setSelectedItem(DateFormat.format(appointment.Get_date_Appo()));
	        Panel.add(dateComboBox);
	        
		Panel.add(new JLabel ("Time: "));
		  JComboBox<Integer> timeComboBox = new JComboBox<Integer>();
		  
	        for (int hour = 9; hour < 18; hour++) { 
	            timeComboBox.addItem(hour);
	        }
	        timeComboBox.setSelectedItem(appointment.Get_Time_Appo());
	        Panel.add(timeComboBox);
	        
		int result = JOptionPane.showConfirmDialog(null, Panel, "Edit Appointment", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			try {
				  Customer selectedCustomer = (Customer) ComboCustomerBox.getSelectedItem();
                  Service selectedService = (Service) ComboServiceBox.getSelectedItem();
                  double Discount = MembershipDiscount.getOrDefault(selectedCustomer.Get_MembershipType(), 0.0);
              	  double TotalPrice = selectedService.Get_Price_Ser() - (selectedService.Get_Price_Ser()*Discount);
                  String selectedDateString = (String) dateComboBox.getSelectedItem();
                  Date selectedDate = DateFormat.parse(selectedDateString);
                  int selectedHour = (Integer) timeComboBox.getSelectedItem();
                  appointment.Set_TotalPrice_Appo(TotalPrice);
                  appointment.Set_customer_Appo(selectedCustomer);
                  appointment.Set_service_Appo(selectedService);
                  appointment.Set_date_Appo(selectedDate);
                  appointment.Set_Time_Appo(selectedHour);
                  

                  JOptionPane.showMessageDialog(null, "Appointment updated successfully.");
              } catch (ParseException e) {
            	  e.printStackTrace();
                  JOptionPane.showMessageDialog(null, "Error updating appointment. Invalid date format.");
			}
			
		}
		
		 }
	 }
	 private void DeleteAppointment (Appointment appointment) {
		 if (appointment != null) {
		int result = JOptionPane.showConfirmDialog(null,"Are you sure to delete the appointment?", "Confrim to delete", JOptionPane.YES_NO_OPTION);
		 if (result == JOptionPane.YES_OPTION) {
			 Appointments.remove(appointment);
			 JOptionPane.showMessageDialog(null, "The Appointment has deleted Successfully");
			 String date =DateFormat.format(appointment.Get_date_Appo()); 
			    int hour =(int) appointment.Get_Time_Appo();
			    int day = findDayIndex(date);
			    int hourIndex = hour - 9;

			 if (day != -1 && hourIndex >= 0 && hourIndex < 9) {  
			     clickCounter[day][hourIndex]--;
			 if (clickCounter[day][hourIndex] < 3) {
				 buttons[day][hourIndex].setEnabled(true);
			     buttons[day][hourIndex].setBackground(new Color(0xFFF2FE));
			        
			    }
			}
		 }
		 }
	 }
		private int findDayIndex (String date) {
			 for (int i = 0; i < 7; i++) {
			        if (dates[i].equals(date)) {
			            return i;
			        }
			    }
			    return -1;
			  
		}
	
	 private void LoadAppointments() {
		 try (BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 9) {
	                	String Date = parts[0];
	                	double time = Double.parseDouble(parts[1]);
	                	double totalPrice = Double.parseDouble(parts[2]);
	                    String customerName = parts[3];
	                    String customerPhone = parts[4];
	                    String memberType = parts[5];
	                    String serviceName = parts[6];
	                    String serviceDuration = parts[7];
	                    double servicePrice = Double.parseDouble(parts[8]);
	                    Customer customer = new Customer (customerName, customerPhone, memberType);
	                    Service service = new Service (serviceName, serviceDuration, servicePrice);
	                    Appointment appointment = new Appointment(customer, service, Date,time,totalPrice);
	                    Appointments.add(appointment);
	                    
	                }
	            }
	            System.out.println("Appointments loaded successfully.");
	        }
	            catch (IOException e) {
	            System.err.println("Error loading appointments: " + e.getMessage());
	        }
	 }
	 private void LoadCustomers() {
		 try (BufferedReader reader = new BufferedReader(new FileReader("Customer.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String name = parts[0];
	                    String phoneNumber = parts[1];
	                    String membershipType = parts[2];
	                    Custommers.add(new Customer(name, phoneNumber, membershipType));
	                }
	            }
	            System.out.println("Customers loaded successfully.");
	        } catch (IOException e) {
	            System.err.println("Error loading customers: " + e.getMessage());
	        }
	 }
	 private void LoadServices() {
		 try (BufferedReader reader = new BufferedReader(new FileReader("Service.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String serviceName = parts[0];
	                    String duration = parts[1];
	                    double price = Double.parseDouble(parts[2]);
	                    Services.add(new Service(serviceName,duration, price));
	                }
	            }
	            System.out.println("Services loaded successfully.");
	        } catch (IOException e) {
	            System.err.println("Error loading services: " + e.getMessage());
	        }
	 }
	 
	 private void SaveAppointments() {
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter("Appointment.txt"))) {
	            for (Appointment appointment : Appointments) {
	                writer.write(appointment.toString()); 
	                writer.newLine();
	            }
	            System.out.println("Appointments saved successfully.");
	        } catch (IOException e) {
	            System.err.println("Error saving appointments: " + e.getMessage());
	        }
	 }
	 
	 private void SaveCustomers() {
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.txt"))) {
	            for (Customer customer : Custommers) {
	                writer.write(customer.toString()); 
	                writer.newLine();
	            }
	            System.out.println("Customers saved successfully.");
	        } catch (IOException e) {
	            System.err.println("Error saving customers: " + e.getMessage());
	        }
	    }
	 private void SaveServices() {
		   try (BufferedWriter writer = new BufferedWriter(new FileWriter("Service.txt"))) {
	            for (Service service : Services) {
	                writer.write(service.toString()); 
	                writer.newLine();
	            }
	            System.out.println("Services saved successfully.");
	        } catch (IOException e) {
	            System.err.println("Error saving services: " + e.getMessage());
	        }
	    }
	 

	public static void main(String[] args) {
	new	BeautySalonGUI();
		
     }

	}






	


