package in.trelic.spring_monolith_arch.controller;

import in.trelic.spring_monolith_arch.interfaces.IQuizService;
import in.trelic.spring_monolith_arch.model.CategoryEnum;
import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.request.QuestionRequestWrapperDto;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("quiz")
public class QuizController {
    private final IQuizService quizService;

    @Autowired
    public QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@RequestParam String category) {
        try {
            CategoryEnum categoryEnum = CategoryEnum.valueOf(category.toUpperCase());

            return new ResponseEntity<>(this.quizService.getQuestionsByCategory(categoryEnum), HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
