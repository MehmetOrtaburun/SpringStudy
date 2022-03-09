package kioProject.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	// data ve mesaj döner 
	public SuccessDataResult(T data,String message) {
		super(data,true, message);
		
	}
	
	// sadece data döner
	public SuccessDataResult(T data) {
		super(data,true);
		
	}
	
	// sadece mesaj döner
	public SuccessDataResult(String message) {
		super(null,true,message);
	}
	
	// sadece başarılı döner
	public SuccessDataResult() {
		super(null,true);
	}
	
	

}
