package service;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import entity.StudentEntity;
import exception.OurRuntimeException;
import repository.StudentRepository;
import response.StudentResponseModel;

	@Service
public class StudentService {

	

	


		
		@Autowired
		private StudentRepository repository;
		
		@Autowired
		private SecurityService securityService;
		
		public void add(StudentEntity p, BindingResult br) {
			
			if (br.hasErrors()) {
				throw new OurRuntimeException("Melumatlarin tamligi pozulub", br);
	 
			} 
			p.setId(null);  
			p.setOwner(securityService.findUser());
			p.setRegister(LocalDateTime.now());
			repository.save(p);
		}


		public StudentResponseModel findAllByOwner() {
			
			StudentResponseModel res=new StudentResponseModel(); 
			 
			res.setStudents(repository.findAllByOwner(securityService.findUser()));
			res.setNow(LocalDateTime.now());
			return res;
		}
		public StudentEntity findById(Integer id) {
			Optional<StudentEntity> finded = repository.findById(id);

			if (finded.isPresent()) {
				return finded.get();

			} else {
				 
				throw new OurRuntimeException("id tapilmadi, id = " + id, null);
			}
		}
		
		
		public void checkIfUserHasAuthorityForDelete(StudentEntity p) {
			if(securityService.checkIfUserHasAuthorityForThisOperation(p) ){
				repository.deleteById(p.getId());
			}
		}


		public void deleteById(Integer id) {
			StudentEntity findById = findById(id);
			checkIfUserHasAuthorityForDelete(findById);
		}
		public void update(StudentEntity p, BindingResult br) {
			
			if (br.hasErrors()) {
				throw new OurRuntimeException("Melumatlarin tamligi pozulub", br);
	 
			}  
			if (p.getId() == null || p.getId() < 1) {
				throw new OurRuntimeException("id bos ve ya olmayan ola bilmez", null);
			} 
			Optional<StudentEntity> finded = repository.findById(p.getId());

			if (finded.isPresent()) {
	 
				p.setOwner(securityService.findUser());
				repository.save(p);
			} else {
				throw new OurRuntimeException("id tapimadi ve redakte etmek olmaz", null);
			}
			  
		}


	
		
	}

	


