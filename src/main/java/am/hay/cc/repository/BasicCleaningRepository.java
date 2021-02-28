package am.hay.cc.repository;

import am.hay.cc.model.BasicCleaning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicCleaningRepository extends MongoRepository<BasicCleaning, String> {
}
