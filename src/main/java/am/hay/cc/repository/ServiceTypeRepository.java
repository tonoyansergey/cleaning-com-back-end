package am.hay.cc.repository;

import am.hay.cc.model.GeneralCleaning;
import am.hay.cc.model.ServiceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends MongoRepository<ServiceType, String> {

    List<ServiceType> findAll();
}
