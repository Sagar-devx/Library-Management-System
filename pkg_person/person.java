package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
abstract public class person implements Serializable {

	protected String name;
	protected String emailid;
	protected String phonenumber;
	protected String address;
	protected String dob;
	
	
	public person() {
		super();
	}
	
	public person(String name, String emailid, String phonenumber, String address, String dob) {
		super();
		this.setName(name);
		this.setEmailid(emailid);
		this.setPhonenumber(phonenumber);
		this.address = address;
		this.setDob(dob);
	}
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) 
	{
		
             boolean isvalidname =Pattern.matches("[a-zA-z]+",name);
		
				if(isvalidname)
				{
				this.name = name;
				}
				else
				{
					
					this.name = "default name";
				}
	}
	
	
	
	public String getEmailid() {
		return emailid;
	}
	
	
	public void setEmailid(String emailid) 
	{
		boolean isvalidemail = Pattern.matches("^[a-zA-Z][a-zA-Z0-9._-]*[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,6}$", emailid);
		
		if(isvalidemail)
		{
		this.emailid = emailid;
		}
		else
		{
		   System.out.println("invalid email id . Setting default email");
		   this.emailid = "student054@gmail.com";
		}
	}
	
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	
	public void setPhonenumber(String phonenumber) 
	{
	
	   boolean isvalidphonenumber = Pattern.matches("[6-9][0-9]{9}", phonenumber);
	
	    if (isvalidphonenumber)
	    {
	        this.phonenumber = phonenumber;
	    } 
	    else 
	    {
	        System.out.println("Invalid phone number. Setting default number.");
	        this.phonenumber = "0000000000";
	    }
	}
	
	

	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDob() {
		return dob;
	}
	
	
	public void setDob(String dob) {
		
		boolean isvaliddob = Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
		
		if(isvaliddob) 
		{
		this.dob = dob;
		}
		else
		{
			this.dob ="01-06-2005";
			
		}
	}
	
	
}
