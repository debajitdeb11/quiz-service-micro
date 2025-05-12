package in.trelic.spring_monolith_arch.model;

import java.io.Serializable;

public class QuizCategoryComposite implements Serializable {
    private int qId;
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
