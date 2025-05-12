package in.trelic.spring_monolith_arch.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "quiz_answers")
public class Answer {
    @Id
    @Column(name = "aid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int aId;
    @Column(name = "answer1", nullable = false)
    private String answer1;
    @Column(name = "answer2", nullable = false)
    private String answer2;
    @Column(name = "answer3", nullable = false)
    private String answer3;
    @Column(name = "answer4", nullable = false)
    private String answer4;
    @Column(name = "right_answer", nullable = false)
    @Check(constraints = "right_answer BETWEEN 1 AND 4")
    private int rightAnswer;
    public int getRightAnswer() {
        return rightAnswer;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }
}
