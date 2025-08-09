package pkg_exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception{
	
public	StudentNotFoundException() {
	
	super();
	
}

@Override
public String toString() {
	return "StudentNotFoundException is Generated ";
}

}
