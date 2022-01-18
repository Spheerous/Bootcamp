package dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dojooverflow.models.Answer;

@Service
public interface AnswerServices {

	List<Answer> listaAnswers();

	Answer findAnswer(long id);

	Answer create(Answer answer) throws Exception;

}
