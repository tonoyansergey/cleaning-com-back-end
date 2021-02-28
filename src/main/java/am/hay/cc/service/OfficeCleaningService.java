package am.hay.cc.service;

import am.hay.cc.model.OfficeCleaning;

import java.util.List;

public interface OfficeCleaningService {

    List<OfficeCleaning> findAll();

    OfficeCleaning save(final OfficeCleaning officeCleaning);

    OfficeCleaning updateById(final OfficeCleaning officeCleaning, final String id);

    boolean deleteByID(final String id);

    OfficeCleaning findById(final String id);
}
