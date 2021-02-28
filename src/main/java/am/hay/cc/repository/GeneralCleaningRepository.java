package am.hay.cc.repository;

import am.hay.cc.model.GeneralCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralCleaningRepository extends MongoRepository<GeneralCleaning, String> {
}
