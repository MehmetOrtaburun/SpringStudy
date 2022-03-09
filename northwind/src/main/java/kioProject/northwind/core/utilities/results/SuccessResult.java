package kioProject.northwind.core.utilities.results;

public class SuccessResult extends Result {

	// sadece başarılı bilgisi döner
	public SuccessResult(boolean success) {
		super(true);
		
	}
	
	// başarılı bilgisi ve mesaj döner
	public SuccessResult(String message) {
		super(true,message);
		
	}

}
