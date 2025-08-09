package pkg_book;

import java.io.Serializable;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class book implements Serializable
{
	
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int edition;
	private String subject;
	private String available_quantity;
	
	
	public book() {
		super();
	}
	public book(int isbn, String title, String author, String publisher, int edition, String subject,String available_quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.setAuthor(author);
		this.publisher = publisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantity;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) 
	{
		   boolean isvalidname =Pattern.matches("[a-zA-z]+",author);
			
			if(isvalidname)
			{
			this.author= author;
			}
			else
			{
				
				this.author= "default name";
			}
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantity(String available_quantity) {
		this.available_quantity = available_quantity;
	}
	
	@Override
	public String toString() {
		return "book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", subject=" + subject + ", available_quantity=" + available_quantity + "]";
	}
}
