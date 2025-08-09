package pkg_exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {
	
	public BookNotFoundException() {
		
	}

	@Override
	public String toString() {
		return "BookNotFoundException is Generated";
	}

}
