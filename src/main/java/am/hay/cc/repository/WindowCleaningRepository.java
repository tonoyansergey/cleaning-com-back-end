package am.hay.cc.repository;

import am.hay.cc.model.WindowCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindowCleaningRepository extends MongoRepository<WindowCleaning, String> {
}
