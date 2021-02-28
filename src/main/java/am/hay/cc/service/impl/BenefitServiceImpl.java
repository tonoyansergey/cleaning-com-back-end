package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.Benefit;
import am.hay.cc.repository.BenefitRepository;
import am.hay.cc.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Autowired
    public BenefitServiceImpl(final BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    @Override
    public List<Benefit> findAll() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit save(final Benefit benefit) {
        return Optional.of(benefitRepository.save(benefit)).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public Benefit updateById(final Benefit benefit, final String id) {
        return benefitRepository.findById(id).map(
                existingUser ->
                {
                    benefit.setId(existingUser.getId());
                    existingUser = benefit;
                    return benefitRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            benefitRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Benefit findById(final String id) {
        return benefitRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Benefit record not found"));
    }
}
