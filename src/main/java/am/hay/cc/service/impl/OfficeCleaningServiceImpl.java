package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.OfficeCleaning;
import am.hay.cc.repository.OfficeCleaningRepository;
import am.hay.cc.service.OfficeCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeCleaningServiceImpl implements OfficeCleaningService {


    private final OfficeCleaningRepository officeCleaningRepository;

    @Autowired
    public OfficeCleaningServiceImpl(final OfficeCleaningRepository officeCleaningRepository) {
        this.officeCleaningRepository = officeCleaningRepository;
    }

    @Override
    public List<OfficeCleaning> findAll() {
        return officeCleaningRepository.findAll();
    }

    @Override
    public OfficeCleaning save(final OfficeCleaning officeCleaning) {
        return Optional.of(officeCleaningRepository.save(officeCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public OfficeCleaning updateById(final OfficeCleaning officeCleaning, final String id) {
        return officeCleaningRepository.findById(id).
                map(existingUser -> {
                    officeCleaning.setId(existingUser.getId());
                    existingUser = officeCleaning;
                    return officeCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            officeCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OfficeCleaning findById(final String id) {
        return officeCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
