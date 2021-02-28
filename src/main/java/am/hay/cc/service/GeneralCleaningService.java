package am.hay.cc.service;

import am.hay.cc.model.GeneralCleaning;

import java.util.List;

public interface GeneralCleaningService {

    List<GeneralCleaning> findAll();

    GeneralCleaning save(final GeneralCleaning generalCleaning);

    GeneralCleaning updateById(final GeneralCleaning generalCleaning, final String id);

    boolean deleteByID(final String id);

    GeneralCleaning findById(final String id);
}
