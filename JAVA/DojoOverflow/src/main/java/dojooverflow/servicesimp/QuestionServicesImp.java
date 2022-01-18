package dojooverflow.servicesimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import dojooverflow.models.Question;
import dojooverflow.models.Tag;
import dojooverflow.repositories.QuestionRepository;
import dojooverflow.services.QuestionServices;
import dojooverflow.services.TagServices;

@Service
public class QuestionServicesImp implements QuestionServices {
	
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	@Lazy
	private  TagServices tagService;
	

	@Override
	public List<Question> questionList(){
		return(List<Question>) questionRepo.findAll();
	}
	@Override
	@Transactional
	public Question findQuestion(long id) {
		Optional<Question> otp = questionRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Question create(Question question) throws Exception { 
		try {
			if(question.getTag() != null) {
//				1.- Separar los tags por ","
				String[] tags = question.getTag().split(",");
//				2.- Si son mas de 3 tags enviar error
				if(tags.length > 3) {
					throw new Exception("Pueden ser hasta 3 tags como maximo");
				}
				question.setTags(new ArrayList<Tag>());
				for(String tag: tags) {
//				3.- Si el tag existe asociarlo
					Tag t = tagService.findTagBySubject(tag);
					if(t!=null) {
						question.getTags().add(t);
					} else {
//				4.- Si no existe crearlo y luego asociarlo
						t = new Tag();
						t.setSubject(tag);
						t = tagService.create(t);
						question.getTags().add(t);
					}
				}
				
				Question quest = questionRepo.save(question);
				return quest;
			} else {
				throw new Exception("Los tags son obligatorios");
			}
		}catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}
	@Override
	@Transactional
	public Question addTag(long questionId, long tagId) {
		Question question = findQuestion(questionId);
		Tag tag = tagService.findTag(tagId);
		question.getTags().add(tag);
		return questionRepo.save(question);
	}

}
