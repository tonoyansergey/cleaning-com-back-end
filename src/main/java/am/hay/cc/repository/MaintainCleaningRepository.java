package am.hay.cc.repository;

import am.hay.cc.model.MaintainCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainCleaningRepository extends MongoRepository<MaintainCleaning, String> {
}
