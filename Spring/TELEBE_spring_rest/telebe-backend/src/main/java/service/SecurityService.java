package service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import entity.StudentEntity;
import exception.OurRuntimeException;

@Service
public class SecurityService {

	public boolean checkIfUserHasAuthorityForThisOperation(StudentEntity p) {
		 
		String studentOwner=p.getOwner();
		 
		if (studentOwner.equals(findUser())) { 
			return true;
		} else {
			throw new OurRuntimeException("basqa marketin mehsulunu silmek olmaz", null);
		}
	}
	
	public String findUser() {
		String realUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		return realUsername;
	}
}



