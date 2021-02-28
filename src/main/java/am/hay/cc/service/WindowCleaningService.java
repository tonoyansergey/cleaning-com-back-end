package am.hay.cc.service;

import am.hay.cc.model.WindowCleaning;

import java.util.List;

public interface WindowCleaningService {

    List<WindowCleaning> findAll();

    WindowCleaning save(final WindowCleaning windowCleaning);

    WindowCleaning updateById(final WindowCleaning windowCleaning, final String id);

    boolean deleteByID(final String id);

    WindowCleaning findById(final String id);
}
