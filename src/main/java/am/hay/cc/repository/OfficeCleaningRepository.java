package am.hay.cc.repository;

import am.hay.cc.model.OfficeCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeCleaningRepository extends MongoRepository<OfficeCleaning, String> {
}
