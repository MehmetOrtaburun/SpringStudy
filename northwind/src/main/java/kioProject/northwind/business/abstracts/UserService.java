package kioProject.northwind.business.abstracts;

import kioProject.northwind.core.entities.User;
import kioProject.northwind.core.utilities.results.DataResult;
import kioProject.northwind.core.utilities.results.Result;


public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
