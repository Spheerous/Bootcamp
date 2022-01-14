package studentlist.servicesimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentlist.models.Info;
import studentlist.repository.InfoRepository;
import studentlist.services.InfoServices;

@Service
public class InfoServicesimp implements InfoServices{
	
	@Autowired
	private InfoRepository infoRepo;
	
	@Override
	public List<Info> infoList() {
		return (List<Info>) infoRepo.findAll();
	}
	@Override
	public Info findInfo(long id) {
		Optional <Info> otp = infoRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Info createInfo(Info info) throws Exception {
		try {
			Info in = infoRepo.save(info);
			return in;
		} catch (Exception b) {
			b.printStackTrace();
			throw b;
		}
		
	}

}
