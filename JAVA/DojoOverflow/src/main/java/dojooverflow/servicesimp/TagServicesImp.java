package dojooverflow.servicesimp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import dojooverflow.models.Question;
import dojooverflow.models.Tag;
import dojooverflow.repositories.TagRepository;
import dojooverflow.services.QuestionServices;
import dojooverflow.services.TagServices;

@Service
public class TagServicesImp  implements TagServices{
	@Autowired
	@Lazy
	private  QuestionServices questService;
	@Autowired
	private  TagRepository tagRepo;
	
	
	
	@Override
	public List<Tag> tagList() {
		return(List<Tag>) tagRepo.findAll();
	}
	
	@Override
	public Tag findTagBySubject(String tag) {
		Optional<Tag> tagOpt = tagRepo.findBySubject(tag);
		if(tagOpt.isPresent()) {
			return tagOpt.get();
		}
		return null;
	}
	@Override
	@Transactional
	public Tag findTag(long id ) {
		Optional<Tag> otp = tagRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
		
	}
	@Override
	@Transactional
	public Tag create(Tag tag) throws Exception {
		try {
			Tag t = tagRepo.save(tag);
			return t;
		} catch (Exception b) {
			b.printStackTrace();
			throw b;
			
		}
		
	}
	@Override
	@Transactional
	public Tag addQuestion(long tagId, long questionId) {
		Tag tag = findTag(tagId);
		Question question = questService.findQuestion(questionId);
		tag.getQuestions().add(question);
		return tagRepo.save(tag);
	}

	@Override
	public Tag findByTagsContaining() {
		
		return null;
	}
	
	
}
