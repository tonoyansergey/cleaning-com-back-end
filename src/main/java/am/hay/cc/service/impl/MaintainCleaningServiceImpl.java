package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.MaintainCleaning;
import am.hay.cc.repository.MaintainCleaningRepository;
import am.hay.cc.service.MaintainCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintainCleaningServiceImpl implements MaintainCleaningService {

    private final MaintainCleaningRepository maintainCleaningRepository;

    @Autowired
    public MaintainCleaningServiceImpl(final MaintainCleaningRepository maintainCleaningRepository) {
        this.maintainCleaningRepository = maintainCleaningRepository;
    }

    @Override
    public List<MaintainCleaning> findAll() {
        return maintainCleaningRepository.findAll();
    }

    @Override
    public MaintainCleaning save(final MaintainCleaning maintainCleaning) {
        return Optional.of(maintainCleaningRepository.save(maintainCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public MaintainCleaning updateById(final MaintainCleaning maintainCleaning, final String id) {
        return maintainCleaningRepository.findById(id).
                map(existingUser -> {
                    maintainCleaning.setId(existingUser.getId());
                    existingUser = maintainCleaning;
                    return maintainCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            maintainCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MaintainCleaning findById(final String id) {
        return maintainCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
