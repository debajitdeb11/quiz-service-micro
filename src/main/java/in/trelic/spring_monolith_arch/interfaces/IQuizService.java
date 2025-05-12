package in.trelic.spring_monolith_arch.interfaces;

import in.trelic.spring_monolith_arch.model.CategoryEnum;
import in.trelic.spring_monolith_arch.model.Question;

import java.util.List;

public interface IQuizService {
    List<Question> getQuestionsByCategory(CategoryEnum categoryEnum);
}
