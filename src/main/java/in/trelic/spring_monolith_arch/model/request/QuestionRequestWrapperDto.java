package in.trelic.spring_monolith_arch.model.request;

import in.trelic.spring_monolith_arch.model.CategoryEnum;
import in.trelic.spring_monolith_arch.model.Question;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestWrapperDto {
    private Question question;
    private CategoryEnum categoryEnum;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
