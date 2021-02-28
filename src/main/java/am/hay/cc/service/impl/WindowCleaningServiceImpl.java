package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.WindowCleaning;
import am.hay.cc.repository.WindowCleaningRepository;
import am.hay.cc.service.WindowCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WindowCleaningServiceImpl implements WindowCleaningService {

    private final WindowCleaningRepository windowCleaningRepository;

    @Autowired
    public WindowCleaningServiceImpl(final WindowCleaningRepository windowCleaningRepository) {
        this.windowCleaningRepository = windowCleaningRepository;
    }

    @Override
    public List<WindowCleaning> findAll() {
        return windowCleaningRepository.findAll();
    }

    @Override
    public WindowCleaning save(final WindowCleaning windowCleaning) {
        return Optional.of(windowCleaningRepository.save(windowCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public WindowCleaning updateById(final WindowCleaning windowCleaning, final String id) {
        return windowCleaningRepository.findById(id).
                map(existingUser -> {
                    windowCleaning.setId(existingUser.getId());
                    existingUser = windowCleaning;
                    return windowCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            windowCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public WindowCleaning findById(final String id) {
        return windowCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
