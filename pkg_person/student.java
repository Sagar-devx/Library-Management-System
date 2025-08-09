package pkg_person;

@SuppressWarnings("serial")
public class student extends person {
	
	private int rollno;
	private int std;
	private String division;
	
	
	public student() {
		super();
	}
	public student(String name, String emailid, String phonenumber, String address, String dob, int rollno, int std,String division) 
	{
		
		super(name, emailid, phonenumber, address, dob);
		this.rollno = rollno;
		this.std = std;
		this.division = division;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std2) {
		this.std = std2;
	} 
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "student [rollno=" + rollno + ", std=" + std + ", division=" + division + ", name=" + name + ", emailid="
				+ emailid + ", phonenumber=" + phonenumber + ", address=" + address + ", dob=" + dob + "]";
	}

}
