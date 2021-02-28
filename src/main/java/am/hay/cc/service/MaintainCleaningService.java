package am.hay.cc.service;

import am.hay.cc.model.MaintainCleaning;

import java.util.List;

public interface MaintainCleaningService {

    List<MaintainCleaning> findAll();

    MaintainCleaning save(final MaintainCleaning maintainCleaning);

    MaintainCleaning updateById(final MaintainCleaning maintainCleaning, final String id);

    boolean deleteByID(final String id);

    MaintainCleaning findById(final String id);
}
