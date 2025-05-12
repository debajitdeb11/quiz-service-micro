package in.trelic.spring_monolith_arch.interfaces;

import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.QuestionDto;
import in.trelic.spring_monolith_arch.model.request.QuestionRequestWrapperDto;

import java.util.List;

public interface IQuestionService {
    List<QuestionDto> getAllQuestions();
    List<QuestionRequestWrapperDto> createQnA(List<QuestionRequestWrapperDto> questionList);
}
