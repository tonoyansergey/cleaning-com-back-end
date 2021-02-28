package am.hay.cc.service.impl;

import am.hay.cc.exception.PersistFailureException;
import am.hay.cc.exception.RecordNotFoundException;
import am.hay.cc.model.ServiceType;
import am.hay.cc.repository.ServiceTypeRepository;
import am.hay.cc.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServiceTypeServiceImpl(final ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType save(final ServiceType serviceType) {
        return Optional.of(serviceTypeRepository.save(serviceType)).orElseThrow(() -> new RecordNotFoundException("Persist not succeed"));
    }

    @Override
    public ServiceType updateById(final ServiceType serviceType, final String id) {
        return serviceTypeRepository.findById(id).
                map(existingUser -> {
                    serviceType.setId(existingUser.getId());
                    existingUser = serviceType;
                    return serviceTypeRepository.save(existingUser);
                }).orElseThrow(() -> new PersistFailureException("Persist not succeed"));
    }

    @Override
    public boolean deleteByID(final String id) {
        try {
            serviceTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ServiceType findById(final String id) {
        return serviceTypeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Feature record not found"));
    }
}
