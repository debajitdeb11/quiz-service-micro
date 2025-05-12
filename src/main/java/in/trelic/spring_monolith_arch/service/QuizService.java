package in.trelic.spring_monolith_arch.service;

import in.trelic.spring_monolith_arch.interfaces.IQuizService;
import in.trelic.spring_monolith_arch.model.CategoryEnum;
import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.QuizCategory;
import in.trelic.spring_monolith_arch.repository.CategoryRepository;
import in.trelic.spring_monolith_arch.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class QuizService implements IQuizService {
    private final CategoryRepository categoryRepository;
    private final QuestionRepository questionRepository;

    public QuizService(CategoryRepository categoryRepository, QuestionRepository questionRepository) {
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestionsByCategory(CategoryEnum categoryEnum) {
        List<Question> response = new ArrayList<>();
        List<Integer> questionIds = categoryRepository.getQuizIdByCategory(categoryEnum.toString());
        response.addAll(this.questionRepository.findAllById(questionIds));

        // Extract all quiz ids in quiz_category database

        if (categoryEnum == CategoryEnum.GENERAL) {
            List<QuizCategory> quizCategories = this.categoryRepository.findAll();
            List<Question> questionList = this.questionRepository.findAll();

            List<Question> generalQuestions = questionList
                    .stream()
                    .filter(
                            question -> !checkIfQuestionIdExistsInCategoryTable(
                                    question.getqId(), quizCategories)).toList();

            response.addAll(generalQuestions);
        }

        return response;
    }

    private boolean checkIfQuestionIdExistsInCategoryTable(Integer questionId, List<QuizCategory> quizCategories) {
        AtomicBoolean isExists = new AtomicBoolean(false);

        quizCategories.stream().parallel().forEach(quizCategory -> {
            if (quizCategory.getqId() == questionId) {
                isExists.set(true);
            }
        });

        return isExists.get();
    }
}
