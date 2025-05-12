package in.trelic.spring_monolith_arch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionDto {
    private int questionId;
    private String question;
    private List<String> answers;
    private String rightAnswer;
    private CategoryEnum category;

    public QuestionDto(Question question, CategoryEnum category) {
        this.questionId = question.getqId();
        this.question = question.getQuestion();
        this.answers = extractAnswers(question);
        this.rightAnswer = extractRightAnswer(question);
        this.category = category;
    }

    private List<String> extractAnswers(Question question) {
        List<String> answers = new ArrayList<>(4);
        answers.add(question.getAnswer().getAnswer1());
        answers.add(question.getAnswer().getAnswer2());
        answers.add(question.getAnswer().getAnswer3());
        answers.add(question.getAnswer().getAnswer4());

        return answers;
    }

    private String extractRightAnswer(Question question) {
        return this.answers.get(question.getAnswer().getRightAnswer() - 1);
    }
}
