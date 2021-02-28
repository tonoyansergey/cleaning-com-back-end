package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.GeneralCleaning;
import am.hay.cc.repository.GeneralCleaningRepository;
import am.hay.cc.service.GeneralCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralCleaningServiceImpl implements GeneralCleaningService {

    private final GeneralCleaningRepository generalCleaningRepository;

    @Autowired
    public GeneralCleaningServiceImpl(final GeneralCleaningRepository generalCleaningRepository) {
        this.generalCleaningRepository = generalCleaningRepository;
    }

    @Override
    public List<GeneralCleaning> findAll() {
        return generalCleaningRepository.findAll();
    }

    @Override
    public GeneralCleaning save(final GeneralCleaning generalCleaning) {
        return Optional.of(generalCleaningRepository.save(generalCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public GeneralCleaning updateById(final GeneralCleaning generalCleaning, final String id) {
        return generalCleaningRepository.findById(id).
                map(existingUser -> {
                    generalCleaning.setId(existingUser.getId());
                    existingUser = generalCleaning;
                    return generalCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            generalCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public GeneralCleaning findById(final String id) {
        return generalCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
