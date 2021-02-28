package am.hay.cc.repository;

import am.hay.cc.model.QuestionAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswer, String> {

    List<QuestionAnswer> findAll();
}
