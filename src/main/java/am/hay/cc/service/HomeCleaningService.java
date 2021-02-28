package am.hay.cc.service;

import am.hay.cc.model.HomeCleaning;
import am.hay.cc.model.ServiceType;

import java.util.List;

public interface HomeCleaningService {

    List<HomeCleaning> findAll();

    HomeCleaning save(final HomeCleaning homeCleaning);

    HomeCleaning updateById(final HomeCleaning homeCleaning, final String id);

    boolean deleteByID(final String id);

    HomeCleaning findById(final String id);
}
