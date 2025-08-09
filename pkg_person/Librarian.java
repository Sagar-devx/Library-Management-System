package pkg_person;

@SuppressWarnings("serial")
public class Librarian extends person {
	
	private int id;
	private String doj;
	
	public Librarian() {
		super();
	}
	public Librarian(String name, String emailid, String phonenumber, String address, String dob , int id , String doj) {
		
		super(name, emailid, phonenumber, address, dob);
		this.id = id;
		this.doj = doj;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", doj=" + doj + ", name=" + name + ", emailid=" + emailid + ", phonenumber="
				+ phonenumber + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	
	
	

}
