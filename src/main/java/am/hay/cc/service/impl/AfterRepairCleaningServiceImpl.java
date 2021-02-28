package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.AfterRepairCleaning;
import am.hay.cc.model.WindowCleaning;
import am.hay.cc.repository.AfterRepairCleaningRepository;
import am.hay.cc.repository.WindowCleaningRepository;
import am.hay.cc.service.AfterRepairCleaningService;
import am.hay.cc.service.WindowCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfterRepairCleaningServiceImpl implements AfterRepairCleaningService {

    private final AfterRepairCleaningRepository afterRepairCleaningRepository;

    @Autowired
    public AfterRepairCleaningServiceImpl(final AfterRepairCleaningRepository afterRepairCleaningRepository) {
        this.afterRepairCleaningRepository = afterRepairCleaningRepository;
    }

    @Override
    public List<AfterRepairCleaning> findAll() {
        return afterRepairCleaningRepository.findAll();
    }

    @Override
    public AfterRepairCleaning save(final AfterRepairCleaning afterRepairCleaning) {
        return Optional.of(afterRepairCleaningRepository.save(afterRepairCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public AfterRepairCleaning updateById(final AfterRepairCleaning afterRepairCleaning, final String id) {
        return afterRepairCleaningRepository.findById(id).
                map(existingData -> {
                    afterRepairCleaning.setId(existingData.getId());
                    existingData = afterRepairCleaning;
                    return afterRepairCleaningRepository.save(existingData);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            afterRepairCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public AfterRepairCleaning findById(final String id) {
        return afterRepairCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
