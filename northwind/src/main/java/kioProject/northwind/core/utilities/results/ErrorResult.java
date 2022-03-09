package kioProject.northwind.core.utilities.results;

public class ErrorResult extends Result {

	// sadece hatalı bilgisi döner
	public ErrorResult(boolean success) {
		super(false);
		
	}
	
	// hatalı bilgisi ve mesaj döner
	public ErrorResult(String message) {
		super(false,message);
		
	}

}
