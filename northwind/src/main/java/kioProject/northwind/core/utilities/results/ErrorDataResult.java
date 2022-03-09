package kioProject.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	// data ve mesaj döner 
	public ErrorDataResult(T data,String message) {
		super(data,false, message);
		
	}
	
	// sadece data döner
	public ErrorDataResult(T data) {
		super(data,false);
		
	}
	
	// sadece mesaj döner
	public ErrorDataResult(String message) {
		super(null,false,message);
	}
	
	// sadece başarılı döner
	public ErrorDataResult() {
		super(null,false);
	}
	
	

}
