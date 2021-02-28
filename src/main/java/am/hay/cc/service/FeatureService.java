package am.hay.cc.service;

import am.hay.cc.model.Feature;
import java.util.List;

public interface FeatureService {

    List<Feature> findAll();

    Feature save(final Feature feature);

    Feature updateById(final Feature feature, final String id);

    boolean deleteByID(final String id);

    Feature findById(final String id);
}
