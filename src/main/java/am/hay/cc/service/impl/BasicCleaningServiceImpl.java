package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.BasicCleaning;
import am.hay.cc.repository.BasicCleaningRepository;
import am.hay.cc.service.BasicCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasicCleaningServiceImpl implements BasicCleaningService {

    private final BasicCleaningRepository basicCleaningRepository;

    @Autowired
    public BasicCleaningServiceImpl(final BasicCleaningRepository basicCleaningRepository) {
        this.basicCleaningRepository = basicCleaningRepository;
    }

    @Override
    public List<BasicCleaning> findAll() {
        return basicCleaningRepository.findAll();
    }

    @Override
    public BasicCleaning save(final BasicCleaning basicCleaning) {
        return Optional.of(basicCleaningRepository.save(basicCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public BasicCleaning updateById(final BasicCleaning basicCleaning, final String id) {
        return basicCleaningRepository.findById(id).
                map(existingUser -> {
                    basicCleaning.setId(existingUser.getId());
                    existingUser = basicCleaning;
                    return basicCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            basicCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public BasicCleaning findById(final String id) {
        return basicCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
