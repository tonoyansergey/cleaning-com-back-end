package am.hay.cc.repository;

import am.hay.cc.model.HomeCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeCleaningRepository extends MongoRepository<HomeCleaning, String> {
}
