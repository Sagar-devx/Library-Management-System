package pkg_main;

import java.util.Scanner;
import pkg_book.BookManager;
import pkg_book.book;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.student;
import pkg_person.studentmanager;
import pkg_transaction.bookTransactionManager;

public class main {

	public static void main (String[] args)
	{
				int choice;
				Scanner sc = new Scanner(System.in);
				
				BookManager bm = new BookManager();
				studentmanager sm = new studentmanager();
				bookTransactionManager btm = new bookTransactionManager();
				
		do 
		{
				System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to exit:");
				choice = sc.nextInt();
				
				if(choice==1)   // if user is student
				{
						System.out.println("Enter your Rollno");
						int rollno = sc.nextInt();
				
				
						try 
						{
							student s = sm.get(rollno);
							
								if(s==null) 
									throw new StudentNotFoundException();
								
							    int student_choice;
							    
							    do
							    {                                                                                                                                                                                                                                      
							    	System.out.println("Enter 1 to view all Books \nEnter 2 to Search Books by ISBN \nEnter 3 to list Books by Subject\nEnter 4 to Issue a book\nEnter 5 to Return a Book\nEnter 99 to exit");
							    	student_choice = sc.nextInt();
							    	
							    	switch(student_choice)
							    	{
							    	case 1:
										    	 System.out.println("All the Book Records are");
										    	 bm.viewallbooks();
										    	 break;
							    	  
							    	case 2:
									    		System.out.println("Please Enter ISBN to Search");
									    		 int search_isbn;
											    	
								    	            System.out.println("Enter ISBN of the Book to Search");
								    	            search_isbn = sc.nextInt();
								    	            
								    	            book book =  bm.searchbookbyisbn(search_isbn);
								    	            
								    	            if(book==null)					    	    
								    	        	 System.out.println("No Book with this ISBN Exists in our library");  					    	           
								    	           else
								    	        	   System.out.println(book);
									    		 
									    		break;
							    		
							    	case 3:
							    	         	System.out.println("Enter the Subject to Search");
							    	         	sc.nextLine();
							    	         	String search_subject= sc.nextLine();
							    	         	bm.listbooksbysubject(search_subject);
							    	         	break;
							    	         	
							    	   
							    	case 4:   
										    	    System.out.println("Enter ISBN to issue a Book");
										    	    int issue_isbn = sc.nextInt();
			
										    	    book = bm.searchbookbyisbn(issue_isbn);
			
										    	    try 
										    	    {
										    	        if (book == null) 
										    	        {
										    	            throw new BookNotFoundException();
										    	        }
			
										    	        int quantity = Integer.parseInt(book.getAvailable_quantity());
			
										    	        if (quantity > 0) 
										    	        {
											    	            if (btm.issueofbook(rollno, issue_isbn))
											    	            {
											    	                quantity--;
											    	                book.setAvailable_quantity(String.valueOf(quantity));
											    	                System.out.println("Book has been issued.");
											    	            } 
											    	            else
											    	            {
											    	                System.out.println("You have already issued 3 books.");
											    	            }
										    	        } else {
										    	            System.out.println("Book is out of stock.");
										    	        }
			
										    	    }
										    	    catch (BookNotFoundException e)
										    	    {
										    	        System.out.println(e);
										    	    }
										    	    catch (NumberFormatException e)
										    	    {
										    	        System.out.println("Invalid quantity format.");
										    	    }
			
										    	    break;

							    		       
							    	
							    	case 5:
									    	    System.out.println("Please Enter the ISBN to Return a Book");
									    	    
									    	    int return_isbn = sc.nextInt();
		
									    	    book = bm.searchbookbyisbn(return_isbn);
		
									    	    if (book != null)
									    	    {
										    	        if (btm.returnbook(rollno, return_isbn))
										    	        {
										    	           
										    	            int quantity = Integer.parseInt(book.getAvailable_quantity());
										    	            quantity++;
										    	            book.setAvailable_quantity(String.valueOf(quantity));
			
										    	            System.out.println("Thank You for Returning the Book");
										    	        } 
										    	        else 
										    	        {
										    	            System.out.println("Could Not Return the Book");
										    	        }
									    	    } 
									    	    else
									    	    {
									    	        System.out.println("Book with this ISBN Does not Exist");
									    	    }
									    	    break;
		
							    		      
							    	case 99:
								    		    System.out.println("Thank you for using Libtary ");
								    		    break;
							    		    
							    	default:
							    		        System.out.println("Invalid Choice ! ");
							    	}
							    	
							    	
							    	
							    	
							    }while(student_choice != 99);
							    
						}
						catch(StudentNotFoundException ex)
						{
							System.out.println(ex);
						}
				
			}
				else if(choice == 2)
				{        int lib_choice;
					do {
					
					System.out.println("Enter 11 to view all Students\nEnter 12 to print a student by Roll number\nEnter 13 to Register a Student\nEnter 14 to update a Student\nEnter 15 to Delete a student");
					System.out.println("Enter 21 to view all Books\nEnter 22 to print a Book by ISBN\nEnter 23 to Add a New Book\nEnter 24 to Update a Book\nEnter 25 to Delete a Book");
					System.out.println("Enter 31 to view all Transactions");
					System.out.println("Enter 99 to Exit");
					
					lib_choice = sc.nextInt();
			    	
			    	switch(lib_choice)
			    	{
						    	case 11:
									    	 System.out.println("All the Student Records :");
									    	 sm.viewallstudents();
									    	 break;
						    	  
						    	case 12:
								    		System.out.println("Enter Roll no to fetch Student Records");
								    		int get_Rollno = sc.nextInt();
								    		student student = sm.get(get_Rollno);
								    		
								    		if(student == null)
								    		{
								    			System.out.println("No Record Matches this Roll Number");
								    		}
								    		else		    		
								    		  System.out.println(student);
								    		break;
								    		
								    		   
						    	case 13:
						    	         	System.out.println("Enter Students details to Add");
						    	         	
						    	         	String name;
						    	         	String emailid;
						    	         	String phonenumber;
						    	         	String address;
						    	         	String dob;
						    	         	int rollno;
						    	         	int std;
						    	         	String division;
						    	         	
						    	         	sc.nextLine();
						    	         	
						    	         	System.out.println("Name");
						    	         	name = sc.nextLine();
			
						    	         	System.out.println("EmailId");
						    	         	emailid = sc.nextLine();
			
						    	         	System.out.println("Phone Number");
						    	         	phonenumber = sc.nextLine();
			
						    	         	System.out.println("Address");
						    	         	address = sc.nextLine();
			
						    	         	System.out.println("Date of Birth");
						    	         	dob = sc.nextLine();
			
						    	         	System.out.println("Roll Number as Integer");
						    	         	rollno = sc.nextInt();
			
						    	         	System.out.println("Standard as Integer");
						    	         	std = sc.nextInt();
						    	         	
						    	         	sc.nextLine();
						    	         	
						    	         	System.out.println("Division");
						    	         	division = sc.nextLine();
			
						    	         	student = new student(name,  emailid, phonenumber,  address,  dob, rollno, std, division);
						    	         	sm.addstudent(student);
						    	         	System.out.println("Student is Added");
			 
						    	         	break;
						    	         	
						    	case 14:   
						    		        System.out.println("Enter the Roll Number to Modify the Record");
						    		        
						    		        int modify_rollno;
						    		        
						    		        modify_rollno = sc.nextInt();
						    		        
						    		        student = sm.get(modify_rollno);
						    		        
						    		        try 
						    		        {
						    		        	
							    		        if(student==null)
							    		        	throw new StudentNotFoundException();
							    		        
							    		        System.out.println("Name");
							    	         	name = sc.nextLine();                
				
							    	         	System.out.println("EmailId");
							    	         	emailid = sc.nextLine();
				
							    	         	System.out.println("Phone Number");
							    	         	phonenumber = sc.nextLine();
				
							    	         	System.out.println("Address");
							    	         	address = sc.nextLine();
				
							    	         	System.out.println("Date of Birth");
							    	         	dob = sc.nextLine();
				
				
							    	         	System.out.println("Standard as Integer");
							    	         	std = sc.nextInt();
							    	         	
							    	         	sc.nextLine();
							    	         	
							    	         	System.out.println("Division");
							    	         	division = sc.nextLine();
				
							    	         	sm.updatestudent(modify_rollno, name, emailid, phonenumber, address, division, dob, std);
							    	         	System.out.println("Student Record is Updated");
						    		        }
						    		        
						    		        catch(StudentNotFoundException er)
						    		        {
						    		        	System.out.println(er);
						    		        }
						    		        break;
						    	
						    		       
						    	case 15:
						    		        System.out.println("Enter the Roll number to Delete a Student");
						    		        int delete_rollno;
						    		        delete_rollno = sc.nextInt();
						    		        
						    		        if(sm.deletestudent(delete_rollno))
						    		        {
						    		        	System.out.println("Stundent Record is Removed");
						    		        }
						    		        else
						    		        {
						    		        	System.out.println("No Record with Given Roll number Exist");
						    		        }		    		    	    		         
						    		        break;
						    		        
						    		        
						    	case 21:   bm.viewallbooks();
						    	           break;
						    	           
						    	           
						    	           
						    	case 22 : int search_isbn;
						    	
						    	          System.out.println("Enter ISBN of the Book to Search");
						    	          search_isbn = sc.nextInt();
						    	           book book =  bm.searchbookbyisbn(search_isbn);
						    	           if(book==null)					    	    
						    	        	 System.out.println("No Book with this ISBN Exists in our library");  					    	           
						    	           else
						    	        	   System.out.println(book);
						    	           
						    	           break;
						    	           
						    	           
						    	           
						    	case 23: // Add a Book
						    		
								    	    System.out.println("Please Enter Book Details to Add");
		
								    	    int isbn;
								    	    String title;
								    	    String author;
								    	    String publisher;
								    	    int edition;
								    	    String subject;
								    	    String available_quantity;
		
								    	    System.out.println("ISBN");
								    	    isbn = sc.nextInt();
		
								    	    sc.nextLine(); // Consume the newline
		
								    	    System.out.println("Author");
								    	    author = sc.nextLine();
								    	   
								    	    System.out.println("Publisher");
								    	    publisher = sc.nextLine();
								    	    
								    	    System.out.println("Title");
								    	    title = sc.nextLine();
								    	    
								    	    System.out.println("Subject");
								    	    subject= sc.nextLine();
								    	    
								    	    System.out.println("Edition");
								    	    edition = sc.nextInt();
								    	    
								    	    sc.nextLine();
								    	    
								    	    System.out.println("Available Quantity");
								    	    available_quantity = sc.nextLine();
								    	    
								    	    book = new book(isbn,title,author,publisher,edition,subject,available_quantity);
								    	    bm.addbook(book);
								    	    
								    	    System.out.println("A book Recoed is Added ");
								    	    break;
								    	    
						    	case 24:  System.out.println("Please Enter the ISBN to update the Record");
						    	           int update_isbn;
						    	            
						    	            update_isbn = sc.nextInt();
						    	            try
						    	            {
						    	            	book = bm.searchbookbyisbn(update_isbn);
						    	            	if(book==null) 	            	
						    	            		throw new BookNotFoundException();
						    	            	
						    	            	System.out.println("Emter Book Detais to modify :");
						    	            	
						    	                 	   sc.nextLine();
						    	            	
										    	    System.out.println("Author");
										    	    author = sc.nextLine();
										    	   
										    	    System.out.println("Publisher");
										    	    publisher = sc.nextLine();
										    	    
										    	    System.out.println("Title");
										    	    title = sc.nextLine();
										    	    
										    	    System.out.println("Subject");
										    	    subject= sc.nextLine();
										    	    
										    	    System.out.println("Edition");
										    	    edition = sc.nextInt();
										    	    
										    	    sc.nextLine();
										    	    
										    	    System.out.println("Available Quantity");
										    	    available_quantity = sc.nextLine();
						    	            	
										    	    bm.updatebook(update_isbn, title, author, publisher, edition, subject, available_quantity);
						    	            	
										    	    System.out.println("Book Updated Sucessfully");
						    	            }
						    	            catch( BookNotFoundException r)
						    	            {
						    	            	System.out.println(r);
						    	            }					    	           
						    		        break;
						    	
								    	    
								    	    
						    	case 25:   System.out.println("Please Enter the ISBN to Delete the Record");
						    	           int delete_isbn;
						    	            
						    	            delete_isbn = sc.nextInt();
						    	            
						    	            try {
						    	            	book = bm.searchbookbyisbn(delete_isbn);
						    	            	if(book == null)
						    	            		throw new  BookNotFoundException();
						    	            	
						    	            	bm.deletebook(delete_isbn);
						    	            	System.out.println("Book Deleted Successfully");
						    	            }
						    	            catch( BookNotFoundException r)
						    	            {
						    	            	System.out.println(r);
						    	            }		
						    		        break;
						    		        
						    	case 31:   System.out.println("All the Transactions are :");
						    		        btm.showall();	        
						    		        break;
						    		        
						    		        
						    	case 99:
							    		    System.out.println("Thank you for Using Library");
							    		    break;
						    		    
						    	default:
						    		        System.out.println("Invalid Choice ! ");
			    	}
			    	
					}while(lib_choice!=99);
			    	

				}
				
			
		  }while(choice != 3);
		   sm.writeToFile();
		   bm.writetofile();
		   btm.writetofile();
		   sc.close();
		
		
	
	}

}





                   






















