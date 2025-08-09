package pkg_book;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class BookManager
{
	
		ObjectOutputStream oos_book = null;
		ObjectInputStream ois_book = null;
		
		File book_file =new File("Books.dat");
		
		ArrayList<book> book_list = null;
	
			@SuppressWarnings("unchecked")
			public BookManager()
			{
				    book_list = new ArrayList<book>();
				
			     	if(book_file.exists())
			     	{
					
						try {
							ois_book = new ObjectInputStream(new FileInputStream(book_file));
							
							
							book_list = (ArrayList<book>) ois_book.readObject();
							}
							catch(ClassNotFoundException e) {
								
								e.printStackTrace();
								
							}
						  catch (IOException e) {
								
								e.printStackTrace();
							}
			     	}
	       }
			
			
	public void listbooksbysubject(String subject)
	{
		for(book book :book_list)
		{
			if(book.getSubject().equals(subject)) {        
				System.out.println(book);
			}
		}
		
	}
	
	public void addbook(book book) 
	{
		
		book_list.add(book);
		
   	}
	
	public void viewallbooks()
	{
		
		for(book book :book_list)
		{
			
			System.out.println(book);	
		}	
	}
	
	public book searchbookbyisbn(int search_isbn)
	{
		for(book book :book_list) 
		{
			if(book.getIsbn()==search_isbn)
			{
				return book;
			}
			
		}
		return null;
	}
	
	public boolean updatebook (int update_isbn,String title, String author, String publisher, int edition, String subject,String available_quantity)
	{
		
		ListIterator<book> book_iterator = book_list.listIterator();

		
		while(book_iterator.hasNext()) {
			
			book book= book_iterator.next();          
			
			if(book.getIsbn()==update_isbn) 
			{
				book.setAuthor(author);
				book.setEdition(edition);
				book.setPublisher(publisher);
				book.setTitle(title);
				book.setAvailable_quantity(available_quantity);
				book.setSubject(subject);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean deletebook (int delete_isbn)
	{
		
		ListIterator<book> book_iterator = book_list.listIterator();

		
		while(book_iterator.hasNext()) {
			
			book book= book_iterator.next();       
			
			if(book.getIsbn()==delete_isbn) {
				
				book_list.remove(book);
				return true;
			}
		}
		return false;
	}
	
	public void writetofile()
	{
		try {
			oos_book = new ObjectOutputStream(new FileOutputStream(book_file));
			
			oos_book.writeObject(book_list);
		} 
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
}
