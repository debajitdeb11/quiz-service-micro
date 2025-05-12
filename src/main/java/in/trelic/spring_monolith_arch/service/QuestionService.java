package in.trelic.spring_monolith_arch.service;

import in.trelic.spring_monolith_arch.interfaces.IQuestionService;
import in.trelic.spring_monolith_arch.model.CategoryEnum;
import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.QuestionDto;
import in.trelic.spring_monolith_arch.model.QuizCategory;
import in.trelic.spring_monolith_arch.model.request.QuestionRequestWrapperDto;
import in.trelic.spring_monolith_arch.repository.CategoryRepository;
import in.trelic.spring_monolith_arch.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = this.questionRepository.findAll();

        List<QuestionDto> questionDtos = questions.stream().map(question -> {
            String category = this.categoryRepository.findCategoryByQuizId(question.getqId());


            return new QuestionDto(question, CategoryEnum.valueOf(category == null ? "GENERAL" : category));
        }).toList();

        return questionDtos;
    }

    @Override
    public List<QuestionRequestWrapperDto> createQnA(List<QuestionRequestWrapperDto> questionList) {
        Iterator<QuestionRequestWrapperDto> it = questionList.iterator();

        List<QuestionRequestWrapperDto> response = new ArrayList<>();

        while(it.hasNext()) {
            QuestionRequestWrapperDto questionRequestWrapperDto = it.next();
            Question question = questionRepository.save(questionRequestWrapperDto.getQuestion());
            QuizCategory category = new QuizCategory();
            category.setqId(question.getqId());
            category.setCategory(questionRequestWrapperDto.getCategoryEnum().toString());
            QuizCategory ct = categoryRepository.save(category);

            // add to response list
            QuestionRequestWrapperDto responseDto = new QuestionRequestWrapperDto();
            responseDto.setQuestion(question);
            responseDto.setCategoryEnum(CategoryEnum.valueOf(ct.getCategory()));
            response.add(responseDto);
        }

        return response;
    }

    public List<Question> getQuestionsByIds(List<Integer> qIds) {
        return questionRepository.findAllById(qIds);
    }
}
