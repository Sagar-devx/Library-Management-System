package pkg_transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class bookTransactionManager {

	 ObjectOutputStream oos_book_transaction = null;
    
    ObjectInputStream ois_book_transaction = null;

    File book_transaction_file = null;
    
    ArrayList<bookTransaction> book_transaction_list = null;

    @SuppressWarnings("unchecked")
	public bookTransactionManager() 
    {

        book_transaction_file = new File("book_transactions.dat");
        
        book_transaction_list = new ArrayList<>();
        

        if (book_transaction_file.exists())
        {
            try {
                ois_book_transaction = new ObjectInputStream(new FileInputStream(book_transaction_file));
                
                book_transaction_list = (ArrayList<bookTransaction>) ois_book_transaction.readObject();
                
	            } 
            
	            catch (ClassNotFoundException e)
                {
	                e.printStackTrace();
	            } 
            
	            catch (FileNotFoundException e) 
                {
	                e.printStackTrace();
	            } 
            
	            catch (IOException e) 
                {
	                e.printStackTrace();
	            }
	    }
    }
    
    public boolean issueofbook(int rollno, int isbn)
    {
    	
		    	int total_books_issued = 0;
		    	
		    	for(bookTransaction book_transactions :book_transaction_list )
    	        {
    		
			    		if((book_transactions.getRollno() ==rollno) &&( book_transactions.getReturndate() ==null))
			    		{
			    			total_books_issued +=1;
			    			
				    			if(total_books_issued >=3) 
				    			{
				    				return false;
				    			}
				    			
			    			
			    		}
    		
    	      }
		    	String issued_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		    	bookTransaction book_transaction = new bookTransaction(isbn,rollno,issued_date,null);
		    	
		    	book_transaction_list.add(book_transaction);
		    	return true;
    	
        	
        	
    }
    public void writetofile()
    {
    	try {
			oos_book_transaction = new ObjectOutputStream(new FileOutputStream(book_transaction_file));
			oos_book_transaction.writeObject(book_transaction_list);
		} 
    	catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
    	catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    
    public boolean returnbook(int rollno , int isbn) {
    	
    	for(bookTransaction book_transactions :book_transaction_list )
    	{
    		if((book_transactions.getRollno() ==rollno) &&(book_transactions.getIsbn()==isbn)&&(book_transactions.getReturndate() ==null))
    		{
    			String returned_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    			book_transactions.setReturndate(returned_date);
    			return true;
    		}
    	}
    	
    	return false;
    	
    }
    
    public void showall()
    {
    	for(bookTransaction book_transactions :book_transaction_list )
    	{
    		System.out.println(book_transactions);
    	}
    }
    

    
    
}

