package dojooverflow.servicesimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dojooverflow.models.Answer;
import dojooverflow.repositories.AnswerRepository;
import dojooverflow.services.AnswerServices;

@Service
public class AnswerServicesImp implements AnswerServices{
	private final AnswerRepository ansRepo;
	
	AnswerServicesImp(AnswerRepository ansRepo){
		this.ansRepo = ansRepo;
	}
	@Override
	public List<Answer> listaAnswers() {
		return(List<Answer>)ansRepo.findAll();
	}
	@Override
	@Transactional
	public Answer findAnswer(long id) {
		Optional<Answer> otp = ansRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Answer create(Answer answer) throws Exception {
		try {
			Answer ans = ansRepo.save(answer);
			return ans;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}
}
