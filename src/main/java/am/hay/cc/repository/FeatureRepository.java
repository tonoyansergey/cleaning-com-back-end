package am.hay.cc.repository;

import am.hay.cc.model.Feature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends MongoRepository<Feature, String> {

    List<Feature> findAll();
}
