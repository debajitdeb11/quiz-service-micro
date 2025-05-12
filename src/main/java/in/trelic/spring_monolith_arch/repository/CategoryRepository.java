package in.trelic.spring_monolith_arch.repository;

import in.trelic.spring_monolith_arch.model.QuizCategory;
import in.trelic.spring_monolith_arch.model.QuizCategoryComposite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<QuizCategory, QuizCategoryComposite> {
    @Query("select q.category from QuizCategory q where q.qId=?1")
    String findCategoryByQuizId(int qId);
    @Query("select q.qId from QuizCategory q where q.category like ?1")
    List<Integer> getQuizIdByCategory(String category);
}
