package pkg_person;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class studentmanager 
{
	
		ObjectOutputStream oos_student = null;
		ObjectInputStream ois_student = null;
		
		File student_file = null;
		
		ArrayList<student> student_list = null;
	
	    @SuppressWarnings("unchecked")
		public studentmanager()
	    
	    {
				student_file = new File("Student.dat");
				
				student_list = new ArrayList<student>();
				
				if(student_file.exists())
				{
			
					         try 
				        	{
						    ois_student = new ObjectInputStream(new FileInputStream(student_file));
						
						
							student_list = (ArrayList<student>) ois_student.readObject();
							
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
	    
	    public void addstudent(student student)
	    {
	    	student_list.add(student);
	    	
	    }
	    
	    public student get(int rollno) 
	    {
	    	for( student student : student_list)
	    	{
	    		if(student.getRollno()==rollno)
		    	{
		    		return student;
		    	}
	    		
	    	}
	    	return null;
	    	
	    }
	    
	    public void viewallstudents()
	    {
	    	for(student student : student_list) 
	    	{  System.out.println(student);
	    		
	    	}
	    }
	    
	    
	    public boolean deletestudent(int delete_rollno)
	    {
	    	ListIterator<student> student_iterator = student_list.listIterator();
	    	
	    	while(student_iterator.hasNext()) 
	    	{
	    		
	    		student student = student_iterator.next();
	    		
	    		if(student.getRollno()==delete_rollno)
	    		{
	    			student_list.remove(student);
	    			return true;
	    		}
	    	}
	    	return false;
	    	
	    	
	    }
	    
	    public boolean updatestudent(int update_rollNo, String name, String emailId, String phoneNumber, String address, String division, String dob, int std)
	    {
				ListIterator<student> student_iterator = student_list.listIterator();
				
				while (student_iterator.hasNext()) 
				{
					student student = student_iterator.next();
					
					if (student.getRollno() == update_rollNo)
						{
						student.setAddress(address);
						student.setDivision(division);
						student.setDob(dob);
						student.setEmailid(emailId);
						student.setName(name);
						student.setPhonenumber(phoneNumber);
						student.setStd(std);
						return true;
						}
				}
				return false;
 	 }
	    
	    public void writeToFile()
	    {
	    	try
	    	{
	    		oos_student = new ObjectOutputStream(new FileOutputStream(student_file)); 
	    		oos_student.writeObject(student_list);
	    	}
	    	catch (IOException e) 
			{
				e.printStackTrace();
			}
	    	
	    }


	    
}
