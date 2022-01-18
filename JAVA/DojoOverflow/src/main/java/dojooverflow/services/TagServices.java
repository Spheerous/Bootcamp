package dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dojooverflow.models.Tag;

@Service
public interface TagServices {

	List<Tag> tagList();

	Tag findTag(long id);

	Tag create(Tag tag) throws Exception;

	Tag addQuestion(long tagId, long questionId);
	
	Tag findTagBySubject(String tag);
	
	Tag findByTagsContaining();

}
