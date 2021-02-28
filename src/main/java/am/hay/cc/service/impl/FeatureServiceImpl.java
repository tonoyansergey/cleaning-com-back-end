package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.Feature;
import am.hay.cc.repository.FeatureRepository;
import am.hay.cc.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureServiceImpl(final FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    @Override
    public Feature save(final Feature feature) {
        return Optional.of(featureRepository.save(feature)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public Feature updateById(final Feature feature, final String id) {
        return featureRepository.findById(id).
                map(existingUser -> {
                    feature.setId(existingUser.getId());
                    existingUser = feature;
                    return featureRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            featureRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public Feature findById(final String id) {
        return featureRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
