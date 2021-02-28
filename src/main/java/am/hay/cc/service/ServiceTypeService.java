package am.hay.cc.service;

import am.hay.cc.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceType> findAll();

    ServiceType save(final ServiceType serviceType);

    ServiceType updateById(final ServiceType serviceType, final String id);

    boolean deleteByID(final String id);

    ServiceType findById(final String id);
}
