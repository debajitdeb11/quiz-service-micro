package in.trelic.spring_monolith_arch.controller;

import in.trelic.spring_monolith_arch.interfaces.IQuestionService;
import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.QuestionDto;
import in.trelic.spring_monolith_arch.model.request.QuestionRequestWrapperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    private final IQuestionService questionService;

    @Autowired
    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("questions")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        List<QuestionDto> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<List<QuestionRequestWrapperDto>> createQuizQnA(@RequestBody List<QuestionRequestWrapperDto> questions) {
        List<QuestionRequestWrapperDto> responseList = this.questionService.createQnA(questions);

        return new ResponseEntity<>(responseList, HttpStatus.CREATED);
    }
}
