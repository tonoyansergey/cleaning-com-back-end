package am.hay.cc.repository;

import am.hay.cc.model.Benefit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BenefitRepository extends MongoRepository<Benefit, String> {

    List<Benefit> findAll();
}
