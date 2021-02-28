package am.hay.cc.repository;

import am.hay.cc.model.AfterRepairCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfterRepairCleaningRepository extends MongoRepository<AfterRepairCleaning, String> {
}
