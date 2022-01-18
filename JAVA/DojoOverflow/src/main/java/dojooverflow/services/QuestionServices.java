package dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dojooverflow.models.Question;

@Service
public interface QuestionServices {

	List<Question> questionList();

	Question findQuestion(long id);

	Question create(Question question) throws Exception;

	Question addTag(long questionId, long tagId);

}
