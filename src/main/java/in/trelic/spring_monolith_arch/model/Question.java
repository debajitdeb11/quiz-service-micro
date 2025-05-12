package in.trelic.spring_monolith_arch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz_questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "quiz_question_seq", sequenceName = "quiz_question_seq", allocationSize = 50)
    @Column(name = "qid")
    private int qId;
    @Column(name = "question", nullable = false)
    private String question;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "aid",
            referencedColumnName = "aid",
            foreignKey = @ForeignKey(name = "fk_question_answer")
    )
    private Answer answer;

    public int getqId() {
        return qId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
