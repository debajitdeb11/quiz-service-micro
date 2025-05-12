package in.trelic.spring_monolith_arch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_category")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(QuizCategoryComposite.class)
public class QuizCategory {
    @Id
    @Column(name = "qid")
    private int qId;
    @Id
    @Column(name = "category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }
}
