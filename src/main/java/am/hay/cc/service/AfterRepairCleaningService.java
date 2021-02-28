package am.hay.cc.service;

import am.hay.cc.model.AfterRepairCleaning;

import java.util.List;

public interface AfterRepairCleaningService {

    List<AfterRepairCleaning> findAll();

    AfterRepairCleaning save(final AfterRepairCleaning afterRepairCleaning);

    AfterRepairCleaning updateById(final AfterRepairCleaning afterRepairCleaning, final String id);

    boolean deleteByID(final String id);

    AfterRepairCleaning findById(final String id);
}
