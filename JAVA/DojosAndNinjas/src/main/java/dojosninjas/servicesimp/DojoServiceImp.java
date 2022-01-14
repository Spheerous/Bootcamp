package dojosninjas.servicesimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dojosninjas.models.Dojo;
import dojosninjas.repository.DojoRepository;
import dojosninjas.services.DojoServices;
@Service
public class DojoServiceImp implements DojoServices {
	
	@Autowired
	private DojoRepository dojoRepo;
	@Override
	public List<Dojo> dojoList(){
		return(List<Dojo>) dojoRepo.findAll();
	}
	@Override
	public Dojo findDojo(long id ) {
		Optional<Dojo> otp = dojoRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		else {
			return null;
		}
	}
	@Override
	@Transactional
	public Dojo createDojo(Dojo dojo) throws Exception {
		try {
			Dojo d = dojoRepo.save(dojo);
			return d;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}

}
