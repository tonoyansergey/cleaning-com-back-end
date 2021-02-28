package am.hay.cc.service;

import am.hay.cc.model.BasicCleaning;

import java.util.List;

public interface BasicCleaningService {


    List<BasicCleaning> findAll();

    BasicCleaning save(final BasicCleaning basicCleaning);

    BasicCleaning updateById(final BasicCleaning basicCleaning, final String id);

    boolean deleteByID(final String id);

    BasicCleaning findById(final String id);
}
