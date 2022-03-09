package kioProject.northwind.core.utilities.results;

import lombok.Getter;

/* Data Result da bir Result old. extends ile alınır.
 * Birden fazla veritipi ile çalıştığımızda generic yapı ile çalışırız T eklenecek
 * */
 
public class DataResult<T> extends Result{

	@Getter
	private T data;
	public DataResult(T data,boolean success,String message) {
		super(success,message); 
		this.data=data;
		
	}
	
	
	public DataResult(T data,boolean success) {
		super(success); 
		this.data=data;
		
	}
	
	 

}
