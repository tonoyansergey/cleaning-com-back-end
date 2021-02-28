package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.HomeCleaning;
import am.hay.cc.model.ServiceType;
import am.hay.cc.repository.HomeCleaningRepository;
import am.hay.cc.service.HomeCleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeCleaningServiceImpl implements HomeCleaningService {

    private HomeCleaningRepository homeCleaningRepository;

    @Autowired
    public HomeCleaningServiceImpl(final HomeCleaningRepository homeCleaningRepository) {
        this.homeCleaningRepository = homeCleaningRepository;
    }

    @Override
    public List<HomeCleaning> findAll() {
        return homeCleaningRepository.findAll();
    }

    @Override
    public HomeCleaning save(final HomeCleaning homeCleaning) {
        return Optional.of(homeCleaningRepository.save(homeCleaning)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public HomeCleaning updateById(final HomeCleaning homeCleaning, final String id) {
        return homeCleaningRepository.findById(id).
                map(existingUser -> {
                    homeCleaning.setId(existingUser.getId());
                    existingUser = homeCleaning;
                    return homeCleaningRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            homeCleaningRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HomeCleaning findById(final String id) {
        return homeCleaningRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
