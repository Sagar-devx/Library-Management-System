package pkg_transaction;

import java.io.Serializable;

@SuppressWarnings("serial")
public class bookTransaction implements Serializable{
	
	private int isbn;
	private int rollno;
	private String issuedate;
	private String returndate;
	
	
	public bookTransaction() {
		super();
	}
	public bookTransaction(int isbn, int rollno, String issuedate, String returndate) {
		super();
		this.isbn = isbn;
		this.rollno = rollno;
		this.issuedate = issuedate;
		this.returndate = returndate;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	@Override
	public String toString() {
		return "bookTransaction [isbn=" + isbn + ", rollno=" + rollno + ", issuedate=" + issuedate + ", returndate="
				+ returndate + "]";
	}

	
	
}
