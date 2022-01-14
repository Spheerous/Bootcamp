package dojosninjas.servicesimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dojosninjas.models.Dojo;
import dojosninjas.models.Ninja;
import dojosninjas.repository.NinjaRepository;
import dojosninjas.services.DojoServices;
import dojosninjas.services.NinjaServices;
@Service
public class NinjaServiceImp implements NinjaServices {
	@Autowired
	private NinjaRepository ninjaRepo;
	@Autowired  
	private DojoServices dojoservice;
	@Override
	public List<Ninja> ninjaList() {
		return(List<Ninja>) ninjaRepo.findAll();
	}
	@Override
	public List<Ninja> ninjasbyDojo(long id){
		Dojo dojo = dojoservice.findDojo(id);
		List<Ninja> ninjas = ninjaRepo.findByDojo(dojo);
		return ninjas;
	}
	@Override
	public Ninja findNinja(long id) {
		Optional<Ninja> otp = ninjaRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Ninja createNinja(Ninja ninja) throws Exception {
		try {
			Ninja n = ninjaRepo.save(ninja);
			return n;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
			
		}
	}
}
