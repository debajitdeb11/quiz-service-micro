package in.trelic.spring_monolith_arch.repository;

import in.trelic.spring_monolith_arch.model.Question;
import in.trelic.spring_monolith_arch.model.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
